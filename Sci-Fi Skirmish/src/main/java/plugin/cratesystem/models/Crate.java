package plugin.cratesystem.models;

import com.destroystokyo.paper.Title;
import com.destroystokyo.paper.event.entity.EntityRemoveFromWorldEvent;
import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import lombok.Getter;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.Listener;
import plugin.models.PlayerStats;
import plugin.models.TextHandler;

import java.sql.SQLException;
import java.util.*;


public class Crate implements Listener{

    public Crate(){}

    private int maxHealth;
    public static final String name = "<gradient:#FFE259:#FFA751>Nachschubkiste <dark_gray>» <gray>???";
    private @Getter String rarity;
    private @Getter ArrayList<ItemStack> lootTable;
    private static HashMap<String, Crate> keyMap = new HashMap<>();
    private @Getter ArmorStand stand;

    public Crate( Entity player, int x, float y, int z){

        String key = TextHandler.generateRandomString(8);
        this.maxHealth = new Random().nextInt((120 - 80) + 1) + 80;

        ArmorStand armorStand = (ArmorStand) player.getLocation().getBlock().getWorld().spawnEntity(new Location(Bukkit.getWorld("world"), x, y, z), EntityType.ARMOR_STAND);
        armorStand.setMaxHealth(this.maxHealth);
        armorStand.setHealth(this.maxHealth);
        armorStand.setVisible(false);
        armorStand.setCanMove(false);
        ItemStack stack = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) stack.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
        playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY5ZmYyYjBlNTI0NTc0ZDEwYWYxNDBjODZlZWVkYzQzMzg0NGYzY2YxM2ViYThkMDhkZjZhMTRiNTVlYWE2YiJ9fX0="));
        skullMeta.setPlayerProfile(playerProfile);
        stack.setItemMeta(skullMeta);
        armorStand.setHelmet(stack);
        armorStand.customName(MiniMessage.miniMessage().deserialize(name));
        armorStand.setCustomNameVisible(true);
        armorStand.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING, key);
        
        setupCrate(armorStand);

    }

    public Crate(ArmorStand stand){
        this.maxHealth = new Random().nextInt((120 - 80) + 1) + 80;
        setupCrate(stand);
    }

    private void setupCrate(ArmorStand stand){
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
        String key = stand.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING);
        this.stand = stand;
        startRotation(stand);
        keyMap.put(key, this);
    }

    @EventHandler
    public void DeathEvent(EntityRemoveFromWorldEvent event){
        if(event.getEntity() instanceof ArmorStand stand) {

            @NotNull String playerName = Objects.requireNonNull(event.getEntity().getCustomName());
            Player p = Bukkit.getServer().getPlayerExact(playerName);

            if (p == null) {
                return;
            }
            event.getEntity().getPassengers().clear();

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                int i = 5;
                while (i > 0) {
                    i--;
                }
                new Crate(event.getEntity(), event.getEntity().getLocation().getBlockX(), event.getEntity().getLocation().getBlockY(), event.getEntity().getLocation().getBlockZ());

            }, 20 * 30);


            Entity e = event.getEntity();

            PlayerStats stats = null;
            try {
                stats = Main.getInstance().getDatabase().findPlayerStats(p);

                if (stats == null) {

                    stats = new PlayerStats(p);
                    Main.getInstance().getDatabase().createPlayerStats(stats);

                }
            } catch (SQLException e1) {
                e1.printStackTrace();
            }


            int x = e.getLocation().getBlockX();
            double y = e.getLocation().getBlockY() + 1.7;
            int z = e.getLocation().getBlockZ();

            Crate crate = Crate.getCrateByKey(event.getEntity().getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "key"), PersistentDataType.STRING));

            p.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>Tot<dark_gray>> " + TextHandler.get("crate") + " <dark_gray>▸ " + TextHandler.get(crate.getRarity())));

            for(ItemStack stack : crate.getLootTable()) {
                Item item = e.getWorld().dropItem(new Location(Bukkit.getWorld("world"), x, y, z), stack);
                if (item.getItemStack().getType().equals(Material.ENCHANTED_BOOK)) {
                    item.setCustomName(item.getItemStack().getItemMeta().getDisplayName());
                    item.setCustomNameVisible(true);
                }
            }

            switch (crate.getRarity()){
                case "common" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0] + 1, stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4]});
                case "uncommon" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1] + 1, stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4]});
                case "epic" -> Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2] + 1, stats.getCrates()[3], stats.getCrates()[4]});
                case "rare" -> {
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3] + 1, stats.getCrates()[4]});
                    p.sendTitle(new Title("§6§kaa §x§D§3§D§F§0§0L§x§D§7§D§2§0§1e§x§D§B§C§4§0§3g§x§D§F§B§7§0§4e§x§E§2§A§9§0§5n§x§E§6§9§C§0§6d§x§E§A§8§E§0§8ä§x§E§E§8§1§0§9r §6§kaa", "§7Nachschub", 3, 35, 3));
                }
                case "mythic" -> {
                    Objects.requireNonNull(stats).setCrates(new int[]{stats.getCrates()[0], stats.getCrates()[1], stats.getCrates()[2], stats.getCrates()[3], stats.getCrates()[4] + 1});
                    p.sendTitle(new Title("§b§kaa §x§0§0§D§F§C§DM§x§0§1§D§1§B§By§x§0§3§C§4§A§9t§x§0§4§B§6§9§7h§x§0§6§A§9§8§6i§x§0§7§9§B§7§4s§x§0§9§8§E§6§2c§x§0§A§8§0§5§0h §b§kaa", "§7Nachschub", 3, 35, 3));
                }
            }

            try {
                Main.getInstance().getDatabase().updatePlayerStats(Objects.requireNonNull(stats));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    @EventHandler
    public void crateHitEvent(EntityDamageByEntityEvent event) {

        if (event.getEntity().getType() == EntityType.ARMOR_STAND) {

            if (event.getDamager().getType() == EntityType.PLAYER) {
                Entity e = event.getEntity();
                Player d = (Player) event.getDamager();
                double life = ((LivingEntity) e).getHealth();
                int Scale = (int) Math.pow(10, 1);
                int Damage = (int) ((Math.random() * 2) + 1) * 10;

                int FinalScale = (int) (Math.round(life * Scale) / Scale - Damage);

                if (Damage >= ((LivingEntity) e).getHealth()) {
                    ((LivingEntity) e).setHealth(0);
                } else {
                    ((LivingEntity) e).setHealth(((LivingEntity) e).getHealth() - Damage);
                    d.sendActionBar(MiniMessage.miniMessage().deserialize("<dark_gray><<red>" + FinalScale + "%<dark_gray>> " + TextHandler.get("crate") + " <dark_gray>▸ <gray>???"));
                }


                if (((LivingEntity) e).getHealth() <= 0) {
                    e.setCustomNameVisible(false);
                    e.setCustomName(event.getDamager().getName());
                    int x1 = e.getLocation().getBlockX();
                    int y1 = e.getLocation().getBlockY();
                    int z1 = e.getLocation().getBlockZ();
                    e.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                    e.remove();
                }

            }

        }
    }

    @EventHandler
    public void crateProjectileEvent(ProjectileHitEvent event){

        if(event.getHitEntity() == null || !(event.getEntity().getShooter() instanceof Player d)){
            return;
        }

        if (event.getHitEntity().getType() == EntityType.ARMOR_STAND) {
            if (event.getEntity().getType() == EntityType.ARROW) {
                Entity e1 = event.getHitEntity();
                double life = ((LivingEntity) e1).getHealth();
                int Scale = (int) Math.pow(10, 1);
                int i = (int) ((Math.random() * 2) + 1);
                int Damage = 20;
                if (i == 1) {
                    Damage = 10;
                }
                int FinalScale = (int) (Math.round(life * Scale) / Scale - Damage);
                d.sendActionBar("§8<§c" + FinalScale + "%§8> §x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???");

                if (Damage >= ((LivingEntity) e1).getHealth()) {
                    ((LivingEntity) e1).setHealth(0);
                } else {
                    ((LivingEntity) e1).setHealth(((LivingEntity) e1).getHealth() - Damage);
                }


                if (((LivingEntity) e1).getHealth() <= 0) {
                    e1.setCustomNameVisible(false);
                    e1.setCustomName(d.getName());
                    int x1 = e1.getLocation().getBlockX();
                    int y1 = e1.getLocation().getBlockY();
                    int z1 = e1.getLocation().getBlockZ();
                    e1.getWorld().spawnParticle(Particle.CRIT, new Location(Bukkit.getWorld("world"), x1, y1, z1), 15);
                    e1.remove();
                }
            }
        }
    }


    private static Crate getCrateByKey(String key){
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
