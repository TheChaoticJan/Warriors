package plugin.specialitems.vampiric;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import plugin.Main;

import java.util.ArrayList;

public abstract class VampiricBoots{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "vampiric_boots");

    public static ItemStack create(Player player){
        ItemStack stack = new ItemStack(Material.IRON_BOOTS);
        ItemMeta meta = stack.getItemMeta();

        if(player.getName().endsWith("s")) {
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "' </gradient><#b5185c>Filzschuhe</bold> <#ffffff><obf>aa"));
        }else{
            meta.displayName(MiniMessage.miniMessage().deserialize("<i:false><#ffffff><obf>aa</obf> <bold><gradient:#824622:#b5185c>" + player.getName() + "'s </gradient><#b5185c>Filzschuhe</bold> <#ffffff><obf>aa"));
        }
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "crown"), PersistentDataType.INTEGER, 1);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
        meta.addEnchant(Enchantment.DURABILITY, 2, true);
        ArrayList<Component> list = new ArrayList<>();
        list.add(MiniMessage.miniMessage().deserialize("<i:false><#824622>Vampirisch"));
        list.add(Component.text(""));
        list.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <#b5185c>Macht magisch jünger..."));
        list.add(Component.text("   §7· §fTrägst du diese Schuhe, so "));
        list.add(Component.text("   §7  §ferhältst du passiv den Effekt"));
        list.add(Component.text("   §7  §bGeschwindigkeit I"));
        list.add(Component.text(""));
        meta.lore(list);

        meta.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);
        stack.setItemMeta(meta);
        return stack;
    }

    public static void start(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()){
                    if(player.getInventory().getBoots() == null){
                        return;
                    }
                    if(!(player.getInventory().getBoots().hasItemMeta())){
                        return;
                    }
                    if(player.getInventory().getBoots().getItemMeta().getPersistentDataContainer().has(key)){
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 40, 0, true));
                    }
                }
            }
        }, 30, 30);
    }

}
