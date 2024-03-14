package plugin.utils.essentials;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import plugin.Main;
import plugin.utils.CombatLogger;

import java.util.Objects;

public class PassiveHealing {

    public static void start(Player player) {

            if(!CombatLogger.isInCombat(player) && player.getInventory().getHelmet() != null) {
                    if(Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "crown"))) {
                            if (Count.countValues(player).get(4) < Objects.requireNonNull(player.getInventory().getHelmet()).getType().getMaxDurability()) {
                                    player.getInventory().getHelmet().setDurability((short) (player.getInventory().getHelmet().getDurability() - 1));
                                    player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 2.6, 0), 20);
                            }
                            if (player.getInventory().getChestplate() != null) {
                                    if (Count.countValues(player).get(5) < Objects.requireNonNull(player.getInventory().getChestplate()).getType().getMaxDurability()) {
                                            player.getInventory().getChestplate().setDurability((short) (player.getInventory().getChestplate().getDurability() - 1));
                                            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 2.6, 0), 20);
                                    }
                            }
                            if (player.getInventory().getLeggings() != null) {
                                    if (Count.countValues(player).get(6) < Objects.requireNonNull(player.getInventory().getLeggings()).getType().getMaxDurability()) {
                                            player.getInventory().getLeggings().setDurability((short) (player.getInventory().getLeggings().getDurability() - 1));
                                            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 2.6, 0), 20);
                                    }
                            }
                            if (player.getInventory().getBoots() != null) {
                                    if (Count.countValues(player).get(7) < Objects.requireNonNull(player.getInventory().getBoots()).getType().getMaxDurability()) {
                                            player.getInventory().getBoots().setDurability((short) (player.getInventory().getBoots().getDurability() - 1));
                                            player.spawnParticle(Particle.COMPOSTER, player.getLocation().add(0, 2.6, 0), 20);
                                    }
                            }

                    }
            }
    }
}


