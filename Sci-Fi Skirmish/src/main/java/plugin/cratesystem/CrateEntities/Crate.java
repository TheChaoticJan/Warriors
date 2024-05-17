package plugin.cratesystem.CrateEntities;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import plugin.cratesystem.Loot;
import plugin.utils.Text.Texts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;


public class Crate{
    private final int maxHealth;
    public static final String name = "<gradient:#FFE259:#FFA751>Nachschubkiste <dark_gray>» <gray>???";
    private final @Getter String rarity;
    private final @Getter ArrayList<ItemStack> lootTable;
    private static HashMap<String, Crate> keyMap = new HashMap<>();
    private final @Getter ArmorStand stand;

    public Crate(Entity player, int x, float y, int z){

        String temp;
        int random = (int) (Math.random() * 100);
        temp = "";
        if (random <= 42) {
            temp = "common";
        } else if (random <= 70) {
            temp = "uncommon";
        } else if (random <= 89) {
            temp = "epic";
        } else if (random <= 98) {
            temp = "rare";
        } else if (random <= 100) {
            temp = "mythic";
        }
        this.rarity = temp;


        this.lootTable = new Loot(rarity).getContents();

        maxHealth = new Random().nextInt((120 - 80) + 1) + 80;

        String key = Texts.generateRandomString(8);

        ArmorStand Crate = (ArmorStand) player.getLocation().getBlock().getWorld().spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.ARMOR_STAND);
        Crate.setMaxHealth(this.maxHealth);
        Crate.setHealth(this.maxHealth);
        Crate.setVisible(false);
        Crate.setCanMove(false);
        ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY5ZmYyYjBlNTI0NTc0ZDEwYWYxNDBjODZlZWVkYzQzMzg0NGYzY2YxM2ViYThkMDhkZjZhMTRiNTVlYWE2YiJ9fX0="));
        skullMeta.setPlayerProfile(playerProfile);
        stack.setItemMeta(skullMeta);
        Crate.setHelmet(stack);
        Crate.customName(MiniMessage.miniMessage().deserialize(name));
        Crate.setCustomNameVisible(true);
        Crate.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING, key);

        this.stand = Crate;
        startRotation(Crate);
        keyMap.put(key, this);

    }

    //Constructor for generating new Crate Objects for each Armorstand still on t
    public Crate(ArmorStand stand){

        String temp;
        int random = (int) (Math.random() * 100);
        temp = "";
        if (random <= 42) {
            temp = "common";
        } else if (random <= 70) {
            temp = "uncommon";
        } else if (random <= 89) {
            temp = "epic";
        } else if (random <= 98) {
            temp = "rare";
        } else if (random <= 100) {
            temp = "mythic";
        }
        this.rarity = temp;

        this.lootTable = new Loot(rarity).getContents();
        maxHealth = new Random().nextInt((120 - 80) + 1) + 80;
        String key = stand.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING);
        this.stand = stand;
        startRotation(stand);
        keyMap.put(key, this);

    }


    public static Crate getCrateByKey(String key){
        return keyMap.get(key);
    }

    public static void startRotation(ArmorStand Crate){

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            int i = 0;
            @Override
            public void run() {
                i = i + 1;
                Crate.setRotation(i, i);
            }

        }, 1, 1);

    }
}
