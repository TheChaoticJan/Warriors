package plugin.utils.InventoryBuilder;

import plugin.utils.Infobar.Infobar;
import plugin.models.PlayerStats;
import plugin.utils.ItemBuilder.Inventarteile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InfobarInventories {


    public static Inventory edit(Player p, ArrayList<ItemStack> list, String name){

        Inventory i = Bukkit.createInventory(p, 45, name);

        ItemStack current = null;
        if(name.endsWith("1")){
            current = list.get(0);
        }
        if(name.endsWith("2")){
            current = list.get(1);
        }
        if(name.endsWith("3")){
            current = list.get(2);
        }
        i.setItem(0, Inventarteile.Zurück());

        for(int i1 = 1; i1<= 12; i1++){
            i.setItem(i1, Inventarteile.Glass());
        }
        i.setItem(13, current);

        for(int i2 = 14; i2 <= 27; i2++){
            i.setItem(i2, Inventarteile.Glass());
        }
        i.setItem(28, Infobar.Dura());
        i.setItem(29, Infobar.XP());
        i.setItem(30, Infobar.Enderpearl());
        i.setItem(31, Infobar.Konto());
        i.setItem(32, Infobar.tnt());
        i.setItem(33, Infobar.Webs());
        i.setItem(34, Infobar.MainHand());

        for(int i3 = 35; i3 <= 44; i3++){
            i.setItem(i3, Inventarteile.Glass());
        }

       return i;
    }

    public static Inventory introduction(Player p, PlayerStats stats){


        Inventory Configuration = Bukkit.createInventory(p, 36, "§6§lConfiguriere deine Infobar!");
        for(int i = 0; i <= 9; i++){
            Configuration.setItem(i, Inventarteile.Glass());
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

        Configuration.setItem(10, Inventarteile.Glass());
        Configuration.setItem(12, Inventarteile.Glass());

        ModuleMeta.setDisplayName("§3Modul 2");
        ModuleItem.setItemMeta(ModuleMeta);
        Configuration.setItem(13, ModuleItem);

        Configuration.setItem(14, Inventarteile.Glass());
        Configuration.setItem(16, Inventarteile.Glass());

        ModuleMeta.setDisplayName("§3Modul 3");
        ModuleItem.setItemMeta(ModuleMeta);
        Configuration.setItem(15, ModuleItem);

        for(int i = 17; i <= 35; i++){
            Configuration.setItem(i, Inventarteile.Glass());
        }

        Configuration.setItem(20, Infobar.neededItemstack(stats).get(0));
        Configuration.setItem(22, Infobar.neededItemstack(stats).get(1));
        Configuration.setItem(24, Infobar.neededItemstack(stats).get(2));

        return Configuration;

    }
}
