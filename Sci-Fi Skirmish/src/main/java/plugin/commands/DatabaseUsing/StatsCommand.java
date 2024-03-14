package plugin.commands.DatabaseUsing;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.Text.Texts;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class StatsCommand implements CommandExecutor, TabCompleter{

    Main plugin;

    public StatsCommand(Main plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p) {

            if (strings.length > 1) {
                p.sendMessage("§cBitte verwende: §7'§e/stats <Spielername>§7'");
                return true;
            } else {

                if(strings.length == 0){
                    strings[0] = p.getName();
                }
                OfflinePlayer offlinePlayer =  Bukkit.getOfflinePlayer(strings[0]);

                if(!offlinePlayer.hasPlayedBefore()){
                    p.sendActionBar("§cDer Spieler §7'§f" + strings[0] + "§7' §cexistiert nicht auf unserem Server!");
                    return true;
                }

                try {
                    PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(offlinePlayer.getUniqueId().toString());

                    if (stats == null) {
                        p.sendActionBar("§cDer Spieler §7'§f" + strings[0] + "§7' §cexistiert nicht auf unserem Server!");
                        return true;
                    }else {
                        //setting stats
                        int c = stats.getCommon_crates();
                        int u = stats.getUncommon_crates();
                        int e = stats.getEpic_crates();
                        int r = stats.getRare_crates();
                        int m = stats.getMythic_crates();
                        int all = c + u + e + r + m;
                        int kills = stats.getKills();
                        int deaths = stats.getDeaths();

                        Inventory inventory = Bukkit.createInventory(p, InventoryType.HOPPER, "§0Stats von " + strings[0]);

                        //cratestats
                        ItemStack crates = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta skullMeta = (SkullMeta) crates.getItemMeta();
                        PlayerProfile playerProfile = Bukkit.createProfile(UUID.fromString("a75e3f60-2242-4429-8ece-bcde77"), "Player");
                        playerProfile.setProperty(new ProfileProperty("textures", "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNzY5ZmYyYjBlNTI0NTc0ZDEwYWYxNDBjODZlZWVkYzQzMzg0NGYzY2YxM2ViYThkMDhkZjZhMTRiNTVlYWE2YiJ9fX0="));
                        skullMeta.setPlayerProfile(playerProfile);
                        skullMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><u><b><gradient:#824622:#b4c468>Cratestats"));
                        ArrayList<Component> crateLore = new ArrayList<Component>();
                        crateLore.add(Component.text(""));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + Texts.get("common") + "<#ffffff>: " + c));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + Texts.get("uncommon") + "<#ffffff>: " + u));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + Texts.get("epic") + "<#ffffff>: " + e));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + Texts.get("rare") + "<#ffffff>: " + r));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + Texts.get("mythic") + "<#ffffff>: " + m));
                        crateLore.add(Component.text(""));
                        crateLore.add(Component.text("§7Insgesamt geöffnet: " + all));
                        skullMeta.lore(crateLore);
                        crates.setItemMeta(skullMeta);
                        inventory.setItem(1, crates);


                        //playerstats
                        ItemStack players = new ItemStack(Material.PLAYER_HEAD);
                        SkullMeta playerSkullMeta = (SkullMeta) players.getItemMeta();
                        playerSkullMeta.setOwningPlayer(offlinePlayer);
                        playerSkullMeta.displayName(MiniMessage.miniMessage().deserialize("<i:false><u><b><gradient:#21b161:#8ec468>Spielerstats"));
                        ArrayList<Component> playerLore = new ArrayList<>();
                        switch (stats.getRank()) {
                            default ->
                                    playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Rang: <gradient:#FFE259:#FFA751>Spieler"));
                            case "Moderator" ->
                                    playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Rang: <gradient:#7034E6:#b76eec>Moderator"));
                            case "Admin" ->
                                    playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Rang: <gradient:#FF0000:#ad0d34>Admin"));
                        }
                        playerLore.add(Component.text(""));
                        playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><#ffffff>XP: <#21b161>" + stats.getXp() + "<#29ac64>✧"));
                        playerLore.add(Component.text(""));
                        playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Kills: <red>" + stats.getKills()));
                        playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>Tode: <yellow>" + stats.getDeaths()));
                        if(stats.getDeaths() == 0){
                            stats.setDeaths(1);
                        }
                        double kd = (double) stats.getKills() / stats.getDeaths();
                        kd = Math.round(kd * 100)/100.00;
                        playerLore.add(MiniMessage.miniMessage().deserialize("<i:false><white>K/D: <gold>" + kd + "⚔"));
                        playerSkullMeta.lore(playerLore);
                        players.setItemMeta(playerSkullMeta);
                        inventory.setItem(3, players);

                        p.openInventory(inventory);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1) {
            return null;
        }
        return Collections.singletonList("");
    }
}
