package plugin.utils.essentials;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;


public class Count {

    private @Getter int xp = 0;
    private @Getter int pearls = 0;
    private @Getter int webs = 0;
    private @Getter int tnt = 0;
    private @Getter int mainhanddura = 0;
    private @Getter int helmetDura = 0;
    private @Getter int bootsDura = 0;
    private @Getter int chestDura = 0;
    private @Getter int leggingsDura = 0;

    public Count(Player p) {
        for (int m = 0; m <= 35; m++) {
            if (p.getInventory().getItem(m) != null) {
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.EXPERIENCE_BOTTLE)) {
                    this.xp += Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.ENDER_PEARL)) {
                    pearls += Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.TNT)) {
                    tnt += Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
                if (Objects.requireNonNull(p.getInventory().getItem(m)).getType().equals(Material.COBWEB)) {
                    webs += Objects.requireNonNull(p.getInventory().getItem(m)).getAmount();
                }
            }
        }

        helmetDura = calculateDurability(p.getInventory().getHelmet());
        bootsDura = calculateDurability(p.getInventory().getBoots());
        chestDura = calculateDurability(p.getInventory().getChestplate());
        leggingsDura = calculateDurability(p.getInventory().getLeggings());

        if (!p.getItemInHand().getType().equals(Material.AIR)) {
            mainhanddura = p.getInventory().getItemInMainHand().getType().getMaxDurability() - p.getInventory().getItemInMainHand().getDurability();
        }
    }

    private int calculateDurability(ItemStack stack){
        int var = 0;
        if (!(stack == null)) {
            var = stack.getType().getMaxDurability() - stack.getDurability();
            if (var == stack.getType().getMaxDurability()) {
                var = 10000;
            }
        }
        return var;
    }

}
