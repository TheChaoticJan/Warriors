package plugin.commands.ModerationsCommands;

import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.util.Collections;
import java.util.List;

public class InvseeCommand implements CommandExecutor, TabCompleter {

    public InvseeCommand(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(!(sender instanceof Player p)){
            sender.sendMessage("§cDu musst ein Spieler sein um §7´/invsee´§c ausführen zu können!");
        }else{
            if(args.length == 0){
                sender.sendMessage("§cWem genau willst du denn so ins Inventar schauen? Bitte nutze §7'§e/invsee <Spieler>§7'");
                return true;
            }
            String playerName = args[0];
            if(Bukkit.getServer().getPlayerExact(playerName) == null || plugin.VanishList.contains(playerName)){
                p.sendMessage("§cBitte benutze: §7`§e/invsee <Spieler>§7`");
                return true;
            }else if(Bukkit.getPlayerExact(playerName) == p) {
                p.sendMessage("§cDas ergibt keinen Sinn, oder?");
                return true;
            }else{
                Player r = Bukkit.getServer().getPlayerExact(playerName);
            Inventory PlayerInv = Bukkit.createInventory(p, 54, "§8Inventar von " + r.getDisplayName());

                for(int l = 0; l <= 35; l++){
                    PlayerInv.setItem(l, r.getInventory().getItem(l));
                }


                //Trennglas bauen
                ItemStack Glas = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta Glasmeta = Glas.getItemMeta();
                Glasmeta.setDisplayName("_".replace("_", " "));
                Glas.setItemMeta(Glasmeta);

                //Trennglas benutzen
                for(int i = 36; i <= 44; i++){
                    PlayerInv.setItem(i, Glas);
                }

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

