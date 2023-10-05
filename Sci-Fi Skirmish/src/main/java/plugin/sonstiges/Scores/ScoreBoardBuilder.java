package plugin.sonstiges.Scores;

import plugin.models.PlayerStats;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class ScoreBoardBuilder {

    public static Scoreboard Scoreboard(PlayerStats stats, Player p){

        //Vorbereitungen für K/D
        if(stats.getDeaths() == 0){
            stats.setDeaths(1);
        }
        double kd = stats.getKills()/stats.getDeaths();


        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("test", "dummy", "  §x§F§F§E§2§5§9W§x§F§F§D§C§5§8W§x§F§F§D§6§5§7-§x§F§F§D§0§5§7R§x§F§F§C§A§5§6e§x§F§F§C§5§5§5l§x§F§F§B§F§5§4o§x§F§F§B§9§5§3a§x§F§F§B§3§5§3d§x§F§F§A§D§5§2e§x§F§F§A§7§5§1t  ");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = objective.getScore("§a ");
        Score score2 = objective.getScore("§b §8· §7Dein Rang:");
        Score score3 = objective.getScore("§c");
        if(p.isOp()){
            score3 = objective.getScore("§c   §5Moderator");
        }else{
            score3 = objective.getScore("§c   §6Spieler");
        }

        Score score4 = objective.getScore("§d ");
        Score score5 = objective.getScore("§e §8· §7Deine XP:");
        Score score6 = objective.getScore("§f   §8ᐅ§e " + stats.getXp() + " §6✧");
        Score score7 = objective.getScore("§g ");
        Score score8 = objective.getScore("§h §8· §7Deine §dUwU§7-Punkte:");
        Score score9 = objective.getScore("§i   §8ᐅ§d " + stats.getUwu() + " ♛");
        Score score10 = objective.getScore("§j  ");
        Score score11 = objective.getScore("§o §8[§cKein Clan§8]");
        if(stats.getClan() != ""){
            score11 = objective.getScore("§s §8[§6" + stats.getClan() + "§8]");
        }
        Score score13 = objective.getScore("§o §8· §7K/D:");

        Score score12 = objective.getScore("§q");
        Score score14 = objective.getScore("§p   §8ᐅ§c " + Math.round(kd) + " ⚔");
        Score score15 = objective.getScore("§r");

        score1.setScore(0);
        score2.setScore(0);
        score3.setScore(0);
        score4.setScore(0);
        score5.setScore(0);
        score6.setScore(0);
        score7.setScore(0);
        score8.setScore(0);
        score9.setScore(0);
        score10.setScore(0);
        score11.setScore(0);
        score12.setScore(0);
        score13.setScore(0);
        score14.setScore(0);
        score15.setScore(0);

        return scoreboard;
    }
}
