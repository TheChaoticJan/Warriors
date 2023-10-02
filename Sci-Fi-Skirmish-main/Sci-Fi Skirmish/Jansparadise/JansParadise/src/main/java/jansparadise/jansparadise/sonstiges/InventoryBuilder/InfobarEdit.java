package jansparadise.jansparadise.sonstiges.InventoryBuilder;

import jansparadise.jansparadise.sonstiges.ItemBuilder.Infobar;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Fuellerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.ZurückButton;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class InfobarEdit {


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

        i.setItem(0, ZurückButton.Zurück());

        for(int i1 = 1; i1<= 12; i1++){
            i.setItem(i1, Fuellerglas.Glas());
        }
        i.setItem(13, current);

        for(int i2 = 14; i2 <= 27; i2++){
            i.setItem(i2, Fuellerglas.Glas());
        }

        i.setItem(28, Infobar.Dura());
        i.setItem(29, Infobar.XP());
        i.setItem(30, Infobar.Enderpearl());
        i.setItem(31, Fuellerglas.Glas());
        i.setItem(32, Infobar.Konto());
        i.setItem(33, Infobar.tnt());
        i.setItem(34, Infobar.Webs());

        for(int i3 = 35; i3 <= 44; i3++){
            i.setItem(i3, Fuellerglas.Glas());
        }

       return i;
    }
}
