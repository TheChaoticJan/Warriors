package plugin.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import plugin.Main;
import plugin.clans.Clan;
import plugin.models.PlayerStats;

import java.sql.SQLException;

public class DeleteClanCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player)
        {
            try
            {
              PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

                Clan clan = Main.getInstance().getDatabase().findClanByTag(stats.getClan());

                if(clan == null)
                {
                    player.sendMessage("§cDu bist in keinem Clan, der gelöscht werden könnte!");
                    return true;
                }

                Clan.delete(player);

            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }

        return true;
    }
}
