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
import plugin.models.TextHandler;

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
            try {

            if(strings.length == 0){
               strings = new String[]{p.getName()};
            }

            if (strings.length > 1) {
                p.sendMessage("§cBitte verwende: §7'§e/stats <Spielername>§7'");
                return true;
            }

                OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(strings[0]);

                if(!offlinePlayer.hasPlayedBefore()){
                    p.sendActionBar("§cDer Spieler §7'§f" + strings[0] + "§7' §cexistiert nicht auf unserem Server!");
                    return true;
                }

                PlayerStats stats = this.plugin.getDatabase().findPlayerStats(offlinePlayer);

                    if (stats == null) {
                        p.sendActionBar("§cDer Spieler §7'§f" + strings[0] + "§7' §cexistiert nicht auf unserem Server!");
                        return true;
                    }else {
                        //setting stats
                        int c = stats.getCrates()[0];
                        int u = stats.getCrates()[1];
                        int e = stats.getCrates()[2];
                        int r = stats.getCrates()[3];
                        int m = stats.getCrates()[4];
                        int all = c + u + e + r + m;



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
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + TextHandler.get("common") + "<#ffffff>: " + c + " <gray><i>(" + Math.round((float) c /all * 10000)/100.00 + "%)"));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + TextHandler.get("uncommon") + "<#ffffff>: " + u + " <gray><i>(" + Math.round((float) u /all * 10000)/100.00 + "%)"));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + TextHandler.get("epic") + "<#ffffff>: " + e + " <gray><i>(" + Math.round((float) e /all * 10000)/100.00 + "%)"));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + TextHandler.get("rare") + "<#ffffff>: " + r + " <gray><i>(" + Math.round((float) r /all * 10000)/100.00 + "%)"));
                        crateLore.add(MiniMessage.miniMessage().deserialize("<i:false>" + TextHandler.get("mythic") + "<#ffffff>: " + m + " <gray><i>(" + Math.round((float) m /all * 10000)/100.00 + "%)"));
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
                }catch (SQLException e){
                e.printStackTrace();
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
