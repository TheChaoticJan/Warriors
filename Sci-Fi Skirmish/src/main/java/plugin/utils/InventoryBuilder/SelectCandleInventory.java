package plugin.utils.InventoryBuilder;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import plugin.utils.ItemBuilder.Candles;
import plugin.utils.ItemBuilder.InventoryEssentials;

import java.util.Objects;

public class SelectCandleInventory {

    public static Inventory selectCandle(Player player, String currenttype){

        Inventory inventory = Bukkit.createInventory(player, 27, MiniMessage.miniMessage().deserialize("<rainbow>Wähle den Kerzentyp aus!"));

        for(int i = 0; i <=9; i++){
            inventory.setItem(i, InventoryEssentials.glass());
        }
        for(int i = 11; i <= 17; i = i + 2){
            inventory.setItem(i, InventoryEssentials.glass());
        }
        for(int i = 18; i <=26; i++){
            inventory.setItem(i, InventoryEssentials.glass());
        }

        //Adding Candles to the Inventory
        ItemStack boostCandle = Candles.boostCandle();
        if(!currenttype.equals("boost")){
            boostCandle.removeEnchantment(Enchantment.DURABILITY);
        }else{
           Objects.requireNonNull(boostCandle.getItemMeta().getLore()).add("");
           Objects.requireNonNull(boostCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(10, boostCandle);

        ItemStack healCandle = Candles.healCandle();
        if(!currenttype.equals("heal")){
            healCandle.removeEnchantment(Enchantment.DURABILITY);
        }else{
            Objects.requireNonNull(healCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(healCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(12, healCandle);

        ItemStack crateCandle = Candles.crateCandle();
        if(!currenttype.equals("crate")){
            crateCandle.removeEnchantment(Enchantment.DIG_SPEED);
        }else{
            Objects.requireNonNull(crateCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(crateCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(14, crateCandle);

        ItemStack teleportCandle = Candles.teleportCandle();
        if(!currenttype.equals("teleport")){
            teleportCandle.removeEnchantment(Enchantment.DIG_SPEED);
        }else{
            Objects.requireNonNull(teleportCandle.getItemMeta().getLore()).add("");
            Objects.requireNonNull(teleportCandle.getItemMeta().getLore()).add("§aIm Moment ausgewählt!");
        }
        inventory.setItem(16, teleportCandle);


        return inventory;

    }

}
