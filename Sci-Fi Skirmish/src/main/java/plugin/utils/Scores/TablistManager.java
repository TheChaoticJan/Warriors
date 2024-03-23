package plugin.utils.Scores;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import plugin.Main;

public class TablistManager{

    Main plugin;

    public TablistManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setTablist(Player player){

        player.setPlayerListHeaderFooter("""

                §8§m         §8[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§lk§x§2§B§3§C§F§F§li§x§4§1§1§4§F§F§lr§x§5§D§0§2§F§E§lm§x§8§0§0§5§F§C§li§x§A§3§0§8§F§B§ls§x§C§6§0§B§F§9§lh§8]§8§m        \s
                
                §f""","");
    }

    public void setAllPlayerTeams(){
        Bukkit.getOnlinePlayers().forEach(this::setPlayerTeams);

    }

    public void setPlayerTeams(Player player){

        Scoreboard scoreboard = player.getScoreboard();

        Team players = scoreboard.getTeam("bplayers");

        if(players == null){
            players = scoreboard.registerNewTeam("bplayers");
        }

        Team ops = scoreboard.getTeam("aoperators");

        if(ops == null){
            ops = scoreboard.registerNewTeam("aoperators");
        }

        players.setPrefix(" §x§F§F§E§2§5§9§lS§x§F§F§D§8§5§8§lp§x§F§F§C§E§5§6§li§x§F§F§C§5§5§5§le§x§F§F§B§B§5§4§ll§x§F§F§B§1§5§2§le§x§F§F§A§7§5§1§lr §8| ");
        players.setColor(ChatColor.GRAY);

        ops.setPrefix(" §x§7§0§3§4§E§6§lM§x§7§9§3§B§E§7§lo§x§8§2§4§3§E§8§ld§x§8§B§4§A§E§8§le§x§9§4§5§1§E§9§lr§x§9§C§5§8§E§A§la§x§A§5§6§0§E§B§lt§x§A§E§6§7§E§B§lo§x§B§7§6§E§E§C§lr §8| ");
        ops.setColor(ChatColor.GRAY);



        for( Player target : Bukkit.getOnlinePlayers()){
            if(target.isOp()){
                ops.addEntry(target.getName());
                continue;
            }
              players.addEntry(target.getName());
            }

        }
    }
