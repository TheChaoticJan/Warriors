package plugin.utils.essentials;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Objects;

public class InventoryInteracts {

    public static void checkSpeicalitemDrops(Player d) {

        ArrayList<String> types = new ArrayList<>();
        types.add("§eSci-Fi");
        types.add("§eErfahren");
        types.add("§eKlebrig");
        types.add("§eExplosiv");

        ArrayList<Material> materials = new ArrayList<>();
        materials.add(Material.ENDER_PEARL);
        materials.add(Material.EXPERIENCE_BOTTLE);
        materials.add(Material.COBWEB);
        materials.add(Material.TNT);

        ArrayList<Integer> amounts = new ArrayList<>();
        amounts.add(0);
        amounts.add(5);
        amounts.add(3);
        amounts.add(2);

        for(int f = 0; f <= types.size() - 1; f++) {
            if (d.getItemInHand().getItemMeta() != null) {
                if (d.getItemInHand().getItemMeta().getLore() != null) {
                    if (d.getItemInHand().getItemMeta().getLore().contains(types.get(f))) {
                        String s = "false";
                        int i = (int) (Math.random() * 300) + 1;
                        if (i == 1) {
                            for(int k = 0; k <= amounts.get(f); k++) {
                                for (int l = 0; l <= 35; l++) {
                                    if (d.getInventory().getItem(l) == null || Objects.requireNonNull(d.getInventory().getItem(l)).getType() == materials.get(f) && Objects.requireNonNull(d.getInventory().getItem(l)).getAmount() <= 15) {
                                        s = "true";
                                    }
                                }
                                if (s.equals("true")) {
                                    d.getInventory().addItem(new ItemStack(materials.get(f)));
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(materials.get(f)));
                                }
                            }
                            if(f == 0) {
                                new Bossbars().sciFiBar(d);
                            }else if(f == 1){
                                new Bossbars().erfahrenBar(d);
                            }else if(f == 2){
                                new Bossbars().klebrigBar(d);
                            }else if(f == 3){
                                new Bossbars().explosivBar(d);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void healArmorPieces(Player player, int amount){
        String value = "§cNichts";

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

        if (HDura <= BDura && HDura <= CDura && HDura <= LDura) {
            if (player.getInventory().getHelmet() != null) {
                player.getInventory().getHelmet().setDurability((short) (player.getInventory().getHelmet().getDurability() - amount));
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                value = "Helm";
            }
        }else if (CDura <= LDura && CDura <= BDura) {
            if (player.getInventory().getChestplate() != null) {
                player.getInventory().getChestplate().setDurability((short) (player.getInventory().getChestplate().getDurability() - amount));
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                value = "Brustplatte";
            }
        }else if (LDura <= BDura) {
            if (player.getInventory().getLeggings() != null) {
                player.getInventory().getLeggings().setDurability((short) (player.getInventory().getLeggings().getDurability() - amount));
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                value = "Hose";
            }
        }else{
            if (player.getInventory().getBoots() != null) {
                player.getInventory().getBoots().setDurability((short) (player.getInventory().getBoots().getDurability() - amount));
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
                value = "Schuhe";
            }
        }
        new Bossbars().healBar(player, value, amount);
    }
}