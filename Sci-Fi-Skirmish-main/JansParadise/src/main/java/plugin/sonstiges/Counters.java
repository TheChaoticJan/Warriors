package plugin.sonstiges;

import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Counters {

    public static ArrayList<Integer> Counters(Player p){

        ArrayList<Integer> count = new ArrayList<>();
        int xp = 0;
        int pearls = 0;
        int webs = 0;
        int tnt = 0;
        for(int m = 0; m <= 35; m++){
            if(p.getInventory().getItem(m) != null){
                if(p.getInventory().getItem(m).getType().equals(Material.EXPERIENCE_BOTTLE)){
                    xp = xp + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.ENDER_PEARL)){
                    pearls = pearls + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.TNT)){
                    tnt = tnt + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.COBWEB)){
                    webs = webs + p.getInventory().getItem(m).getAmount();
                }
            }
        }

        int HelmetDura = 0;
        int BootsDura = 0;
        int ChestDura = 0;
        int LeggingsDura = 0;
        if(!(p.getInventory().getHelmet() == null)){
            HelmetDura = p.getInventory().getHelmet().getType().getMaxDurability() - p.getInventory().getHelmet().getDurability();
        }

        if(!(p.getInventory().getBoots() == null)){
            BootsDura = p.getInventory().getBoots().getType().getMaxDurability() - p.getInventory().getBoots().getDurability();
        }

        if(!(p.getInventory().getChestplate() == null)){
            ChestDura = p.getInventory().getChestplate().getType().getMaxDurability() - p.getInventory().getChestplate().getDurability();
        }

        if(!(p.getInventory().getLeggings() == null)){
            LeggingsDura = p.getInventory().getLeggings().getType().getMaxDurability() - p.getInventory().getLeggings().getDurability();
        }

        count.add(xp);
        count.add(pearls);
        count.add(webs);
        count.add(tnt);
        count.add(HelmetDura);
        count.add(ChestDura);
        count.add(LeggingsDura);
        count.add(BootsDura);
        return count;
    }
}
