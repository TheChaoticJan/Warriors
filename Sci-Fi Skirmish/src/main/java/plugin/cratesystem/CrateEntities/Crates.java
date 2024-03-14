package plugin.cratesystem.CrateEntities;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.UUID;


public class Crates {

    Main plugin;

    public Crates(Main plugin) {
        this.plugin = plugin;
    }

    public static void spawnArmorstand(Entity p, int x, float y, int z){

            ArmorStand Crate = (ArmorStand) p.getLocation().getBlock().getWorld().spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.ARMOR_STAND);

            Crate.setMaxHealth(100);
            Crate.setHealth(100);
            Crate.setVisible(false);
            Crate.setCanMove(false);
            ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
            PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
            playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY5ZmYyYjBlNTI0NTc0ZDEwYWYxNDBjODZlZWVkYzQzMzg0NGYzY2YxM2ViYThkMDhkZjZhMTRiNTVlYWE2YiJ9fX0="));
            skullMeta.setPlayerProfile(playerProfile);
            stack.setItemMeta(skullMeta);
            Crate.setHelmet(stack);
            Crate.setCustomName("§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???");
            Crate.setCustomNameVisible(true);

            startRotation(Crate);
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
