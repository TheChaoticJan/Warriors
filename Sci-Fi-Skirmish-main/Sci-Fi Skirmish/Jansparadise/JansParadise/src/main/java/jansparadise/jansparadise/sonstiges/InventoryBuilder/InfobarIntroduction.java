package jansparadise.jansparadise.sonstiges.InventoryBuilder;

import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Infobar;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Fuellerglas;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InfobarIntroduction {

    public static Inventory introduction(Player p, PlayerStats stats){


        Inventory Configuration = Bukkit.createInventory(p, 36, "§6§lConfiguriere deine Infobar!");
        for(int i = 0; i <= 9; i++){
            Configuration.setItem(i, Fuellerglas.Glas());
        }

        ItemStack ModuleItem = new ItemStack(Material.LEGACY_EMPTY_MAP);
        ItemMeta ModuleMeta =ModuleItem.getItemMeta();
        ModuleMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        ModuleMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ModuleMeta.setDisplayName("§3Modul 1");
        ArrayList<String> ModuleLore = new ArrayList<>();
        ModuleLore.add("");
        ModuleLore.add("§7*Rechtsklick*");
        ModuleLore.add("§6Bearbeiten");
        ModuleMeta.setLore(ModuleLore);
        ModuleItem.setItemMeta(ModuleMeta);
        Configuration.setItem(11, ModuleItem);

        Configuration.setItem(10, Fuellerglas.Glas());
        Configuration.setItem(12, Fuellerglas.Glas());

        ModuleMeta.setDisplayName("§3Modul 2");
        ModuleItem.setItemMeta(ModuleMeta);
        Configuration.setItem(13, ModuleItem);

        Configuration.setItem(14, Fuellerglas.Glas());
        Configuration.setItem(16, Fuellerglas.Glas());

        ModuleMeta.setDisplayName("§3Modul 3");
        ModuleItem.setItemMeta(ModuleMeta);
        Configuration.setItem(15, ModuleItem);

        for(int i = 17; i <= 35; i++){
            Configuration.setItem(i, Fuellerglas.Glas());
        }

        Configuration.setItem(20, Infobar.neededItemstack(stats).get(0));
        Configuration.setItem(22, Infobar.neededItemstack(stats).get(1));
        Configuration.setItem(24, Infobar.neededItemstack(stats).get(2));

        return Configuration;

    }
}
