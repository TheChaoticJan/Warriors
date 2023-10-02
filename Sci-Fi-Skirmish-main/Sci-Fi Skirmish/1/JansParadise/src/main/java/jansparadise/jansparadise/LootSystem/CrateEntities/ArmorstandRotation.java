package jansparadise.jansparadise.LootSystem.CrateEntities;

import jansparadise.jansparadise.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;


public class ArmorstandRotation {

    public static void Rotation(ArmorStand Crate){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            int i = 0;
            @Override
            public void run() {
                i = i + 1;
                Crate.setRotation(i, i);
            }

        }, 1, 1);

    }
}
