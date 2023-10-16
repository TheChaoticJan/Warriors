package plugin.utils.ItemBuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Inventarteile {

    public static ItemStack Glass() {
        ItemStack Glas = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta GlasMeta = Glas.getItemMeta();
        GlasMeta.setDisplayName("_".replace("_", " "));
        Glas.setItemMeta(GlasMeta);
        return Glas;
    }

    public static ItemStack Baublöcke() {
        ItemStack BBlock = new ItemStack(Material.SANDSTONE);

        ItemMeta BlockMeta = BBlock.getItemMeta();
        BlockMeta.setDisplayName("§6§oBaublöcke");
        BBlock.setItemMeta(BlockMeta);

        return BBlock;

    }

    public static ItemStack Zurück() {
        ItemStack i = new ItemStack(Material.RED_DYE);
        ItemMeta d = i.getItemMeta();
        d.setDisplayName("§cZurück");
        d.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        d.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        i.setItemMeta(d);
        return i;
    }
}
