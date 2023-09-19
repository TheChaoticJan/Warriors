package jansparadise.jansparadise.LootSystem.CrateEntities;

import jansparadise.jansparadise.JansParadise;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.ArmorStand;
import org.checkerframework.checker.units.qual.C;


public class ArmorstandRotation {

    public static void Rotation(ArmorStand Crate){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(JansParadise.getInstance(), new Runnable() {
            int i = 0;
            @Override
            public void run() {
                i = i + 1;
                Crate.setRotation(i, i);
            }

        }, 1, 1);

    }
}
