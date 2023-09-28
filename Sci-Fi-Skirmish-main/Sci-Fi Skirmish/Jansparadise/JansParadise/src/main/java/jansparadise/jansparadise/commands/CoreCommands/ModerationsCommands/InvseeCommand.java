package jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands;

import jansparadise.jansparadise.JansParadise;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InvseeCommand implements CommandExecutor, TabCompleter {

    public InvseeCommand(JansParadise plugin) {
        this.plugin = plugin;
    }

    JansParadise plugin;


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage("§cDu musst ein Spieler sein um §7´/invsee´§c ausführen zu können!");
        }else{
            Player p = (Player) sender;
            String playername = args[0];
            if(Bukkit.getServer().getPlayerExact(playername) == null || plugin.VanishList.contains(playername)){
                p.sendMessage("§cBitte benutze: §7`§e/invsee <Spieler>§7`");
                return true;
            }else if(Bukkit.getPlayerExact(playername) == p) {
                p.sendMessage("§cDas ergibt keinen Sinn, oder?");
                return true;
            }else{
                Player r = Bukkit.getServer().getPlayerExact(playername);
            Inventory PlayerInv = Bukkit.createInventory(p, 54, "§8Inventar von " + r.getDisplayName());

                for(int l = 0; l <= 35; l++){
                    PlayerInv.setItem(l, r.getInventory().getItem(l));
                }


                //Trennglas bauen
                ItemStack Glas = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta Glasmeta = Glas.getItemMeta();
                Glasmeta.setDisplayName("_".replace("_", " "));
                Glasmeta.addEnchant(Enchantment.MENDING, 1 , true);
                Glasmeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                Glas.setItemMeta(Glasmeta);

                //Trennglas benutzen
                PlayerInv.setItem(36, Glas);
                PlayerInv.setItem(37, Glas);
                PlayerInv.setItem(38, Glas);
                PlayerInv.setItem(39, Glas);
                PlayerInv.setItem(40, Glas);
                PlayerInv.setItem(41, Glas);
                PlayerInv.setItem(42, Glas);
                PlayerInv.setItem(43, Glas);
                PlayerInv.setItem(44, Glas);

                PlayerInv.setItem(45, r.getInventory().getHelmet());
                PlayerInv.setItem(46, r.getInventory().getChestplate());
                PlayerInv.setItem(47, r.getInventory().getLeggings());
                PlayerInv.setItem(48, r.getInventory().getBoots());
                PlayerInv.setItem(53, r.getInventory().getItemInOffHand());

                p.openInventory(PlayerInv);

            }

        }
        return true;
    }




    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length == 1){
           return null;
        }

        return Collections.singletonList("");
    }
}

