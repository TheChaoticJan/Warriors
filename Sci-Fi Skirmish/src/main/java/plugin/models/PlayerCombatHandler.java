package plugin.models;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.utils.Scores.ScoreBoardBuilder;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class PlayerCombatHandler{

    public static Map<Player, BossBar> playerBossBars = new HashMap<>();
    public static Map<Player, Integer> playerTaskIDs = new HashMap<>();
    private final Player player;
    private static HashMap<Player, PlayerCombatHandler> playerMap = new HashMap<>();
    private @Getter @Setter Player lastAttacked;
    private @Getter @Setter Boolean combatStatus;
    private long timeStamp;
    public PlayerCombatHandler(Player player){
        this.player = player;
        playerMap.put(this.player, this);
        this.combatStatus = false;
        this.lastAttacked = null;
    }

    public static PlayerCombatHandler getCombatStatusByPlayer(Player player){
        return playerMap.get(player);
    }

    private boolean canBeRemovedFromCombat(long timeStamp){
        return System.currentTimeMillis() - 10000 >= timeStamp;
    }

    public void startCombat(Player victim, boolean stopLoop){
        this.combatStatus = true;
        this.lastAttacked = victim;
        this.timeStamp = System.currentTimeMillis();

        if(!(playerBossBars.get(player) == null)) {
            playerBossBars.get(player).removePlayer(player);
            playerBossBars.remove(player);
        }

        createBossBarForPlayer(player);
        startBossBarCountdown(player);

        if(!stopLoop) {
            getCombatStatusByPlayer(victim).startCombat(this.player, true);
        }

    }

    public void startUnCombatCheck(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if(canBeRemovedFromCombat(timeStamp)){
                    combatStatus = false;
                    try {
                        ScoreBoardBuilder.Scoreboard(Main.getInstance().getDatabase().findPlayerStats(player), player);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, 5, 5);
    }

    public static void createBossBarForPlayer(Player player) {
        BossBar bossBar = Bukkit.createBossBar("§cDU BEFINDEST DICH IM KAMPF", BarColor.RED, BarStyle.SOLID);
        bossBar.addPlayer(player);
        bossBar.setVisible(true);
        playerBossBars.put(player, bossBar);
    }

    private void startBossBarCountdown(Player player) {
        BossBar bossBar = playerBossBars.get(player);
        if (bossBar == null) return;
        int taskID = new BukkitRunnable() {
            double progress = 1.0;
            double step = 0.01;
            @Override
            public void run() {
                if (progress > 0 && progress > step) {
                    progress -= step;
                    bossBar.setProgress(progress);
                } else {
                    bossBar.setVisible(false);
                    bossBar.removePlayer(player);
                    this.cancel();
                }
            }
        }.runTaskTimer(Main.getInstance(), 0L, 2L).getTaskId(); // runs every 2 ticks (0.1 second)

        playerTaskIDs.put(player, taskID);
    }
}
