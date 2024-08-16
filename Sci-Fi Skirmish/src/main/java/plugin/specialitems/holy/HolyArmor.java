package plugin.specialitems.holy;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.shop.ShopUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

public class HolyArmor implements Listener{

    private static final NamespacedKey key = new NamespacedKey(Main.getInstance(), "godarmor");
    static HashMap<Player, Boolean> setOn = new HashMap<>();

    public static ItemStack [] create(){

        ItemStack head = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.displayName(HolyUtil.createName("Ohrringe der Erzengel"));
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOGJjY2Q2NjRjN2RkZGU4MmIxNmU5NTE0YzI3YWYxNDA3ZDNjOGY3MThiNDVhYjdiZWZiZjI0NzdiOTIxYzMwZSJ9fX0="));
        skullMeta.setPlayerProfile(playerProfile);

        ArrayList<ItemMeta> metas = new ArrayList<>();
        ArrayList<LeatherArmorMeta> leatherArmorMetas = new ArrayList<>();

        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) chest.getItemMeta();
        meta.displayName(HolyUtil.createName("Flügel der Erzengel"));

        ItemStack leggings = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta meta1 = (LeatherArmorMeta) leggings.getItemMeta();
        meta1.displayName(HolyUtil.createName("Leggings der Erzengel"));

        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta meta2 = (LeatherArmorMeta) boots.getItemMeta();
        meta2.displayName(HolyUtil.createName("Stiefel der Erzengel"));

        metas.add(skullMeta);
        metas.add(meta);
        metas.add(meta1);
        metas.add(meta2);

        leatherArmorMetas.add(meta);
        leatherArmorMetas.add(meta1);
        leatherArmorMetas.add(meta2);

        for(LeatherArmorMeta temp : leatherArmorMetas) {
            temp.setColor(Color.fromRGB(215, 173, 219));
        }
        for(ItemMeta temp : metas){
            temp.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
            temp.addEnchant(Enchantment.DURABILITY, 7, true);
            temp.addEnchant(Enchantment.LUCK, 10, true);
            temp.addEnchant(Enchantment.MENDING, 1, false);

            temp.getPersistentDataContainer().set(key, PersistentDataType.BYTE, (byte) 0);

            ArrayList<Component> lore = new ArrayList<>();
            lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<i:false>Engelsgleich"));
            lore.add(MiniMessage.miniMessage().deserialize(HolyUtil.holyGradient + "<i:false>Heilig"));
            lore.add(Component.text(""));
            lore.add(MiniMessage.miniMessage().deserialize("<dark_gray>▸ <yellow>Von den Erzengeln erhalten..."));
            lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>Trägst du das <green>komplette Set"));
            lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>dieser Rüstung, erhältst du "));
            lore.add(MiniMessage.miniMessage().deserialize("  <i:false><white>folgenden <gray>passiven <white>Effekt:"));
            lore.add(Component.text(""));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false> <dark_gray>↪ <yellow>Geworfene XP werden direkt"));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false> <yellow>von deinem Konto abgezogen, "));
            lore.add(MiniMessage.miniMessage().deserialize("<i:false> <yellow>anstatt aus deinem Inventar!"));
            temp.lore(lore);

        }

        head.setItemMeta(skullMeta);
        chest.setItemMeta(meta);
        leggings.setItemMeta(meta1);
        boots.setItemMeta(meta2);
        return new ItemStack[]{head, chest, leggings, boots};
    }

    public static void startArmorCheck(Player player){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                int bl = 0;
                for(ItemStack stack : player.getInventory().getArmorContents()){
                    if(stack != null) {
                        if (stack.hasItemMeta()) {
                            if (stack.getItemMeta().getPersistentDataContainer().has(key)) {
                                bl++;
                            }
                        }
                    }
                }
                if(bl == 4){
                    setOn.put(player, true);
                }else{
                    setOn.put(player, false);
                }

            }
        }, 10, 10);
    }

    @EventHandler
    private void onJoin(PlayerJoinEvent event){
        startArmorCheck(event.getPlayer());
    }

    @EventHandler
    private void onItemUse(PlayerInteractEvent event){

        Player player = event.getPlayer();

        if(event.getAction().isRightClick() && setOn.get(player)) {
            if (event.hasItem()) {
                if (event.getItem().getType() == Material.EXPERIENCE_BOTTLE) {
                    try {
                        PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);
                        if(stats == null){
                            Main.getInstance().getDatabase().createPlayerStats(new PlayerStats(player));
                        }

                        assert stats != null;
                        if(!(stats.getXp() > 0) /*TODO: ADD Protection if player has a full Stack in his hand*/ ){
                            return;
                        }else{

                            event.getItem().add(1);
                            stats.setXp(stats.getXp() - 1);
                            Main.getInstance().getDatabase().updatePlayerStats(stats);
                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }





}
