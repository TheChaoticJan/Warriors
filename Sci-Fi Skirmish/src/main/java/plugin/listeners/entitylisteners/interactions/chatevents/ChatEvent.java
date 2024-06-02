package plugin.listeners.entitylisteners.interactions.chatevents;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.PlayerCombatHandler;
import plugin.models.TextHandler;
import plugin.ranksystem.models.RankHandler;

import java.sql.SQLException;

public class ChatEvent implements Listener {

    @EventHandler
    public void onCommandEvent(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();

        if (PlayerCombatHandler.getCombatStatusByPlayer(player).getCombatStatus() && !player.isOp()) {
            event.setCancelled(true);
            player.sendActionBar("§c§lDu kannst keine Befehle ausführen, während du im Kampf bist!");
            player.playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO, 20, 1);
        }
    }

    @EventHandler
    public void onChatEvent(PlayerChatEvent event) {

        Player player = event.getPlayer();

        event.setMessage(TextHandler.stringToMiniMessage(event.getMessage()));

        try {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);
            if (stats == null) {
                stats = new PlayerStats(player);
                Main.getInstance().getDatabase().createPlayerStats(stats);
            }
            if (!(RankHandler.isTeamler(stats.getRank()))) {

                StringBuilder toFullMessage = new StringBuilder();
                StringBuilder toFullWord = new StringBuilder();

                ChatLists chatLists = new ChatLists();

                for (String word : event.getMessage().split("\\s+")) { // Splitting by whitespace
                    toFullMessage.append(word);

                    // Clear toFullWord instead of deleting characters one by one
                    toFullWord.setLength(0);

                    // Loop through each character of the word
                    for (int i = 0; i < word.length(); i++) {
                        toFullWord.append(word.charAt(i));

                        // Convert both toFullMessage and toFullWord to lowercase for case-insensitive comparison
                        String fullMessageLower = toFullMessage.toString().toLowerCase();
                        String fullWordLower = toFullWord.toString().toLowerCase();

                        // Check if either the full message, word, or full word is in the filter list
                        if (chatLists.getFilterList().contains(fullMessageLower) ||
                                chatLists.getFilterList().contains(word.toLowerCase()) ||
                                chatLists.getFilterList().contains(fullWordLower)) {

                            // Check if both the full message and word are not in the okay list
                            if (!(chatLists.getOkayList().contains(fullMessageLower) && chatLists.getOkayList().contains(word.toLowerCase()))) {

                                // Send message to player
                                player.sendMessage(MiniMessage.miniMessage().deserialize(
                                        "\n<gray>  ==================================================" +
                                                "\n<white> Deine Nachricht wurde nicht abgesendet, da sie gegen unsere Regeln verstößt!<reset>\n"
                                                + "<red><b> Solltest du versuchen, den Filter zu umgehen, wird dies bestraft.</b>\n" +
                                                "<gray>  ==================================================\n"
                                ));

                                // Send message to online moderators and admins
                                for (Player people : Bukkit.getOnlinePlayers()) {
                                    stats = Main.getInstance().getDatabase().findPlayerStats(people);
                                    if (RankHandler.isTeamler(stats.getRank())) {
                                        people.sendMessage(MiniMessage.miniMessage().deserialize(
                                                "\n<hover:show_text:'<gray>Nachricht aus dem <red>Chatfilter'><dark_gray><<red>\uD83D\uDCAC<dark_gray>><reset> <red>Chatfilter Nachricht!<reset>\n \n"
                                                        + "<gray>Spieler: " + TextHandler.setRankGradient(Main.getInstance().getDatabase().findPlayerStats(event.getPlayer()).getRank()) + event.getPlayer().getName() + "</gradient>\n"
                                                        + "<gray>Geflaggtes Wort: <red>" + replaceChars(toFullWord.toString()) + " <white>| <red>" + replaceChars(word) + "\n"
                                                        + "<gray>Nachricht: <gray>'<reset>"
                                                        + event.getMessage() + "<gray>'\n"
                                        ));
                                    }
                                }
                                event.setCancelled(true);
                                return;
                            }
                        }
                    }
                }
            }

            String rank = TextHandler.setRankGradient(stats.getRank()) + event.getPlayer().getName() + " <gray>▸<white>";

            if (event.getMessage().startsWith("!tc") && RankHandler.isTeamler(stats.getRank())) {
                event.setCancelled(true);

                for (Player people : Bukkit.getOnlinePlayers()) {
                    stats = Main.getInstance().getDatabase().findPlayerStats(people);
                    if (RankHandler.isTeamler(stats.getRank())) {

                        people.sendMessage(MiniMessage.miniMessage().deserialize("<hover:show_text:'<red>Diese Nachricht wurde im Teamchat verschickt'><dark_gray><<red>❗<dark_gray>><reset> " + rank + event.getMessage().replace("!tc", "")));
                    }
                }
                return;
            }

            if (event.getMessage().startsWith("7")) {
                event.setCancelled(true);
                player.sendMessage("§cDeine Nachricht wurde nicht abgesendet! \n§7Wolltest du nicht: §e" + event.getMessage().replace("7", "/") + " §7schreiben?");
                return;
            }

            event.setCancelled(true);

            Bukkit.broadcast(MiniMessage.miniMessage().deserialize(rank + " " +  TextHandler.stringToMiniMessage(event.getMessage())));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        private static String replaceChars (String string){

            return string
                    .replace(",", "")
                    .replace(".", "")
                    .replace(" ", "")
                    .replace("_", "")
                    .replace("-", "")
                    .replace("°", "")
                    .replace("^", "")
                    .replace("0", "o")
                    .replace("1", "i");

        }
    }
