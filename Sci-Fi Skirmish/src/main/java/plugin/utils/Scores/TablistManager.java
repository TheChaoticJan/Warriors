package plugin.utils.Scores;

import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class TablistManager{

    Main plugin;

    public TablistManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setTablist(Player player){

        player.setPlayerListHeaderFooter("\n§8§m         §8[§b§lJan´s Übungsraum§8]§8§m         " + "\n§x§F§F§E§2§5§9W§x§F§F§D§C§5§8W§x§F§F§D§6§5§7-§x§F§F§D§0§5§7R§x§F§F§C§A§5§6e§x§F§F§C§5§5§5l§x§F§F§B§F§5§4o§x§F§F§B§9§5§3a§x§F§F§B§3§5§3d§x§F§F§A§D§5§2e§x§F§F§A§7§5§1t \n§f" , "\n§x§3§4§9§4§E§6h§x§3§A§9§3§E§4t§x§4§0§9§1§E§2t§x§4§6§9§0§E§0p§x§4§D§8§F§D§Es§x§5§3§8§E§D§D:§x§5§9§8§C§D§B/§x§5§F§8§B§D§9/§x§6§5§8§A§D§7t§x§6§B§8§9§D§5w§x§7§1§8§7§D§3i§x§7§7§8§6§D§1t§x§7§E§8§5§C§Fc§x§8§4§8§4§C§Dh§x§8§A§8§2§C§B.§x§9§0§8§1§C§At§x§9§6§8§0§C§8v§x§9§C§7§E§C§6/§x§A§2§7§D§C§4T§x§A§9§7§C§C§2h§x§A§F§7§B§C§0e§x§B§5§7§9§B§EC§x§B§B§7§8§B§Ch§x§C§1§7§7§B§Aa§x§C§7§7§6§B§8o§x§C§D§7§4§B§7t§x§D§3§7§3§B§5i§x§D§A§7§2§B§3c§x§E§0§7§1§B§1J§x§E§6§6§F§A§Fa§x§E§C§6§E§A§Dn \n§f");
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
