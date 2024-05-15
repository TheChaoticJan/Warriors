package plugin.commands.DatabaseUsing;

import plugin.Main;
import plugin.models.PlayerStats;
import plugin.utils.InventoryBuilder.PerkInventories;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.List;

public class PerkCommand implements CommandExecutor, TabCompleter {

    Main plugin;

    public PerkCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){
            try{
                PlayerStats stats = this.plugin.getDatabase().findPlayerStats(p);

                if(stats == null){
                    stats = new PlayerStats(p);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }

                p.openInventory(PerkInventories.overview(p, stats));

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
