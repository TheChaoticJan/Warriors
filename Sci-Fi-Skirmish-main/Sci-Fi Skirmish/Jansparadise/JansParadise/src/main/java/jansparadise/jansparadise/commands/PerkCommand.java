package jansparadise.jansparadise.commands;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Füllerglas;
import jansparadise.jansparadise.sonstiges.Scoreboardbuilder.ScoreBoardBuilder;
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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerkCommand implements CommandExecutor, TabCompleter {

    JansParadise plugin;

    public PerkCommand(JansParadise plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){

            try{
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                if(stats == null){
                    stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }

                Inventory Perks = Bukkit.createInventory(p, 45, "§c§lPerks");
                for(int i = 0; i <= 9; i++){
                    Perks.setItem(i, Füllerglas.Glas());

                    //Armorerperk
                    ItemStack ArmorerPerk = new ItemStack(Material.LODESTONE);
                    ItemMeta ArmorerMeta = ArmorerPerk.getItemMeta();
                    ArmorerMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    ArmorerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                    ArmorerMeta.setDisplayName("§3§oRüstungsfanatiker");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("§7Mit dem §3Rüstungsfanatiker §7Perk");
                    lore.add("§7hast du eine kleine Chance, dass");
                    lore.add("§7dein §ckaputtestes Rüstungsteil");
                    lore.add("§7um 10 Haltbarkeit §arepariert wird§7!");
                    ArmorerMeta.setLore(lore);
                    ArmorerPerk.setItemMeta(ArmorerMeta);

                    Perks.setItem(10, ArmorerPerk);

                }
                p.openInventory(Perks);

            }catch (SQLException e){
                e.printStackTrace();
            }


        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
