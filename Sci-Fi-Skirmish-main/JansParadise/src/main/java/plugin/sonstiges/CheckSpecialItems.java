package plugin.sonstiges;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class CheckSpecialItems {

    public static void CheckDrops(Player d) {

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
                        int i = (int) (Math.random() * 1) + 1;
                        if (i == 1) {
                            for(int k = 0; k <= amounts.get(f); k++) {
                                for (int l = 0; l <= 35; l++) {
                                    if (d.getInventory().getItem(l) == null || d.getInventory().getItem(l).getType() == materials.get(f) && d.getInventory().getItem(l).getAmount() <= 15) {
                                        s = "true";
                                    }
                                }
                                if (s == "true") {
                                    d.getInventory().addItem(new ItemStack(materials.get(f)));
                                } else {
                                    int x = d.getLocation().getBlockX();
                                    int y = d.getLocation().getBlockY();
                                    int z = d.getLocation().getBlockZ();

                                    d.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), new ItemStack(materials.get(f)));
                                }
                            }
                            if(f == 0) {
                                new Bossbars().SciFiBar(d);
                            }else if(f == 1){
                                new Bossbars().ErfahrenBar(d);
                            }else if(f == 2){
                                new Bossbars().KlebrigBar(d);
                            }else if(f == 3){
                                new Bossbars().ExplosivBar(d);
                            }
                        }
                    }
                }
            }
        }
    }
}