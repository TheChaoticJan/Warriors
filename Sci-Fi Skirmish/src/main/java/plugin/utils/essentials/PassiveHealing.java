package plugin.utils.essentials;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import plugin.Main;
import plugin.utils.PlayerCombatHandler;

import java.util.Objects;

public class PassiveHealing {

    public static void start(Player player) {

            if(!PlayerCombatHandler.isInCombat(player) && player.getInventory().getHelmet() != null) {
                    if(Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "crown"))) {

                            if (new Count(player).getHelmetDura() < Objects.requireNonNull(player.getInventory().getHelmet()).getType().getMaxDurability()) {
                                    player.getInventory().getHelmet().setDurability((short) (player.getInventory().getHelmet().getDurability() - 1));
                            }
                            if (player.getInventory().getChestplate() != null) {
                                    if (new Count(player).getChestDura() < Objects.requireNonNull(player.getInventory().getChestplate()).getType().getMaxDurability()) {
                                            player.getInventory().getChestplate().setDurability((short) (player.getInventory().getChestplate().getDurability() - 1));
                                    }
                            }
                            if (player.getInventory().getLeggings() != null) {
                                    if (new Count(player).getLeggingsDura() < Objects.requireNonNull(player.getInventory().getLeggings()).getType().getMaxDurability()) {
                                            player.getInventory().getLeggings().setDurability((short) (player.getInventory().getLeggings().getDurability() - 1));
                                    }
                            }
                            if (player.getInventory().getBoots() != null) {
                                    if (new Count(player).getBootsDura() < Objects.requireNonNull(player.getInventory().getBoots()).getType().getMaxDurability()) {
                                            player.getInventory().getBoots().setDurability((short) (player.getInventory().getBoots().getDurability() - 1));
                                    }
                            }
                    }
            }
    }
}


