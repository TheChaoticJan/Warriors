package plugin.utils.scores;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.TextHandler;

import java.sql.SQLException;
import java.util.Objects;

public class ScoreboardManager {

    Main plugin;

    private static final Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();

    public ScoreboardManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setTablist(Player player){

        player.setPlayerListHeaderFooter("""

                §8§m         §8[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§lk§x§2§B§3§C§F§F§li§x§4§1§1§4§F§F§lr§x§5§D§0§2§F§E§lm§x§8§0§0§5§F§C§li§x§A§3§0§8§F§B§ls§x§C§6§0§B§F§9§lh§8]§8§m        \s
                
                §f""","");
    }

    public void setAllPlayerTeams(){

            for (Player player : Bukkit.getOnlinePlayers()) {
                setPlayerTeams(player);
            }

    }

    public void setScoreboard(Player player){

        Scoreboard scoreboard1 = Bukkit.getScoreboardManager().getNewScoreboard();

        try {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);


            //Vorbereitungen für K/D
            if (stats.getDeaths() == 0) {
                stats.setDeaths(1);
            }
            double kd = (double) stats.getKills() / stats.getDeaths();
            kd = Math.round(kd * 100) / 100.00;

            for(Team team : scoreboard.getTeams()){
                Team newTeam = scoreboard1.registerNewTeam(team.getName());
                for(String s : team.getEntries()){
                    newTeam.addEntry(s);
                }
            }
            Objective objective;
            if (scoreboard1.getObjective(player.getName()) == null) {
                objective = scoreboard1.registerNewObjective(player.getName(), "dummy", "  §x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§lk§x§2§B§3§C§F§F§li§x§4§1§1§4§F§F§lr§x§5§D§0§2§F§E§lm§x§8§0§0§5§F§C§li§x§A§3§0§8§F§B§ls§x§C§6§0§B§F§9§lh  ");
            } else {
                objective = scoreboard1.getObjective(player.getName());
            }
            objective.setDisplaySlot(DisplaySlot.SIDEBAR);

            Score score1 = objective.getScore("§a ");
            Score score2 = objective.getScore("§b §8· §fDein Rang:");
            Score score3 = null;

            switch (stats.getRank()) {
                case "Admin" -> score3 = objective.getScore(("§c   §8▸ §c" + stats.getRank()));
                case "Moderator" -> score3 = objective.getScore("§c   §8▸ §5Moderator");
                case "Spieler" -> score3 = objective.getScore("§c   §8▸ §6Spieler");
                case "Inhaber" -> score3 = objective.getScore("§c   §8▸ §3Inhaber");
                case "Goat" -> score3 = objective.getScore("§c   §8▸ §eGoat");
                case "Simp" -> score3 = objective.getScore("§c   §8▸ §dSimp");
            }

            Score score4 = objective.getScore("§d ");
            Score score5 = objective.getScore("§e §8· §fDeine XP:");
            Score score6 = objective.getScore("§f   §8▸§e " + stats.getXp() + " §6✧");
            Score score7 = objective.getScore("§j  ");
            Score score9 = objective.getScore("§k §8· §fK/D:");
            Score score10 = objective.getScore("§p   §8▸§c " + kd + " ⚔");

            score1.setScore(0);
            score2.setScore(0);
            score3.setScore(0);
            score4.setScore(0);
            score5.setScore(0);
            score6.setScore(0);
            score7.setScore(0);
            score9.setScore(0);
            score10.setScore(0);
        }catch (SQLException e){
            e.printStackTrace();
        }

        player.setScoreboard(scoreboard1);
    }

    public void removeAllPlayerTeams(){

        for(Team team : scoreboard.getTeams()) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (team.hasPlayer(player)) {
                    team.removePlayer(player);
                }
            }
        }
    }

    public void registerAllTeams() {

        String[] teamnames = new String[]{"aInhaber", "bAdmin", "cModerator", "dGoat", "eSimp", "fSpieler"};

        for (String s : teamnames) {
            if (scoreboard.getTeam(s) != null) {
                Objects.requireNonNull(scoreboard.getTeam(s)).unregister();
            }
            scoreboard.registerNewTeam(s);
        }

    }

    private void setPlayerTeams(Player player) {

        try {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

            String rank = stats.getRank();
            String prefix = TextHandler.setRankGradient(rank) + "<b>" + rank + "<reset> ";

            // Define the order for sorting prefixes
            String teamName;
            switch (rank) {
                case "Inhaber" -> teamName = "aInhaber";
                case "Admin" -> teamName = "bAdmin";
                case "Moderator" -> teamName = "cModerator";
                case "Goat" -> teamName = "dGoat";
                case "Simp" -> teamName = "eSimp";
                default -> teamName = "fSpieler";
            }

            Team team = scoreboard.getTeam(teamName);

            if (team == null) {
                team = scoreboard.registerNewTeam(teamName);
            }

            // Set the team prefix
            team.prefix(MiniMessage.miniMessage().deserialize(prefix));
            // Add player to the team
            team.addPlayer(player);
            // Update player's display name and tab list name
            player.displayName(MiniMessage.miniMessage().deserialize(prefix + player.getName()));
            player.playerListName(MiniMessage.miniMessage().deserialize(prefix + player.getName()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
