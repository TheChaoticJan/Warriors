package plugin.commands.DatabaseUsing;

import plugin.Main;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopCommand implements CommandExecutor, TabCompleter {

    Main plugin;

    public TopCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p){

            if(strings.length == 0){
                p.sendMessage("§cBitte benutze: §7'§e/top <Liste>§7'");
                return true;
            }

            try {
                switch (strings[0].toLowerCase()) {
                    case "xp" -> {

                        //getting Data
                        ArrayList<String> topXp = this.plugin.getDatabase().getTopTenStats("xp");
                        for (int i = 14 - topXp.size(); i <= 14; i++) {
                            topXp.add("§c---");
                        }

                        //formatting Text Message
                        String line0 = "\n§f";
                        String line1 = "§8§m    §8[§e§kaa §6§lDie Top 7 XP Sammler§7 §e§kaa§8]§8§m    ";
                        String line2 = "\n§f";
                        String line3 = "\n§e  1.  §d" + topXp.get(0) + "  §8§8»  §e" + topXp.get(1) + " §6✧";
                        String line4 = "\n§6  2.  §d" + topXp.get(2) + "  §8§8»  §e" + topXp.get(3) + " §6✧";
                        String line5 = "\n§c  3.  §d" + topXp.get(4) + "  §8§8»  §e" + topXp.get(5) + " §6✧";
                        String line6 = "\n§7  4.  §d" + topXp.get(6) + "  §8§8»  §e" + topXp.get(7) + " §6✧";
                        String line7 = "\n§7  5.  §d" + topXp.get(8) + "  §8§8»  §e" + topXp.get(9) + " §6✧";
                        String line8 = "\n§7  6.  §d" + topXp.get(10) + "  §8§8»  §e" + topXp.get(11) + " §6✧";
                        String line9 = "\n§7  7.  §d" + topXp.get(12) + "  §8§8»  §e" + topXp.get(13) + " §6✧";
                        String line10 = "\n§f";
                        //sending Text Message
                        p.sendMessage(line0 + line1 + line2 + line3 + line4 + line5 + line6 + line7 + line8 + line9 + line10);
                    }
                    case "mythische" -> {

                        //getting Data
                        ArrayList<String> topMythics = this.plugin.getDatabase().getTopTenStats("mythic_crates");
                        for (int i = 14 - topMythics.size(); i <= 14; i++) {
                            topMythics.add("§c---");
                        }

                        //formatting Text Message
                        String line01 = "\n§f";
                        String line11 = "§8§m    §8[§b§kaa §3§lDie Top 7 Cratelucker §b§kaa§8]§8§m    ";
                        String line21 = "\n§f";
                        String line31 = "\n§e  1.  §d" + topMythics.get(0) + "  §8§8»  §b" + topMythics.get(1) + " §3Mythische";
                        String line41 = "\n§6  2.  §d" + topMythics.get(2) + "  §8§8»  §b" + topMythics.get(3) + " §3Mythische";
                        String line51 = "\n§c  3.  §d" + topMythics.get(4) + "  §8§8»  §b" + topMythics.get(5) + " §3Mythische";
                        String line61 = "\n§7  4.  §d" + topMythics.get(6) + "  §8§8»  §b" + topMythics.get(7) + " §3Mythische";
                        String line71 = "\n§7  5.  §d" + topMythics.get(8) + "  §8§8»  §b" + topMythics.get(9) + " §3Mythische";
                        String line81 = "\n§7  6.  §d" + topMythics.get(10) + "  §8§8»  §b" + topMythics.get(11) + " §3Mythische";
                        String line91 = "\n§7  7.  §d" + topMythics.get(12) + "  §8§8»  §b" + topMythics.get(13) + " §3Mythische";
                        String line101 = "\n§f";

                        //sending Text Message
                        p.sendMessage(line01 + line11 + line21 + line31 + line41 + line51 + line61 + line71 + line81 + line91 + line101);
                    }
                    case "kills" -> {

                        //getting Data
                        ArrayList<String> topKills = this.plugin.getDatabase().getTopTenStats("kills");
                        for (int i = 14 - topKills.size(); i <= 14; i++) {
                            topKills.add("§c---");
                        }

                        //formatting Text Message
                        String line02 = "\n§f";
                        String line12 = "§8§m    §8[§4§kaa §c§lDie Top 7 Schlächter §4§kaa§8]§8§m    ";
                        String line22 = "\n§f";
                        String line32 = "\n§e  1.  §d" + topKills.get(0) + "  §8§8»  §c" + topKills.get(1) + " ⚔";
                        String line42 = "\n§6  2.  §d" + topKills.get(2) + "  §8§8»  §c" + topKills.get(3) + " ⚔";
                        String line52 = "\n§c  3.  §d" + topKills.get(4) + "  §8§8»  §c" + topKills.get(5) + " ⚔";
                        String line62 = "\n§7  4.  §d" + topKills.get(6) + "  §8§8»  §c" + topKills.get(7) + " ⚔";
                        String line72 = "\n§7  5.  §d" + topKills.get(8) + "  §8§8»  §c" + topKills.get(9) + " ⚔";
                        String line82 = "\n§7  6.  §d" + topKills.get(10) + "  §8§8»  §c" + topKills.get(11) + " ⚔";
                        String line92 = "\n§7  7.  §d" + topKills.get(12) + "  §8§8»  §c" + topKills.get(13) + " ⚔";
                        String line102 = "\n§f";

                        //sending Text Message
                        p.sendMessage(line02 + line12 + line22 + line32 + line42 + line52 + line62 + line72 + line82 + line92 + line102);
                    }
                    case "uwu" -> {

                        //getting Data
                        ArrayList<String> topUwU = this.plugin.getDatabase().getTopTenStats("uwu");
                        for (int i = 14 - topUwU.size(); i <= 14; i++) {
                            topUwU.add("§c---");
                        }

                        //formatting Text Message
                        String line03 = "\n§f";
                        String line13 = "§8§m    §8[§5§kaa §d§lDie Top 7 UwU-Bienchen §5§kaa§8]§8§m    ";
                        String line23 = "\n§f";
                        String line33 = "\n§e  1.  §d" + topUwU.get(0) + "  §8§8»  §d" + topUwU.get(1) + " ♛";
                        String line43 = "\n§6  2.  §d" + topUwU.get(2) + "  §8§8»  §d" + topUwU.get(3) + " ♛";
                        String line53 = "\n§c  3.  §d" + topUwU.get(4) + "  §8§8»  §d" + topUwU.get(5) + " ♛";
                        String line63 = "\n§7  4.  §d" + topUwU.get(6) + "  §8§8»  §d" + topUwU.get(7) + " ♛";
                        String line73 = "\n§7  5.  §d" + topUwU.get(8) + "  §8§8»  §d" + topUwU.get(9) + " ♛";
                        String line83 = "\n§7  6.  §d" + topUwU.get(10) + "  §8§8»  §d" + topUwU.get(11) + " ♛";
                        String line93 = "\n§7  7.  §d" + topUwU.get(12) + "  §8§8»  §d" + topUwU.get(13) + " ♛";
                        String line103 = "\n§f";

                        //sending Text Message
                        p.sendMessage(line03 + line13 + line23 + line33 + line43 + line53 + line63 + line73 + line83 + line93 + line103);
                    }
                }



            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(strings.length == 1){
            ArrayList<String> sc = new ArrayList<>();
            sc.add("xp");
            sc.add("uwu");
            sc.add("mythische");
            sc.add("kills");

            return sc;

        }
        return Collections.singletonList("");
    }
}
