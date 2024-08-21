package plugin.specialitems.vampiric;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.essentials.Count;

import java.sql.SQLException;
import java.util.ArrayList;

public class VampiricBow implements Listener {

    public static ItemStack create(Player player){
        ItemStack stack = new ItemStack(Material.BOW);
        ItemMeta meta = stack.getItemMeta();
        if(player.getName().endsWith("s")) {
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'</gradient><#b5185c> Essenzbogen</bold> <#ffffff><obf>aa"));
        }else{
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'s</gradient><#b5185c> Essenzbogen</bold> <#ffffff><obf>aa"));
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "EssenceBow"), PersistentDataType.INTEGER, 1);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.ARROW_DAMAGE, 6, true);
        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        ArrayList<String> list = new ArrayList<>();
        list.add("§x§8§2§4§6§2§2Vampirisch");
        list.add("");
        list.add("§8▸ §x§b§5§1§8§5§cEnziehe deinen Gegnern das Blut...");
        list.add("   §7· §fDieser Bogen wurde geschaffen um ");
        list.add("   §7  §fdeinen Gegnern für jeden Treffer XP");
        list.add("   §7  §fzu entziehen. Es dauert lange ihn");
        list.add("   §7  §fnachzuladen...");
        list.add("");
        list.add("   §7· §fEntzogene XP pro Treffer: §a3");
        list.add("   §7· §fCooldown zum nächsten Schuss: §c5sek.");
        list.add("");
        meta.setLore(list);
        stack.setItemMeta(meta);
        return stack;
    }

    @EventHandler
    private static void processEffect(ProjectileHitEvent event){
        if(event.getHitEntity() instanceof Player player){
            Player damager = (Player) event.getEntity().getShooter();
            if(damager == null){return;}
            if (damager.getItemInHand().getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "EssenceBow"))) {

                try {

                    PlayerStats stats1 = Main.getInstance().getDatabase().findPlayerStats(damager);
                    if (stats1 == null) {
                        stats1 = new PlayerStats(damager);
                        Main.getInstance().getDatabase().createPlayerStats(stats1);
                    }

                    if (new Count(player).getXp() >= 3) {
                        player.getInventory().removeItem(new ItemStack(Material.EXPERIENCE_BOTTLE, 3));
                        stats1.setXp(stats1.getXp() + 3);
                    } else {
                        player.getInventory().removeItem(new ItemStack(Material.EXPERIENCE_BOTTLE, new Count(player).getXp()));
                        stats1.setXp(stats1.getXp() + new Count(player).getXp());
                    }

                    Main.getInstance().getTablistManager().setScoreboard(player);

                    damager.playSound(damager, Sound.ITEM_HONEY_BOTTLE_DRINK, 50, 1);
                    Main.getInstance().getDatabase().updatePlayerStats(stats1);
                    damager.setCooldown(Material.BOW, 5 * 20);
                }catch (SQLException exception){
                    exception.printStackTrace();
                }
            }

        }
    }

}
