package plugin.specialitems.candles;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class JumpCandle implements Listener{
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");
    public static HashMap<UUID, String> jumpCooldown = new HashMap<>();

    public static ItemStack create(){
        ItemStack Kerze = new ItemStack(Material.ORANGE_CANDLE);
        ItemMeta kerzenMeta = Kerze.getItemMeta();
        kerzenMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        kerzenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kerzenMeta.setDisplayName("§x§D§D§2§D§2§D§ka§x§A§A§7§8§1§C§ka §8§l[§x§D§D§2§D§2§D§lE§x§C§8§3§E§2§6§lx§x§B§3§4§F§2§0§lp§x§9§E§6§0§1§9§ll§x§9§7§6§A§1§7§lo§x§9§D§6§F§1§9§ls§x§A§4§7§3§1§A§li§x§A§A§7§8§1§C§lv§8§l] §x§F§F§0§0§4§8§lZ§x§F§3§0§E§4§1§lü§x§E§7§1§C§3§A§ln§x§D§B§2§A§3§3§ld§x§C§F§3§9§2§C§lk§x§C§2§4§7§2§4§le§x§B§6§5§5§1§D§lr§x§A§A§6§3§1§6§lz§x§9§E§7§1§0§F§le §x§A§A§7§8§1§C§ka§x§D§D§2§D§2§D§ka");
        kerzenMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "boost");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §x§D§D§2§D§2§DE§x§C§D§3§A§2§8x§x§B§D§4§7§2§3p§x§A§C§5§4§1§El§x§9§C§6§1§1§9o§x§9§6§6§A§1§7d§x§9§B§6§D§1§8i§x§A§0§7§1§1§9e§x§A§5§7§4§1§Br§x§A§A§7§8§1§Ct §7gelegentlich...");
        lore.add("  §8▸ §7Mit dieser §x§F§F§0§0§4§8Z§x§F§3§0§E§4§1ü§x§E§7§1§C§3§An§x§D§B§2§A§3§3d§x§C§F§3§9§2§Ck§x§C§2§4§7§2§4e§x§B§6§5§5§1§Dr§x§A§A§6§3§1§6z§x§9§E§7§1§0§Fe§7, kannst");
        lore.add("    §7du dich alle §65 Sekunden");
        lore.add("    §7nach vorn katapultieren!");
        kerzenMeta.setLore(lore);
        Kerze.setItemMeta(kerzenMeta);
        return Kerze;
    }

    @EventHandler
    private void processEffect(PlayerInteractEvent event){
        if(event.getItem() == null){
            return;
        }
        if(event.getItem().getItemMeta() == null){
            return;
        }

        Player player = event.getPlayer();

        if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && player.getItemInHand().getType().equals(Material.ORANGE_CANDLE) && event.getAction().isRightClick() && !Objects.equals(jumpCooldown.get(player.getUniqueId()), "jump") && !player.isSneaking()){
            player.setVelocity(player.getLocation().getDirection().add(player.getLocation().getDirection().multiply(0.7).setY(0.2)));
            jumpCooldown.put(player.getUniqueId(), "jump");
            player.setCooldown(Material.ORANGE_CANDLE, 100);
            player.playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 20, 1);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> jumpCooldown.remove(player.getUniqueId(), "jump"), 20 * 5 );
        }
    }

}
