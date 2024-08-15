package plugin.specialitems.vampiric;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;
import java.util.HashMap;

public class VampiricHoe implements Listener{

    private static HashMap<Player, Integer> countMap = new HashMap<>();
    private static HashMap<Player, Boolean> cooldownMap = new HashMap<>();

    public static ItemStack create(Player player){
        ItemStack stack = new ItemStack(Material.IRON_HOE);
        ItemMeta meta = stack.getItemMeta();
        if(player.getName().endsWith("s")) {
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'</gradient><#b5185c> Vampirsense</bold> <#ffffff><obf>aa"));
        }else{
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'s</gradient><#b5185c> Vampirsense</bold> <#ffffff><obf>aa"));
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "Combohoe"), PersistentDataType.INTEGER, 1);
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        ArrayList<String> list = new ArrayList<>();
        list.add("§x§8§2§4§6§2§2Vampirisch");
        list.add("");
        list.add("§8▸ §x§b§5§1§8§5§cSchlage deine Gegner zu Brei...");
        list.add("   §7· §fDiese Sense wurde geschmiedet");
        list.add("   §7  §fum deine Gegner zu combo'n und");
        list.add("   §7  §fdir dadurch Stärke zu verleihen");
        list.add("");
        list.add("   §7· §fMaximales Stärkelevel: §c7");
        meta.setLore(list);
        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private static void processEffect(EntityDamageByEntityEvent event){
        if(event.getEntity() instanceof Player){
            Player player = (Player) event.getEntity();
            countMap.put(player, 0);
        }
        if(event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            countMap.putIfAbsent(player, 0);
            cooldownMap.putIfAbsent(player, false);

            if (player.getItemInHand().getType() != Material.AIR) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "Combohoe")) && cooldownMap.get(player).equals(false)) {
                    cooldownMap.put(player, true);
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> cooldownMap.put(player, false), 5);
                    if (countMap.get(player) < 7) {
                        countMap.put(player, 1 + countMap.get(player));
                    }
                    PotionEffect effect = new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 5 * 20, countMap.get(player) - 1, false, false, false);
                    player.addPotionEffect(effect);
                }
            }
        }
    }

}
