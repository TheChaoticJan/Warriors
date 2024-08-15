package plugin.specialitems.holy;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.models.PlayerStats;

import java.sql.SQLException;
import java.util.ArrayList;

public class HolyCoin implements Listener {

    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta meta = stack.getItemMeta();

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);

        meta.displayName(HolyUtil.createName("Sternensplitter"));
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "fragment"), PersistentDataType.BYTE, (byte) 0);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<i:false>Heilig"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Aus dem Himmel gefallen..."));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>Hast du diesen Splitter in der Hand,"));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>werden gesammelte XP automatisch"));
        lore.add(MiniMessage.miniMessage().deserialize(" <i:false><white>auf dein Konto eingezahlt"));
        lore.add(Component.text(""));
        lore.add(Component.text("§7'Und er sah etwas strahlendes fallen...'"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private void pickupEvent(PlayerAttemptPickupItemEvent event){
        if(event.getPlayer().getItemInHand().hasItemMeta()) {
            if (event.getPlayer().getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "fragment")) && event.getItem().getItemStack().getType().equals(Material.EXPERIENCE_BOTTLE)) {
                event.setCancelled(true);
                event.getItem().remove();
                processEffect(event.getItem(), event.getPlayer());
            }
        }
    }

    private void processEffect(Item item, Player player){

            int amount = item.getItemStack().getAmount();
            try {

                if (Main.getInstance().getDatabase().findPlayerStats(player) == null) {
                    Main.getInstance().getDatabase().createPlayerStats(new PlayerStats(player));
                }

                PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);
                stats.setXp(stats.getXp() + amount);
                Main.getInstance().getDatabase().updatePlayerStats(stats);
                Main.getInstance().getTablistManager().setScoreboard(player);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

}
