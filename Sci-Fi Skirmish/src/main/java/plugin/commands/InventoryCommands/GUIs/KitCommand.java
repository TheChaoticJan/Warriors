package plugin.commands.InventoryCommands.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
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
            //WW-Kit Description
            ItemStack WW = new ItemStack(Material.EXPERIENCE_BOTTLE);
            ItemMeta WWMeta = WW.getItemMeta();
            WWMeta.setDisplayName("§6Westernwars §8- §7Kit");
            ArrayList<String> WWLore = new ArrayList<>();
            WWLore.add("§8» §f§nDu erhältst:");
            WWLore.add("§8• §7834x §aErfahrungsfläschchen");
            WWLore.add("§8• §764x §5Enderperlen");
            WWLore.add("§8• §7256x §cTNT");
            WWLore.add("§8• §7256x §fSpinnenweben");
            WWLore.add("§8• §7384x §9Pfeile");
            WWLore.add("§8• §bSchwert§f, §bAngel§f, §bBogen §f& §bSpitzhacke");
            WWLore.add("§8• §bFull Prot IV Diarep");
            WWMeta.setLore(WWLore);

            WWMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
            WWMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

            WW.setItemMeta(WWMeta);

            Inventory inventory = Bukkit.createInventory(p, InventoryType.HOPPER, "          §6Westernwars §0Kit");
            inventory.setItem(2, WW);

            p.openInventory(inventory);
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
