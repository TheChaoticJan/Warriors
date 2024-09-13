package plugin.specialitems.royal;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.Listener;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.models.PlayerCombatHandler;

import java.util.*;

public class ChesterItem implements Listener{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "jester");
    public static ItemStack create(){

        ItemStack stack = new ItemStack(Material.IRON_NUGGET);
        ItemMeta meta = stack.getItemMeta();

        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 0);
        correctName(meta, meta.getPersistentDataContainer().get(key, PersistentDataType.INTEGER));
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

        ArrayList<Component> lore = new ArrayList<>();
        lore.add(MiniMessage.miniMessage().deserialize("<i:false><gradient:yellow:gold>Royal"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Stiftet Unordnung bei deinen Gegnern"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Sofern du dich <red>Im Kampf"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>mit einem Gegner befindest und"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>dieses Item voll aufgeladen ist,"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>kannst du mit einem <green>Rechtsklick"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>das gesamte Inventar deines "));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Gegners <red>zufällig<white> neu ordnen!"));
        lore.add(Component.text(""));
        lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Profitiert von deinem Leiden..."));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Dieses Item gewinnt durch <red>jeden Treffer"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>den du erleidest, während du es im Inventar"));
        lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>hast <yellow>1% <white>seiner Kraft zurück"));
        meta.lore(lore);

        stack.setItemMeta(meta);
        return stack;
    }

    private static ItemMeta correctName(ItemMeta meta, int amount){

        if(meta.hasEnchants()){
            meta.removeEnchant(Enchantment.MENDING);
        }

        if(amount == 0){
            meta.displayName(RoyalUtil.createName("Narrenglocke").append(Component.text(" §8[§c0%§8]")));
        }
        else if(amount < 50){
            meta.displayName(RoyalUtil.createName("Narrenglocke").append(Component.text(" §8[§6" + amount + "%§8]")));
        }
        else if(amount < 100){
            meta.displayName(RoyalUtil.createName("Narrenglocke").append(Component.text(" §8[§e" + amount + "%§8]")));
        }
        else {
            meta.displayName(RoyalUtil.createName("Narrenglocke").append(Component.text(" §8[§a" + amount + "%§8]")));
            meta.addEnchant(Enchantment.MENDING, 1, true);
        }
        return meta;
    }

    private void randomizeInventory(Inventory inventory){
        ItemStack [] array = new ItemStack[36];

        for(int i = 0; i < 36; i++){
            array[i] = inventory.getItem(i);
        }

        Random rand = new Random();

        for (int i = 0; i < array.length; i++) {
            int randomIndexToSwap = rand.nextInt(array.length);
            ItemStack stack = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = stack;
        }

        for(int i = 0; i < array.length; i++){
            inventory.setItem(i, array[i]);
        }

    }

    @EventHandler
    public void onPlayerHit(EntityDamageEvent event){
        if(event.getEntity() instanceof Player player){
            for(int i = 0; i < 36; i++){
                ItemStack stack = player.getInventory().getItem(i);

                if(stack == null){continue;}
                if(stack.getType() == Material.AIR){continue;}
                if(stack.getItemMeta() == null){continue;}

                if(stack.getItemMeta().getPersistentDataContainer().has(key)){
                    int temp = stack.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER);
                    if(temp == 100){
                        return;
                    }else{
                        ItemMeta meta = stack.getItemMeta();
                        meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, temp + 1);
                        correctName(meta , temp + 1);
                        stack.setItemMeta(meta);
                    }
                }

            }
        }
    }

    @EventHandler
    public void applyEffect(PlayerInteractEvent event){

        if(event.getItem() == null){return;}

        if(event.getAction().isRightClick() && event.getItem().getItemMeta() != null){
            if(event.getItem().getItemMeta().getPersistentDataContainer().has(key)){
                event.setCancelled(true);
                Player player = event.getPlayer();

                if(!PlayerCombatHandler.getCombatStatusByPlayer(player).getCombatStatus()){
                    player.sendActionBar(Component.text("§cDu befindest dich nicht im Kampf!"));
                    return;
                }
                if(event.getItem().getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.INTEGER) < 100){
                    player.sendActionBar(Component.text("§cDieses Item ist nicht vollständig aufgeladen!"));
                    return;
                }

                ItemStack stack = event.getItem();
                ItemMeta meta = stack.getItemMeta();
                meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 0);
                correctName(meta, 0);
                stack.setItemMeta(meta);

                player.playSound(player, Sound.ITEM_HONEY_BOTTLE_DRINK, 20,1);
                randomizeInventory(PlayerCombatHandler.getCombatStatusByPlayer(player).getLastAttacked().getInventory());

            }
        }
    }

}
