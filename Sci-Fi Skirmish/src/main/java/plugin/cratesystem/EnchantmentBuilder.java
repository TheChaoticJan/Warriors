package plugin.cratesystem;

import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.Random;

public class EnchantmentBuilder {

    public static Enchantment RandomEnchant(int raritylevel){
        ArrayList<Enchantment> EnchantList = new ArrayList<>();
        EnchantList.add(Enchantment.DAMAGE_ALL);
        EnchantList.add(Enchantment.PROTECTION_FIRE);
        EnchantList.add(Enchantment.ARROW_DAMAGE);
        EnchantList.add(Enchantment.PROTECTION_ENVIRONMENTAL);
        EnchantList.add(Enchantment.PROTECTION_FALL);
        EnchantList.add(Enchantment.PROTECTION_PROJECTILE);
        EnchantList.add(Enchantment.PROTECTION_EXPLOSIONS);
        EnchantList.add(Enchantment.ARROW_DAMAGE);
        EnchantList.add(Enchantment.DURABILITY);
        EnchantList.add(Enchantment.OXYGEN);
        EnchantList.add(Enchantment.THORNS);
        EnchantList.add(Enchantment.DIG_SPEED);
        if(raritylevel >= 5) {
            EnchantList.add(Enchantment.MENDING);
        }
        Enchantment Enchantment = EnchantList.get(new Random().nextInt(EnchantList.size())); {
        }

       return Enchantment;

    }

}
