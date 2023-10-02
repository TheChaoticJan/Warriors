package jansparadise.jansparadise.commands.InventoryCommands.GUIs;

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

public class KitCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player p)){
            sender.sendMessage("§cDu musst ein Spieler sein um §7´/kit´ §causführen zu können!");
            return true;
        }
        else {
            //Player to command

            //Inventory creation
            Inventory i = Bukkit.createInventory(p, 9, "§6WW§7-§eReloaded §7Kit");

            //WW-Kit
            ItemStack WW = new ItemStack(Material.EXPERIENCE_BOTTLE);
            ItemMeta WWMeta = WW.getItemMeta();
            WWMeta.setDisplayName("§6Westernwars §8- §7Kit");
            ArrayList<String> WWLore = new ArrayList<>();
            WWLore.add("");
            WWLore.add("§7  » Du erhältst:");
            WWLore.add("");
            WWLore.add("§8• §7834x §aErfahrungsfläschchen");
            WWLore.add("§8• §764x §5Enderperlen");
            WWLore.add("§8• §7256x §cTNT");
            WWLore.add("§8• §7256x §fSpinnenweben");
            WWLore.add("§8• §7384x §9Pfeile");
            WWLore.add("§8• §7ein besonderes §bSchwert§7, eine besondere §bAngel§7,");
            WWLore.add("§8  §7einen besonderen §bBogen §7& eine besondere §bSpitzhacke");
            WWLore.add("");
            WWMeta.setLore(WWLore);

            WWMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            WWMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            WW.setItemMeta(WWMeta);
            i.setItem(4, WW);

            p.openInventory(i);
        }


        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
