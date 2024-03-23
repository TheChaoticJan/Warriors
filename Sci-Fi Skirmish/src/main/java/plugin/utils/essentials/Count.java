package plugin.utils.essentials;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.Objects;


public class Count {

    private @Getter int xp = 0;
    private @Getter int pearls = 0;
    private @Getter int webs = 0;
    private @Getter int tnt = 0;
    private @Getter int mainHandDura = 0;
    private @Getter int helmetDura = 0;
    private @Getter int bootsDura = 0;
    private @Getter int chestDura = 0;
    private @Getter int leggingsDura = 0;

    public Count(Player p) {
        for (int m = 0; m <= 35; m++) {
            if (p.getInventory().getItem(m) != null) {
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.EXPERIENCE_BOTTLE)) {
                    this.xp = this.xp + Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.ENDER_PEARL)) {
                    pearls = pearls + Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.TNT)) {
                    tnt = tnt + Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.COBWEB)) {
                    webs = webs + Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
            }
        }


        if (!(p.getInventory().getHelmet() == null)) {
            helmetDura = p.getInventory().getHelmet().getType().getMaxDurability() - p.getInventory().getHelmet().getDurability();
            if (helmetDura == p.getInventory().getHelmet().getType().getMaxDurability()) {
                helmetDura = 10000;
            }
        }

        if (!(p.getInventory().getBoots() == null)) {
            bootsDura = p.getInventory().getBoots().getType().getMaxDurability() - p.getInventory().getBoots().getDurability();
            if (bootsDura == p.getInventory().getBoots().getType().getMaxDurability()) {
                bootsDura = 10000;
            }
        }

        if (!(p.getInventory().getChestplate() == null)) {
            chestDura = p.getInventory().getChestplate().getType().getMaxDurability() - p.getInventory().getChestplate().getDurability();
            if (chestDura == p.getInventory().getChestplate().getType().getMaxDurability()) {
                chestDura = 10000;
            }
        }

        if (!(p.getInventory().getLeggings() == null)) {
            leggingsDura = p.getInventory().getLeggings().getType().getMaxDurability() - p.getInventory().getLeggings().getDurability();
            if (leggingsDura == p.getInventory().getLeggings().getType().getMaxDurability()) {
                leggingsDura = 10000;
            }
        }

        if (p.getItemInHand().getType().equals(Material.AIR)) {
            mainHandDura = 0;
        } else {
            mainHandDura = p.getInventory().getItemInMainHand().getType().getMaxDurability() - p.getInventory().getItemInMainHand().getDurability();
        }
    }

}
