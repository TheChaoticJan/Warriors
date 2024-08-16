package plugin.specialitems.candles;

import net.kyori.adventure.text.minimessage.MiniMessage;
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
import plugin.models.PlayerCombatHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class TeleportCandle implements Listener{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");
    public static HashMap<UUID, String> teleportCooldown = new HashMap<>();
    public static ItemStack create(){
        ItemStack wand = new ItemStack(Material.GREEN_CANDLE);
        ItemMeta wandMeta = wand.getItemMeta();
        wandMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#5add2d>a<#40aa1c>a</obf> <dark_gray><bold>[<gradient:#5add2d:#40aa1c>Klebrig</gradient><dark_gray>] <gradient:#5add2d:#40aa1c>Wunderkerze</gradient></bold> <obf><#40aa1c>a<#5add2d>a"));
        wandMeta.addEnchant(Enchantment.DIG_SPEED, 1, true);
        wandMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        wandMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "teleport");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §7Lag lange in §x§5§A§D§D§2§DS§x§5§8§C§5§2§5c§x§5§7§A§C§1§Eh§x§5§5§9§4§1§6l§x§4§E§9§B§1§8e§x§4§7§A§3§1§Ai§x§4§0§A§A§1§Cm§7...");
        lore.add("   §8▸ §7Mit dem §x§5§A§D§D§2§DP§x§5§9§C§D§2§8e§x§5§8§B§D§2§3i§x§5§7§A§C§1§El§x§5§6§9§C§1§9s§x§5§3§9§6§1§7e§x§4§E§9§B§1§8n§x§4§9§A§0§1§9d§x§4§5§A§5§1§Be§x§4§0§A§A§1§Cr");
        lore.add("     §7kannst du dich alle §a1:30 Minuten");
        lore.add("     §7in den §cGegner §7teleportieren");
        lore.add("     §7mit dem du gerade kämpfst!");
        wandMeta.setLore(lore);
        wand.setItemMeta(wandMeta);

        return wand;
    }

    @EventHandler
    private void processEvent(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getItem() == null){
            return;
        }
        if(event.getItem().getItemMeta() == null){
            return;
        }
        if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && player.getItemInHand().getType().equals(Material.GREEN_CANDLE) && event.getAction().isRightClick() && !Objects.equals(teleportCooldown.get(player.getUniqueId()), "teleport") && !player.isSneaking()){
            if(PlayerCombatHandler.getCombatStatusByPlayer(player).getCombatStatus()){
                if(PlayerCombatHandler.getCombatStatusByPlayer(player).getLastAttacked() != null) {
                    player.teleport(Objects.requireNonNull(PlayerCombatHandler.getCombatStatusByPlayer(player).getLastAttacked()));
                    player.setCooldown(Material.GREEN_CANDLE, 1800);
                    player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 20, 1);
                    teleportCooldown.put(player.getUniqueId(), "teleport");
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> teleportCooldown.remove(player.getUniqueId(), "teleport"), 20 * 90);
                }
            }else{
                player.sendActionBar("§cDu befindest dich nicht im Kampf!");
                player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
            }
        }
    }



}
