package plugin.sonstiges.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialResources {
    public static ItemStack ErfahrenBarren(){
        ItemStack SuperGoldBlock = new ItemStack(Material.GOLD_INGOT);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§7§5§8i§x§F§F§D§2§5§7s§x§F§F§C§D§5§6e§x§F§F§C§7§5§5n§x§F§F§C§2§5§5b§x§F§F§B§C§5§4a§x§F§F§B§7§5§3r§x§F§F§B§2§5§2r§x§F§F§A§C§5§2e§x§F§F§A§7§5§1n");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }

    public static ItemStack ErfahrenFragment() {
        ItemStack SuperGold = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§9§5§8i§x§F§F§D§4§5§7s§x§F§F§D§0§5§7e§x§F§F§C§B§5§6n§x§F§F§C§7§5§5f§x§F§F§C§2§5§5r§x§F§F§B§E§5§4a§x§F§F§B§9§5§3g§x§F§F§B§5§5§3m§x§F§F§B§0§5§2e§x§F§F§A§C§5§2n§x§F§F§A§7§5§1t");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

    public static ItemStack ExplosivBarren() {
        ItemStack SuperGold = new ItemStack(Material.DRIED_KELP);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§0§0§0§0E§x§F§6§0§3§0§1x§x§E§D§0§6§0§3p§x§E§4§0§9§0§4l§x§D§A§0§D§0§5o§x§D§1§1§0§0§7s§x§C§8§1§3§0§8i§x§B§F§1§6§0§9v§x§B§6§1§9§0§Ab§x§A§D§1§C§0§Ca§x§A§3§2§0§0§Dr§x§9§A§2§3§0§Er§x§9§1§2§6§1§0e§x§8§8§2§9§1§1n");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

    public static ItemStack ExplosivPuder() {
        ItemStack SuperGold = new ItemStack(Material.GUNPOWDER);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§F§F§0§0§0§0E§x§F§5§0§3§0§1x§x§E§B§0§7§0§3p§x§E§1§0§A§0§4l§x§D§7§0§E§0§6o§x§C§D§1§1§0§7s§x§C§4§1§5§0§9i§x§B§A§1§8§0§Av§x§B§0§1§B§0§Bp§x§A§6§1§F§0§Du§x§9§C§2§2§0§Ed§x§9§2§2§6§1§0e§x§8§8§2§9§1§1r");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

    public static ItemStack KlebrigFragment() {
        ItemStack SuperGold = new ItemStack(Material.SCUTE);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§0§0§F§F§1§1K§x§0§3§F§5§1§2l§x§0§5§E§B§1§2e§x§0§8§E§1§1§3b§x§0§A§D§8§1§4r§x§0§D§C§E§1§4i§x§0§F§C§4§1§5g§x§1§2§B§A§1§6e§x§1§4§B§0§1§6r §x§1§7§A§6§1§7S§x§1§9§9§C§1§8c§x§1§C§9§2§1§8h§x§1§E§8§9§1§9l§x§2§1§7§F§1§Ae§x§2§3§7§5§1§Ai§x§2§6§6§B§1§Bm");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;
    }

    public static ItemStack KlebrigBarren() {
        ItemStack SuperGold = new ItemStack(Material.EMERALD);
        ItemMeta SuperGoldMeta = SuperGold.getItemMeta();
        SuperGoldMeta.setDisplayName("§x§0§0§F§F§1§1K§x§0§2§F§6§1§2l§x§0§5§E§D§1§2e§x§0§7§E§3§1§3b§x§0§A§D§A§1§4r§x§0§C§D§1§1§4i§x§0§E§C§8§1§5g§x§1§1§B§E§1§5e§x§1§3§B§5§1§6r §x§1§5§A§C§1§7K§x§1§8§A§3§1§7r§x§1§A§9§9§1§8i§x§1§D§9§0§1§9s§x§1§F§8§7§1§9t§x§2§1§7§E§1§Aa§x§2§4§7§4§1§Al§x§2§6§6§B§1§Bl");
        SuperGoldMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGold.setItemMeta(SuperGoldMeta);
        return SuperGold;

    }

    public static ItemStack SciFiBarren(){

        ItemStack SuperGoldBlock = new ItemStack(Material.DIAMOND);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FK§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fi§x§5§3§C§2§F§Fs§x§5§3§B§C§F§Ft§x§5§2§B§6§F§Fa§x§5§2§B§0§F§Fl§x§5§1§A§A§F§Fl");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }

    public static ItemStack SciFiFragment(){

        ItemStack SuperGoldBlock = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta SuperGoldBlockMeta = SuperGoldBlock.getItemMeta();
        SuperGoldBlockMeta.setDisplayName("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FF§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fa§x§5§3§C§2§F§Fg§x§5§3§B§C§F§Fm§x§5§2§B§6§F§Fe§x§5§2§B§0§F§Fn§x§5§1§A§A§F§Ft");
        SuperGoldBlockMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, false);
        SuperGoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SuperGoldBlock.setItemMeta(SuperGoldBlockMeta);
        return SuperGoldBlock;
    }

}

