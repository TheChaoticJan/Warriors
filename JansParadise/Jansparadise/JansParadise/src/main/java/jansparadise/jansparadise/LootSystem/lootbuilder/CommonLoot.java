package jansparadise.jansparadise.LootSystem.lootbuilder;

import jansparadise.jansparadise.LootSystem.enchantmentbuilder.EnchantmentBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class CommonLoot {


    public static ItemStack CommonDrop(){

        ArrayList CommonDrops = new ArrayList();
        ItemStack Drop1 = new ItemStack(Material.EXPERIENCE_BOTTLE, 3);
        CommonDrops.add(Drop1);
        ItemStack Drop2 = new ItemStack(Material.TNT, 1);
        CommonDrops.add(Drop2);
        ItemStack Drop3 = new ItemStack(Material.STICK, 2);
        CommonDrops.add(Drop3);
        ItemStack Drop5 = new ItemStack(Material.STRING, 2);
        CommonDrops.add(Drop5);
        ItemStack Drop6 = new ItemStack(Material.ARROW, 4);
        CommonDrops.add(Drop6);
        ItemStack Drop7 = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta BookMeta = (EnchantmentStorageMeta) Drop7.getItemMeta();
        BookMeta.addStoredEnchant(EnchantmentBuilder.RandomEnchant(), 1, false);
        Drop7.setItemMeta(BookMeta);
        CommonDrops.add(Drop7);
        ItemStack Drop8 = new ItemStack(Material.BOOK,1);
        CommonDrops.add(Drop8);
        ItemStack Drop9 = new ItemStack(Material.IRON_INGOT, 1);
        CommonDrops.add(Drop9);
        ItemStack Drop10 = new ItemStack(Material.GOLD_NUGGET, 2);
        CommonDrops.add(Drop10);
        ItemStack Drop11 = new ItemStack(Material.AMETHYST_SHARD, 2);
        CommonDrops.add(Drop11);
        ItemStack Drop12 = new ItemStack(Material.GUNPOWDER, 2);
        CommonDrops.add(Drop12);
        ItemStack Drop13 = new ItemStack(Material.SCUTE);
        CommonDrops.add(Drop13);
        ItemStack Drop14 = new ItemStack(Material.COBWEB, 1);
        CommonDrops.add(Drop14);
        ItemStack Drop15 = new ItemStack(Material.APPLE);
        CommonDrops.add(Drop15);

        ItemStack Drop = new ItemStack( (ItemStack) CommonDrops.get(new Random().nextInt(CommonDrops.size())));
        return Drop;
    }

}
