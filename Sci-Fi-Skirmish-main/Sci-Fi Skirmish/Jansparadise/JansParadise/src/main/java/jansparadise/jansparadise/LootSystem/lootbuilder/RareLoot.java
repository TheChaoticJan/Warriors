package jansparadise.jansparadise.LootSystem.lootbuilder;

import jansparadise.jansparadise.LootSystem.enchantmentbuilder.EnchantmentBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Random;

public class RareLoot {

    public static ItemStack RareDrop(){

        ArrayList CommonDrops = new ArrayList();
        ItemStack Drop1 = new ItemStack(Material.EXPERIENCE_BOTTLE, 8);
        CommonDrops.add(Drop1);
        ItemStack Drop2 = new ItemStack(Material.ENDER_PEARL, 2);
        CommonDrops.add(Drop2);
        ItemStack Drop3 = new ItemStack(Material.TNT, 3);
        CommonDrops.add(Drop3);
        ItemStack Drop4 = new ItemStack(Material.GOLDEN_APPLE, 1);
        CommonDrops.add(Drop4);
        ItemStack Drop5 = new ItemStack(Material.BOW);
        ItemMeta BowMeta = Drop5.getItemMeta();
        BowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
        BowMeta.addEnchant(Enchantment.DURABILITY, 2, true);
        Drop5.setItemMeta(BowMeta);
        CommonDrops.add(Drop5);
        ItemStack Drop6 = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta EnchantMeta = (EnchantmentStorageMeta) Drop6.getItemMeta();
        EnchantMeta.addStoredEnchant(EnchantmentBuilder.RandomEnchant(), 3, false);
        Drop6.setItemMeta(EnchantMeta);
        CommonDrops.add(Drop6);
        ItemStack Drop7 = new ItemStack(Material.IRON_SWORD);
        ItemMeta SwordMeta = Drop7.getItemMeta();
        SwordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        SwordMeta.addEnchant(Enchantment.DAMAGE_ALL, 5, true);
        SwordMeta.addEnchant(Enchantment.VANISHING_CURSE, 2, true);
        SwordMeta.setDisplayName("§x§F§F§0§0§7§CS§x§F§F§0§9§7§2c§x§F§F§1§1§6§7h§x§F§F§1§A§5§Dw§x§F§F§2§2§5§3e§x§F§F§2§B§4§8r§x§F§F§3§4§3§Et §x§F§F§3§C§3§4d§x§F§F§4§5§2§9e§x§F§F§4§D§1§Fs §x§F§F§5§6§1§5d§x§F§F§5§E§0§Aü§x§F§F§6§7§0§0s§x§F§E§7§3§0§1t§x§F§D§7§F§0§2e§x§F§D§8§C§0§3r§x§F§C§9§8§0§4e§x§F§B§A§4§0§5n §x§F§A§B§0§0§6G§x§F§9§B§C§0§6e§x§F§8§C§8§0§7i§x§F§8§D§5§0§8s§x§F§7§E§1§0§9t§x§F§6§E§D§0§Ae§x§F§5§F§9§0§Bs");
        ArrayList lore = new ArrayList();
        lore.add("");
        lore.add("§7Dieses Schwert verschwindet so ");
        lore.add("§7schnell wie es kam, wenn du §cstirbst!");
        lore.add("");
        SwordMeta.setLore(lore);
        Drop7.setItemMeta(SwordMeta);
        CommonDrops.add(Drop7);
        ItemStack Drop8 = new ItemStack(Material.GOLD_NUGGET, 6);
        ItemStack Drop9 = new ItemStack(Material.GUNPOWDER, 6);
        ItemStack Drop10 = new ItemStack(Material.AMETHYST_SHARD, 6);
        ItemStack Drop11 = new ItemStack(Material.SCUTE, 6);
        CommonDrops.add(Drop8);
        CommonDrops.add(Drop9);
        CommonDrops.add(Drop10);
        CommonDrops.add(Drop11);
        ItemStack Drop12 = new ItemStack(Material.FISHING_ROD);
        ItemMeta drop12ItemMeta = Drop12.getItemMeta();
        drop12ItemMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        drop12ItemMeta.addEnchant(Enchantment.LUCK, 2, true);
        Drop12.setItemMeta(drop12ItemMeta);
        CommonDrops.add(Drop12);
        CommonDrops.add(new ItemStack(Material.IRON_INGOT, 4));

        ItemStack Drop = new ItemStack( (ItemStack) CommonDrops.get(new Random().nextInt(CommonDrops.size())));
        return Drop;
    }

}
