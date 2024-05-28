package plugin.utils.Scores;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.data.type.Switch;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.TextHandler;

import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.sql.SQLException;
import java.util.Iterator;

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

            for (Player player : Bukkit.getOnlinePlayers()) {
                setPlayerTeams(player);
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
                case "Spieler" -> teamName = "fSpieler";
                default -> teamName = "zDefault";
            }

            Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
            Team team = scoreboard.getTeam(teamName);

            if (team == null) {
                team = scoreboard.registerNewTeam(teamName);
            }

            // Set the team prefix
            team.prefix(MiniMessage.miniMessage().deserialize(prefix));
            // Add player to the team
            team.addEntry(player.getName());

            // Update player's display name and tab list name
            player.displayName(MiniMessage.miniMessage().deserialize(prefix + player.getName()));
            player.playerListName(MiniMessage.miniMessage().deserialize(prefix + player.getName()));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
