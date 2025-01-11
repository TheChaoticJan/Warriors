package plugin.utils.essentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

import static java.lang.Float.POSITIVE_INFINITY;

public class InventoryInteracts {




    public static void healArmorPieces(Player player, int amount){

        String value = "§aNichts";
        Count counted = new Count(player);

        int HDura = counted.getHelmetDura();
        int CDura = counted.getChestDura();
        int LDura = counted.getLeggingsDura();
        int BDura = counted.getBootsDura();

        if(HDura == CDura && HDura == LDura && HDura == BDura && HDura == 10000){
            new Bossbars().healBar(player, value, 0);
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
            return;
        }

        ItemStack lowest = null;
        int lowestDurability = (int) POSITIVE_INFINITY;
        int pos = 0;
        int temp = 0;

        for(ItemStack stack : player.getInventory().getArmorContents()) {
            if(stack == null){
                break;
            }
            if(stack.getType().getMaxDurability() == 0)
            {
                continue;
            }
            if(stack.getType().getMaxDurability() - stack.getDurability() < lowestDurability)
            {
                lowestDurability = stack.getType().getMaxDurability() - stack.getDurability();
                lowest = stack;
                pos = temp;
            }
            temp++;
        }

        if(!(lowest == null)){
            lowest.setDurability((short) (player.getInventory().getHelmet().getDurability() - amount));
        }

        switch (pos) {
            case 0 -> {value = "Schuhe";}
            case 1 -> {value = "Hose";}
            case 2 -> {value = "Brustplatte";}
            case 3 -> {value = "Helm";}
            default -> {value = "§cNichts";}
        }

        new Bossbars().healBar(player, value, amount);
    }

}