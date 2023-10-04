package plugin.LootSystem.lootbuilder;

import plugin.LootSystem.enchantmentbuilder.EnchantmentBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Random;

public class UncommonLoot {

    public static ItemStack UncommonDrop(){

        ArrayList CommonDrops = new ArrayList();
        ItemStack Drop1 = new ItemStack(Material.EXPERIENCE_BOTTLE, 6);
        CommonDrops.add(Drop1);
        ItemStack Drop2 = new ItemStack(Material.TNT, 2);
        CommonDrops.add(Drop2);
        ItemStack Drop3 = new ItemStack(Material.GOLD_NUGGET, 4);
        CommonDrops.add(Drop3);
        ItemStack Drop4 = new ItemStack(Material.ENDER_PEARL, 1);
        CommonDrops.add(Drop4);
        ItemStack Drop5 = new ItemStack(Material.STRING, 4);
        CommonDrops.add(Drop5);
        ItemStack Drop6 = new ItemStack(Material.ARROW, 6);
        CommonDrops.add(Drop6);
        ItemStack Drop7 = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta BookMeta = (EnchantmentStorageMeta) Drop7.getItemMeta();
        BookMeta.addStoredEnchant(EnchantmentBuilder.RandomEnchant(), 2, false);
        Drop7.setItemMeta(BookMeta);
        CommonDrops.add(Drop7);
        ItemStack Drop8 = new ItemStack(Material.BOOK,2);
        CommonDrops.add(Drop8);
        ItemStack Drop9 = new ItemStack(Material.IRON_INGOT, 3);
        CommonDrops.add(Drop9);
        ItemStack Drop10 = new ItemStack(Material.AMETHYST_SHARD, 4);
        CommonDrops.add(Drop10);
        ItemStack Drop11 = new ItemStack(Material.SCUTE, 4);
        CommonDrops.add(Drop11);
        ItemStack Drop12 = new ItemStack(Material.GUNPOWDER, 4);
        CommonDrops.add(Drop12);
        ItemStack Drop13 = new ItemStack(Material.COBWEB, 2);
        CommonDrops.add(Drop13);
        ItemStack Drop14 = new ItemStack(Material.STONE_SWORD);
        CommonDrops.add(Drop14);
        ItemStack rod = new ItemStack(Material.FISHING_ROD);
        ItemMeta rodmeta = rod.getItemMeta();
        rodmeta.addEnchant(Enchantment.DURABILITY, 1, false);
        rod.setItemMeta(rodmeta);
        CommonDrops.add(rod);
        ItemStack Drop15 = new ItemStack(Material.APPLE, 2);
        CommonDrops.add(Drop15);

        ItemStack Drop = new ItemStack( (ItemStack) CommonDrops.get(new Random().nextInt(CommonDrops.size())));
        return Drop;
    }

}