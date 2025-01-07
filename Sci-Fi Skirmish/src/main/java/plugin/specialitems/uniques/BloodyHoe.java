package plugin.specialitems.uniques;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class BloodyHoe implements Listener, Unique{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "bloody_hoe");

    private static HashMap<Player, Integer> countMap = new HashMap<>();
    private static HashMap<Player, Boolean> cooldownMap = new HashMap<>();
    private static final int maxStrengthLevel = 7;
    private static final String inventoryName = "§7Bestimme dein Rückstoß Level!";

    private static Inventory inventory = null;

    public static ItemStack create(Integer knockbackLevel){
        ItemStack stack = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta meta = stack.getItemMeta();

        meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><obf><red>a</obf> <gradient:#f41e27:#8d2dcb><b>Blutige Sense</b> <obf><light_purple>a"));

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        meta.getPersistentDataContainer().set(uniqueKey, PersistentDataType.BYTE, (byte) 0);

        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
        meta.addEnchant(Enchantment.KNOCKBACK, knockbackLevel, true);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:#ffd831:#e7f776>Einzigartig"));
        lore.add(Component.empty());
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Halte deine Gegner in einer <red>Combo<white>!"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Mit jedem weiteren Treffer, den du"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>der Combo hinzufügst, erhältst"));
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><white>du ein weiteres Stärkelevel"));
        lore.add(Component.text("§7§o(Mit Sneak + Rechtsklick kannst du das Level"));
        lore.add(Component.text("§7§ oder 'Rückstoß' Verzauberung einstellen)"));
        lore.add(Component.empty());
        lore.add(Component.text("§b\uD83D\uDEC8 §fMaximales Stärkelevel: §9" + maxStrengthLevel));


        meta.lore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private static void rightClickEvent(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction().isRightClick() && player.isSneaking()){

            inventory = Bukkit.createInventory(player, InventoryType.HOPPER, inventoryName);
            inventory.setItem(1, create(0));
            inventory.setItem(2, create(1));
            inventory.setItem(3, create(2));
            player.openInventory(inventory);

        }

    }

    @EventHandler
    private static void inventoryClickEvent(InventoryClickEvent event){

        if(event.getView().getTitle().equalsIgnoreCase(inventoryName)){
            event.setCancelled(true);

            if(event.getClickedInventory() != inventory){return;}
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR){return;}

            Player player = (Player) event.getWhoClicked();

            if(player.getInventory().getItemInMainHand().getType() != Material.NETHERITE_HOE){
                player.closeInventory();
                player.sendMessage("§cDu musst die Sense in der Hand halten, um ihr Rückstoß Level einstellen zu können!");
                return;
            }

            player.getInventory().setItemInMainHand(event.getCurrentItem());
            player.closeInventory();

        }

    }

    @EventHandler
    private static void processEffect(EntityDamageByEntityEvent event){

        if(!(event.getEntity() instanceof Player)){
            return;
        }

        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            countMap.put(player, 0);
        }
        if(event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            countMap.putIfAbsent(player, 0);
            cooldownMap.putIfAbsent(player, false);

            if (player.getItemInHand().getType() != Material.AIR) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(key) && cooldownMap.get(player).equals(false)) {

                    if(!isSpecialized(player.getPersistentDataContainer(), key)){
                        player.sendMessage("§cDu hast die Verwendung dieser Waffe nicht gelernt!");
                        return;
                    }

                    cooldownMap.put(player, true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> cooldownMap.put(player, false), 3);
                    if (countMap.get(player) < maxStrengthLevel) {
                        countMap.put(player, 1 + countMap.get(player));
                    }
                    PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5 * 20, countMap.get(player) - 1, false, false, false);
                    player.addPotionEffect(effect);
                }
            }
        }
    }



    private static Boolean isSpecialized(PersistentDataContainer container, NamespacedKey key) {
        return container.has(key);
    }

}
