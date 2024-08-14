package plugin.utils.itembuilder.candles;

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
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.utils.essentials.InventoryInteracts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class RepairCandle implements Listener{
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");
    public static HashMap<UUID, String> healCooldown = new HashMap<>();

    public static ItemStack create(){

        ItemStack stack = new ItemStack(Material.YELLOW_CANDLE);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><#EBD77B>a<#BED556>a</obf> <dark_gray><bold>[<gradient:#EBD77B:#BED556>Erfahren<dark_gray>] <gradient:#E4E170:#9DCE4E>Wunderkerze</bold> <obf><#BED556>a<#EBD77B>a"));
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "heal");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§8• §7Hatte langes §x§E§B§D§7§7§BT§x§E§5§D§7§7§6r§x§D§E§D§6§7§0a§x§D§8§D§6§6§Bi§x§D§1§D§6§6§6n§x§C§B§D§6§6§1i§x§C§4§D§5§5§Bn§x§B§E§D§5§5§6g§7...");
        lore.add("  §8▸ §7Diese §x§E§4§E§1§7§0W§x§D§D§D§F§6§Du§x§D§6§D§D§6§9n§x§C§F§D§B§6§6d§x§C§8§D§9§6§2e§x§C§1§D§8§5§Fr§x§B§9§D§6§5§Ck§x§B§2§D§4§5§8e§x§A§B§D§2§5§5r§x§A§4§D§0§5§1z§x§9§D§C§E§4§Ee §7kann");
        lore.add("    §7alle §e60 Sekunden§7, dein");
        lore.add("    §7lowstes Piece um §b15 Dura");
        lore.add("    §7heilen");
        meta.setLore(lore);
        stack.setItemMeta(meta);

        return stack;
    }

    @EventHandler
    private void processEffect(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "candle")) && player.getItemInHand().getType().equals(Material.YELLOW_CANDLE) && event.getAction().isRightClick() && !Objects.equals(healCooldown.get(player.getUniqueId()), "heal") && !player.isSneaking()){
            healCooldown.put(player.getUniqueId(), "heal");
            InventoryInteracts.healArmorPieces(player, 15);
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE, 20, 1);
            player.setCooldown(Material.YELLOW_CANDLE, 1200);

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> healCooldown.remove(player.getUniqueId(), "heal"), 20 * 60);

        }

    }
}


