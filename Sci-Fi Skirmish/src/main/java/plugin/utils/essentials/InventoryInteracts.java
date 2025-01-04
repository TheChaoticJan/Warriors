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

    public static void checkSpecialItemDrops(Player d) {

        final String [] types = {"§eSci-Fi", "§eErfahren"};
        final Material [] items = {Material.ENDER_PEARL, Material.EXPERIENCE_BOTTLE};
        final int [] amounts = {0, 5};

        for(int i = 0; i < types.length; i++) {
            if (d.getItemInHand().getItemMeta() == null) {
                return;
            }
                if (d.getItemInHand().getItemMeta().getLore() != null) {
                    if (d.getItemInHand().getItemMeta().getLore().contains(types[i])){
                        boolean bl = false;
                        int random = (int) (Math.random() * 300) + 1;
                        if (random == 1) {
                            for(int k = 0; k <= amounts[i]; k++) {
                                for (int l = 0; l < 36; l++) {
                                    if (d.getInventory().getItem(l) == null || Objects.requireNonNull(d.getInventory().getItem(l)).getType() == items[i] && Objects.requireNonNull(d.getInventory().getItem(l)).getAmount() <= 15) {
                                        bl = true;
                                    }
                                }
                                if (bl) {
                                    d.getInventory().addItem(new ItemStack(items[i]));
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(items[i]));
                                }
                            }

                            switch (i){
                                case 0 -> new Bossbars().sciFiBar(d);
                                case 1 -> new Bossbars().erfahrenBar(d);
                            }
                        }
                    }
                }
        }
    }


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