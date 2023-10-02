package jansparadise.jansparadise.sonstiges;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CheckSpecialItems {

    public static void CheckDrops(Player d) {

        if (d.getItemInHand().getItemMeta() != null) {
            if (d.getItemInHand().getItemMeta().getLore() != null) {
                if (d.getItemInHand().getItemMeta().getLore().contains("§eSci-Fi")) {

                    String s = "false";
                    int i = (int) (Math.random() * 300) + 1;
                    if (i == 1) {
                        for (int l = 0; l <= 35; l++) {
                            if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.ENDER_PEARL && d.getInventory().getItem(l).getAmount() <= 15) {
                                s = "true";
                            }
                        }
                        if (s == "true") {
                            d.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                        } else {
                            int x = d.getLocation().getBlockX();
                            int y = d.getLocation().getBlockY();
                            int z = d.getLocation().getBlockZ();

                            d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.ENDER_PEARL));
                        }
                        new Bossbars().SciFiBar(d);
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore().contains("§eErfahren")) {

                    String s = "false";
                    int i = (int) (Math.random() * 300) + 1;
                    if (i == 1) {
                        for (int m = 0; m <= 5; m++) {
                            for (int l = 0; l <= 35; l++) {
                                if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.EXPERIENCE_BOTTLE && d.getInventory().getItem(l).getAmount() <= 63) {
                                    s = "true";
                                }
                            }
                            if (s == "true") {
                                d.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE));
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.EXPERIENCE_BOTTLE));
                            }

                        }
                        new Bossbars().ErfahrenBar(d);
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore().contains("§eKlebrig")) {

                    String s = "false";
                    int i = (int) (Math.random() * 300) + 1;
                    if (i == 1) {
                        for (int m = 0; m <= 3; m++) {
                            for (int l = 0; l <= 35; l++) {
                                if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.COBWEB && d.getInventory().getItem(l).getAmount() <= 63) {
                                    s = "true";
                                }
                            }
                            if (s == "true") {
                                d.getInventory().addItem(new ItemStack(Material.COBWEB));
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.COBWEB));
                            }
                        }
                        new Bossbars().KlebrigBar(d);
                    }
                }

                if (d.getItemInHand().getItemMeta().getLore().contains("§eExplosiv")) {

                    String s = "false";
                    int i = (int) (Math.random() * 300) + 1;
                    if (i == 1) {
                        for (int m = 0; m <= 2; m++) {
                            for (int l = 0; l <= 35; l++) {
                                if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == Material.TNT && d.getInventory().getItem(l).getAmount() <= 63) {
                                    s = "true";
                                }
                            }
                            if (s == "true") {
                                d.getInventory().addItem(new ItemStack(Material.TNT));
                            } else {
                                int x = d.getLocation().getBlockX();
                                int y = d.getLocation().getBlockY();
                                int z = d.getLocation().getBlockZ();

                                d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(Material.TNT));
                            }
                        }
                        new Bossbars().ExplosivBar(d);
                    }
                }
            }
        }
    }
}
