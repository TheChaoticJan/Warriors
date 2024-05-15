package plugin.infobar;

import plugin.Main;
import plugin.models.PlayerStats;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public class InfobarCommand implements CommandExecutor, TabCompleter {

    public InfobarCommand(Main plugin) {
        this.plugin = plugin;
    }

    Main plugin;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player){

            try{

                PlayerStats stats = this.plugin.getDatabase().findPlayerStats(player);

                if(stats == null){
                    stats = new PlayerStats(player);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }

                if(!stats.getPerks()[4]){
                    player.sendMessage("\n§cDu musst erst das Perk §7'§5Spionagemeister§7' §ckaufen, um die Infobar bearbeiten zu können!\n§f");
                    return true;
                }else{
                   player.openInventory(InfobarInventories.introduction(player, stats));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
