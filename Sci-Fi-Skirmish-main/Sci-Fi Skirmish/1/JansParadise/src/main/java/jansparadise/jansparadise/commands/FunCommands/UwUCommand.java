package jansparadise.jansparadise.commands.FunCommands;


import jansparadise.jansparadise.Main;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.Scoreboardbuilder.ScoreBoardBuilder;
import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.sql.*;
import java.util.Collections;
import java.util.List;



public class UwUCommand implements CommandExecutor, TabCompleter {

    private final Main plugin;

    public UwUCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if(!(sender instanceof Player)){
            sender.sendMessage("§cDu musst ein Spieler sein um §7´/uwu´ §causführen zu können!");
        }
        else if(args.length != 1){
            sender.sendMessage("§cBitte benutze: §7`§e/uwu <Spielername>§7`");
        }
        else{
            Player p = (Player) sender;
            String playername = args[0];

            Player r = Bukkit.getServer().getPlayerExact(playername);
            if(r != null) {
                if( r == p){
                    p.sendMessage("§cDas ergibt keinen Sinn!");
                    return true;
                }
                r.sendMessage(

                        "\n" +
                                " \n" +
                                "§7=============================================\n" +
                                " \n" +
                                "      §d" + p.getDisplayName() + " §fwünscht dir jetzt ein herzliches:\n" +
                                " \n" +
                                "                         §b§k§lsd §d§lUwU §b§k§lsd\n" +
                                "                  §7(§f+1 §dUwU§f-Punkt§7)\n" +
                                " \n" +
                                "§7=============================================\n" +
                                " \n" +
                                " \n"



                     );
                p.sendMessage("§7Du hast " + r.getName() + " §7erfolgreich ein §b§kaa §d§lUwU §b§kaa §7gewünscht");



            }else {
                p.sendMessage("§cDer Spieler §7`" + playername + "` §cist nicht online!");
                return true;
            }

            try{
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(r.getUniqueId().toString());

                if(stats == null){
                    stats = new PlayerStats(r.getUniqueId().toString(), r.getName(), "", 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1, 2, 3);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }else {
                    stats.setUwu(stats.getUwu() + 1);
                    this.plugin.getDatabase().updatePlayerStats(stats);
                }

                r.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, r));

            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            return null;
        }
        return Collections.singletonList("");
    }
}
