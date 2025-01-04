package plugin.moderation;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Display;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.bukkit.event.Listener;
import plugin.Main;
import plugin.listeners.entitylisteners.interactions.RightClickEvent;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class CheckCPSCommand implements Listener, CommandExecutor, TabCompleter {

    private static final HashMap<UUID, Integer> leftClickCounts = new HashMap<>();
    private static final HashMap<UUID, Integer> currentView = new HashMap<>();

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player) {

            if(currentView.get(player.getUniqueId()) != null){
               Bukkit.getScheduler().cancelTask(currentView.get(player.getUniqueId()));
               currentView.put(player.getUniqueId(), null);

               player.sendMessage("§cDu hast die Überwachung erfolgreich beendet!");
               return true;

            }

            if (strings.length != 1) {
                commandSender.sendMessage("§cBitte gib einen Spieler an, dessen CPS zu überprüfen möchtest");
                return true;
            }

            Player toCheck = Bukkit.getPlayerExact(strings[0]);
            if(toCheck == null){
                commandSender.sendMessage("§cDer Spieler §f" + strings[0] + " §cist nicht online!");
                return true;
            }
            toggleActionBarUpdater(player, toCheck);

        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length != 1){
            return Collections.singletonList("");
        }

        return null;
    }

    @EventHandler
    public void onPlayerClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();

        if(event.getAction().isLeftClick()) {
            leftClickCounts.put(playerId, leftClickCounts.getOrDefault(playerId, 0) + 1);
        }

    }

    private void toggleActionBarUpdater(Player sender, Player toCheck) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int lCPS = leftClickCounts.getOrDefault(toCheck.getUniqueId(), 0);

                // Display CPS in the player's action bar
                sender.sendActionBar("§8[§cCPS§8] §e" + toCheck.getName() + " §7| §c" + lCPS);

                // Reset the click count for the next second
                leftClickCounts.put(toCheck.getUniqueId(), 0);
            }
        };

        int task = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), runnable, 20, 20);
        currentView.put(sender.getUniqueId(), task);

    }

}
