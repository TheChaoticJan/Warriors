package plugin.specialitems.vampiric;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.models.PlayerCombatHandler;
import plugin.utils.essentials.Count;

import java.util.ArrayList;
import java.util.Objects;

public class VampiricHelmet implements Listener{

    public static ItemStack create(Player player){
        ItemStack stack = new ItemStack(Material.CHAINMAIL_HELMET);
        ItemMeta meta = stack.getItemMeta();
        if(player.getName().endsWith("s")) {
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'</gradient><#b5185c> Vampirkrone</bold> <#ffffff><obf>aa"));
        }else{
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'s</gradient><#b5185c> Vampirkrone</bold> <#ffffff><obf>aa"));
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "crown"), PersistentDataType.INTEGER, 1);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.VANISHING_CURSE, 2, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 4, true);
        ArrayList<Component> list = new ArrayList<>();
        list.add(MiniMessage.miniMessage().deserialize("<i:false><#824622>Vampirisch"));
        list.add(Component.text(""));
        list.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <#b5185c>Blutdurst ist leidenschaft..."));
        list.add(Component.text("   §7· §fDiese Krone wurde geschmiedet um "));
        list.add(Component.text("   §7  §fRüstungen passiv zu heilen!"));
        list.add(Component.text("   §7  §fAber nicht im Kampf..."));
        list.add(Component.text(""));
        list.add(Component.text("   §7· §a+1 Dura§f/§e3 Sekunden"));
        list.add(Component.text("   §7· §fBedingung: §7'§cOut of Combat§7'"));
        list.add(Component.text(""));
        meta.lore(list);
        stack.setItemMeta(meta);

        return stack;
    }

    public static void start(Player player) {

        if(!PlayerCombatHandler.getCombatStatusByPlayer(player).getCombatStatus() && player.getInventory().getHelmet() != null) {
            if(Objects.requireNonNull(player.getInventory().getHelmet()).getItemMeta().getPersistentDataContainer().has(new NamespacedKey(Main.getInstance(), "crown"))) {

                if (new Count(player).getHelmetDura() < Objects.requireNonNull(player.getInventory().getHelmet()).getType().getMaxDurability()) {
                    player.getInventory().getHelmet().setDurability((short) (player.getInventory().getHelmet().getDurability() - 1));
                }
                if (player.getInventory().getChestplate() != null) {
                    if (new Count(player).getChestDura() < Objects.requireNonNull(player.getInventory().getChestplate()).getType().getMaxDurability()) {
                        player.getInventory().getChestplate().setDurability((short) (player.getInventory().getChestplate().getDurability() - 1));
                    }
                }
                if (player.getInventory().getLeggings() != null) {
                    if (new Count(player).getLeggingsDura() < Objects.requireNonNull(player.getInventory().getLeggings()).getType().getMaxDurability()) {
                        player.getInventory().getLeggings().setDurability((short) (player.getInventory().getLeggings().getDurability() - 1));
                    }
                }
                if (player.getInventory().getBoots() != null) {
                    if (new Count(player).getBootsDura() < Objects.requireNonNull(player.getInventory().getBoots()).getType().getMaxDurability()) {
                        player.getInventory().getBoots().setDurability((short) (player.getInventory().getBoots().getDurability() - 1));
                    }
                }
            }
        }
    }

}
