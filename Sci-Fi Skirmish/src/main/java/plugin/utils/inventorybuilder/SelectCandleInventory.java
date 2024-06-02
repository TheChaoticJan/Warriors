package plugin.utils.inventorybuilder;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import plugin.utils.itembuilder.Candles;

import java.util.Objects;

public class SelectCandleInventory {

    public static Inventory selectCandle(Player player, String currenttype){

        Inventory inventory = Bukkit.createInventory(player, InventoryType.HOPPER, MiniMessage.miniMessage().deserialize("<rainbow>Wähle den Kerzentyp aus!"));

        //Adding Candles to the Inventory
        ItemStack boostCandle = Candles.boostCandle();
        if(!currenttype.equals("boost")){
            boostCandle.removeEnchantment(Enchantment.DURABILITY);
        }else{
           Objects.requireNonNull(boostCandle.getItemMeta().getLore()).add("");
           Objects.requireNonNull(boostCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(0, boostCandle);

        ItemStack healCandle = Candles.healCandle();
        if(!currenttype.equals("heal")){
            healCandle.removeEnchantment(Enchantment.DURABILITY);
        }else{
            Objects.requireNonNull(healCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(healCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(1, healCandle);

        ItemStack crateCandle = Candles.crateCandle();
        if(!currenttype.equals("crate")){
            crateCandle.removeEnchantment(Enchantment.DIG_SPEED);
        }else{
            Objects.requireNonNull(crateCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(crateCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(3, crateCandle);

        ItemStack teleportCandle = Candles.teleportCandle();
        if(!currenttype.equals("teleport")){
            teleportCandle.removeEnchantment(Enchantment.DIG_SPEED);
        }else{
            Objects.requireNonNull(teleportCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(teleportCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(4, teleportCandle);


        return inventory;

    }

}
