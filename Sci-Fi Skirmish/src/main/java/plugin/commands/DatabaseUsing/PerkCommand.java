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
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                if(stats == null){
                    stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1,2, 3);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }

                p.openInventory(PerkInventories.Overview(p, stats));

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
