package plugin.cratesystem;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CrateBook {

    private @Getter static ItemStack book = null;

    private static HashMap<Enchantment, String> names = new HashMap<>();
    public CrateBook(boolean mythic, int maxlevel){

        names.put(Enchantment.DAMAGE_ALL, "Schärfe");
        names.put(Enchantment.PROTECTION_FIRE, "Feuerschutz");
        names.put(Enchantment.ARROW_DAMAGE, "Stärke");
        names.put(Enchantment.PROTECTION_ENVIRONMENTAL, "Schutz");
        names.put(Enchantment.PROTECTION_FALL, "Federfall");
        names.put(Enchantment.PROTECTION_PROJECTILE, "Schussicher");
        names.put(Enchantment.DURABILITY, "Haltbarkeit");
        names.put(Enchantment.MENDING, "§lReperatur");
        names.put(Enchantment.THORNS, "Dornen");
        names.put(Enchantment.DIG_SPEED, "Effizenz");
        names.put(Enchantment.OXYGEN, "Atmung");
        names.put(Enchantment.PROTECTION_EXPLOSIONS, "Explosionsschutz");

        ArrayList<Enchantment> EnchantList = new ArrayList<>();
        EnchantList.add(Enchantment.DAMAGE_ALL);
        EnchantList.add(Enchantment.PROTECTION_FIRE);
        EnchantList.add(Enchantment.ARROW_DAMAGE);
        EnchantList.add(Enchantment.PROTECTION_ENVIRONMENTAL);
        EnchantList.add(Enchantment.PROTECTION_FALL);
        EnchantList.add(Enchantment.PROTECTION_PROJECTILE);
        EnchantList.add(Enchantment.PROTECTION_EXPLOSIONS);
        EnchantList.add(Enchantment.DURABILITY);
        EnchantList.add(Enchantment.OXYGEN);
        EnchantList.add(Enchantment.THORNS);
        EnchantList.add(Enchantment.DIG_SPEED);
        if(mythic) {
            EnchantList.add(Enchantment.MENDING);
        }
        ItemStack book = new ItemStack(Material.ENCHANTED_BOOK, 1);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) book.getItemMeta();
        Enchantment enchantment = EnchantList.get(new Random().nextInt(EnchantList.size()));

        meta.addStoredEnchant(enchantment, Math.min(maxlevel, enchantment.getMaxLevel()), false);
        meta.setDisplayName("§d✯ " + names.get(enchantment) + " §f" + meta.getStoredEnchants().get(enchantment));
        book.setItemMeta(meta);

        CrateBook.book = book;
    }

}
