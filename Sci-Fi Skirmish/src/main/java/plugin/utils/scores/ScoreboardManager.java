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

                §8§m         §8[§x§F§B§0§8§1§C§lW§x§F§7§1§B§2§5§la§x§F§4§2§D§2§D§lr§x§F§0§4§0§3§6§lr§x§E§D§5§3§3§F§li§x§E§9§6§6§4§8§lo§x§E§6§7§8§5§0§lr§x§E§2§8§B§5§9§ls§8]§m        \s
                
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
                objective = scoreboard1.registerNewObjective(player.getName(), "dummy",   MiniMessage.miniMessage().deserialize(" <obf><red>a</obf> <gradient:red:gold><b>Warriors <obf><gold>a "));
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
