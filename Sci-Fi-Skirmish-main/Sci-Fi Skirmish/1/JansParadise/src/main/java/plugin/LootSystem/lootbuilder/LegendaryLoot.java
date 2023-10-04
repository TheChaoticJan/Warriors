package plugin.LootSystem.lootbuilder;

import plugin.LootSystem.enchantmentbuilder.EnchantmentBuilder;
import plugin.sonstiges.ItemBuilder.SpecialResources;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public class LegendaryLoot {

    public static ItemStack LegendaryDrop(){

        ArrayList CommonDrops = new ArrayList();
        ItemStack Drop1 = new ItemStack(Material.EXPERIENCE_BOTTLE, 12);
        CommonDrops.add(Drop1);
        ItemStack Drop2 = new ItemStack(Material.TNT, 4);
        CommonDrops.add(Drop2);
        ItemStack Drop3 = new ItemStack(Material.ENDER_PEARL, 3);
        CommonDrops.add(Drop3);
        ItemStack Drop4 = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 1);
        CommonDrops.add(Drop4);
        ItemStack Drop5 = new ItemStack(SpecialResources.ErfahrenFragment());
        ItemStack Drop6 = new ItemStack(SpecialResources.SciFiFragment());
        ItemStack Drop7 = new ItemStack(SpecialResources.KlebrigFragment());
        ItemStack Drop8 = new ItemStack(SpecialResources.ExplosivPuder());
        CommonDrops.add(Drop5);
        CommonDrops.add(Drop6);
        CommonDrops.add(Drop7);
        CommonDrops.add(Drop8);
        CommonDrops.add(new ItemStack(Material.APPLE, 3));
        CommonDrops.add(new ItemStack(Material.COBWEB, 6));
        CommonDrops.add(new ItemStack(Material.BOOK, 5));

        ItemStack Drop9 = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta EnchantMeta = (EnchantmentStorageMeta) Drop9.getItemMeta();
        EnchantMeta.addStoredEnchant(EnchantmentBuilder.RandomEnchant(), 3, false);
        Drop9.setItemMeta(EnchantMeta);
        CommonDrops.add(Drop9);

        ItemStack Drop10 = new ItemStack(Material.POTION);
        PotionMeta potionMeta = (PotionMeta) Drop10.getItemMeta();
        potionMeta.setDisplayName("§bSpeed");
        potionMeta.setColor(Color.AQUA);
        PotionEffect potionEffect = new PotionEffect(PotionEffectType.SPEED, 3600, 1);
        potionMeta.addCustomEffect(potionEffect, true);
        Drop10.setItemMeta(potionMeta);
        CommonDrops.add(Drop10);

        CommonDrops.add(new ItemStack(Material.DIAMOND, 2));

        ItemStack Drop = new ItemStack( (ItemStack) CommonDrops.get(new Random().nextInt(CommonDrops.size())));
        return Drop;
    }

}
