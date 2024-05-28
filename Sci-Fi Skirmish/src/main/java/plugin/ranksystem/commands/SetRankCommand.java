package plugin.ranksystem.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.ranksystem.models.RankHandler;
import plugin.utils.Scores.ScoreBoardBuilder;
import plugin.models.TextHandler;
import plugin.utils.Scores.TablistManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SetRankCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(args.length != 2){
            commandSender.sendMessage("§cBitte verwende den Befehl wie folgend: §7'§e/setrank <Spieler> (Rang)§7'");
            return true;
        }

        if(Bukkit.getPlayerExact(args[0]) == null){
            commandSender.sendMessage("§cDer Spieler " + args[0] + " ist nicht Online!");
            return true;
        }

        if(!(RankHandler.rankList().contains(args[1]))){
            commandSender.sendMessage("§cDieser Rang existiert nicht!");
            return true;
        }

        try {
            Player player = Bukkit.getPlayerExact(args[0]);
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);
            stats.setRank(args[1]);
            player.sendMessage(MiniMessage.miniMessage().deserialize( "<white>Dein Rang wurde geupdated! Neuer Rang: " + TextHandler.setRankGradient(args[1]) + args[1]));
            commandSender.sendMessage(MiniMessage.miniMessage().deserialize("<white> Du hast erfolgreich den Rang von <aqua>" + player.getName() + "<white> geupdated! \n<white>Neuer Rang: " + TextHandler.setRankGradient(stats.getRank()) + stats.getRank()));
            Main.getInstance().getDatabase().updatePlayerStats(stats);
            player.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, player));

        }catch (SQLException e){
            e.printStackTrace();
        }

        Main.getInstance().getTablistManager().setAllPlayerTeams();

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length != 1 && strings.length != 2){
            return Collections.singletonList("");
        }

        if(strings.length == 2){
            ArrayList<String> list = new ArrayList<>();
            list.add("Spieler");
            list.add("Moderator");
            list.add("Admin");
            list.add("Inhaber");
            list.add("Goat");
            list.add("Simp");
            return list;
        }

        return null;

    }
}
