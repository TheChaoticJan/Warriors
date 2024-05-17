package plugin.utils.Scores;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;
import plugin.models.PlayerStats;
import plugin.utils.PlayerCombatHandler;

import java.util.Objects;

public class ScoreBoardBuilder {

    public static Scoreboard Scoreboard(PlayerStats stats, Player p){

        //Vorbereitungen für K/D
        if(stats.getDeaths() == 0){
            stats.setDeaths(1);
        }
        double kd = (double) stats.getKills() / stats.getDeaths();
        kd = Math.round(kd * 100)/100.00;

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("test", "dummy", "  §x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§lk§x§2§B§3§C§F§F§li§x§4§1§1§4§F§F§lr§x§5§D§0§2§F§E§lm§x§8§0§0§5§F§C§li§x§A§3§0§8§F§B§ls§x§C§6§0§B§F§9§lh  ");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score score1 = objective.getScore("§a ");
        Score score2 = objective.getScore("§b §8· §fDein Rang:");
        Score score3;
        if(Objects.equals(stats.getRank(), "Admin")){
            score3 = objective.getScore(("§c   §8▸ §c" + stats.getRank()));
        }else if (Objects.equals(stats.getRank(), "Moderator")){
            score3 = objective.getScore("§c   §8▸ §5Moderator");
        }else{
            score3 = objective.getScore("§c   §8▸ §6Spieler");
        }
        Score score4 = objective.getScore("§d ");
        Score score5 = objective.getScore("§e §8· §fDeine XP:");
        Score score6 = objective.getScore("§f   §8▸§e " + stats.getXp() + " §6✧");
        Score score7 = objective.getScore("§j  ");
        Score score9 = objective.getScore("§k §8· §fK/D:");
        Score score10 = objective.getScore("§p   §8▸§c " + kd + " ⚔");
        Score score11 = objective.getScore("§q");
        Score score8 = objective.getScore("§r    §8[§aNicht in Combat§8]");
        if(PlayerCombatHandler.isInCombat(p)){
            score8 = objective.getScore("§r       §8[§cIn Combat§8]");
        }

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

        return scoreboard;      //returning the scoreboard with the new, set, values
    }
}
