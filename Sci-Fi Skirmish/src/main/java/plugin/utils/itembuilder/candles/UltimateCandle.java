package plugin.utils.itembuilder.candles;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
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
import plugin.utils.inventorybuilder.SelectCandleInventory;

import java.util.ArrayList;

public class UltimateCandle implements Listener{
    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "candle");

    public static ItemStack create(){
        ItemStack stack = new ItemStack(Material.PURPLE_CANDLE);
        ItemMeta kerzenMeta = stack.getItemMeta();
        kerzenMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        kerzenMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        kerzenMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><rainbow><obf>aa</obf><bold> [OP] Wunderkerze</bold> <obf>aa</rainbow>"));
        kerzenMeta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "none");
        kerzenMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "special"), PersistentDataType.INTEGER, 1);
        ArrayList<Component> lore = new ArrayList<>();
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<rainbow> Diese Kerze ist extrem op...</rainbow>"));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray> ▸ <gray>Diese <rainbow>Wunderkerze</rainbow><gray> kann"));
        lore.add(Component.text("   §7zwischen allen Formen der Kerzen"));
        lore.add(Component.text("   §7durchwechseln! (§eSneak + Rechtsklick§7)"));
        lore.add(Component.text(""));
        lore.add(Component.text("   §7Aktueller Modus: §bUndefiniert"));
        kerzenMeta.lore(lore);
        stack.setItemMeta(kerzenMeta);
        return stack;
    }

    @EventHandler
    private void processEffect(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(player.isSneaking() && player.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "special")) && event.getAction().isRightClick()){
            player.openInventory(SelectCandleInventory.selectCandle(player, player.getItemInHand().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "candle"), PersistentDataType.STRING)));
        }
    }

}
