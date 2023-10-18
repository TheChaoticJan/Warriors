package plugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import plugin.Main;
import plugin.utils.Scores.ScoreBoardBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class CombatLogger {

    private static final ArrayList<Player> inCombatMap = new ArrayList<>();
    private static final HashMap<Player, Player> inCombatWithMap = new HashMap<>();

    public static void setInCombat(Player combat1, Player combat2){
        try {
        inCombatMap.add(combat1);
        inCombatMap.add(combat2);
        combat1.setScoreboard(ScoreBoardBuilder.Scoreboard(Main.getInstance().getDatabase().findPlayerStatsByUUID(String.valueOf(combat1.getUniqueId())), combat1));
        combat1.setScoreboard(ScoreBoardBuilder.Scoreboard(Main.getInstance().getDatabase().findPlayerStatsByUUID(String.valueOf(combat2.getUniqueId())), combat2));

        if(!CombatLogger.isInCombat(combat1)) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    CombatLogger.removeFromCombat(combat1);
                    try {
                        combat1.setScoreboard(ScoreBoardBuilder.Scoreboard(Main.getInstance().getDatabase().findPlayerStatsByUUID(String.valueOf(combat1.getUniqueId())), combat1));
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }, 20 * 10);
        }
            if(!CombatLogger.isInCombat(combat2)) {
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                    @Override
                    public void run() {
                        CombatLogger.removeFromCombat(combat2);
                        try {
                            combat1.setScoreboard(ScoreBoardBuilder.Scoreboard(Main.getInstance().getDatabase().findPlayerStatsByUUID(String.valueOf(combat2.getUniqueId())), combat2));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
                }, 20 * 10);
            }
        inCombatWithMap.put(combat1, combat2);
        inCombatWithMap.put(combat2, combat1);
    } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static Boolean isInCombat(Player p){
        return inCombatMap.contains(p);
    }

    public static void removeFromCombat(Player p){
        inCombatMap.remove(p);
        inCombatWithMap.remove(p);
    }

    public static Player isInCombatWith(Player getCombatState) {

        if(inCombatWithMap.get(getCombatState) != null){
         return inCombatWithMap.get(getCombatState);
        }
        return null;
    }
}
