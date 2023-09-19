package jansparadise.jansparadise.events.PlayerOrEntityEvents;

import jansparadise.jansparadise.JansParadise;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.Scoreboardbuilder.ScoreBoardBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.sql.SQLException;


public class JoinEvent implements Listener {

    JansParadise plugin;

    public JoinEvent(JansParadise plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void joinEvent(PlayerJoinEvent event) throws SQLException {

        Player p = event.getPlayer();

        for (int i = 0; i < plugin.VanishList.size(); i++) {
            if (!p.isOp()) {
                p.hidePlayer(plugin, plugin.VanishList.get(i));
            }
        }
        if(plugin.VanishList.contains(p)){
            p.setDisplayName("§x§7§0§3§4§E§6§lM§x§7§9§3§B§E§7§lo§x§8§2§4§3§E§8§ld§x§8§B§4§A§E§8§le§x§9§4§5§1§E§9§lr§x§9§C§5§8§E§A§la§x§A§5§6§0§E§B§lt§x§A§E§6§7§E§B§lo§x§B§7§6§E§E§C§lr §8| §7"+p.getPlayerListName() + " §5§lV");
        }


        try{
            PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

            if(stats == null){

                stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), 0, 0, 0,0, 0, 0, 0, 0, 0, 0, "");

                this.plugin.getDatabase().createPlayerStats(stats);

            }

            p.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, p));
            JansParadise.getInstance().getTablistManager().setTablist(p);
            JansParadise.getInstance().getTablistManager().setAllPlayerTeams();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}


