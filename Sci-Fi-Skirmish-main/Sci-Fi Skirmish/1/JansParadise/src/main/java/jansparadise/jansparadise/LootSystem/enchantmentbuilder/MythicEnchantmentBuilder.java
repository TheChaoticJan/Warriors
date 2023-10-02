package jansparadise.jansparadise.LootSystem.enchantmentbuilder;

import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.Random;

public class MythicEnchantmentBuilder{

    public static Enchantment RandomEnchant(){
        ArrayList EnchantList = new ArrayList();
        EnchantList.add(Enchantment.DAMAGE_ALL);
        EnchantList.add(Enchantment.ARROW_DAMAGE);
        EnchantList.add(Enchantment.PROTECTION_ENVIRONMENTAL);
        EnchantList.add(Enchantment.PROTECTION_FALL);
        EnchantList.add(Enchantment.ARROW_DAMAGE);
        EnchantList.add(Enchantment.DURABILITY);
        EnchantList.add(Enchantment.OXYGEN);
        EnchantList.add(Enchantment.MENDING);
        Enchantment Enchantment = (Enchantment) EnchantList.get(new Random().nextInt(EnchantList.size())); {
        }

        return Enchantment;
    }

}
