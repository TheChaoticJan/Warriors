package plugin.clans.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.clans.Clan;
import plugin.models.PlayerStats;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CreateClanCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(sender instanceof Player player) {

            if ((args.length != 2) | (args[0].length() > 16) | (args[1].length() > 5)) {
                sender.sendMessage("§cUm einen Clan zu erstellen nutze: §7'§e/createclan <Name> <Tag>§7'");
                sender.sendMessage("§cBeachte, dass der Tag maximal 5 Zeichen lang sein darf und");
                sender.sendMessage("§cder Name maximal 16 Zeichen lang sein darf!");
                return true;
            }

            String name = args[0];
            String tag = args[1];

            Clan clan = Main.getInstance().getDatabase().findClanByTag(tag);

            if (clan != null) {
                sender.sendMessage("§cEin Clan mit dem Tag §7'§f" + tag + "§7' §cexistiert bereits!");
                sender.sendMessage("§cBitte wähle einen anderen Tag!");
                return true;
            }

            try
            {
              PlayerStats stats =  Main.getInstance().getDatabase().findPlayerStats(player);

              if(!Objects.equals(stats.getClan(), "")){
                  player.sendMessage("§cDu kannst keinen neuen Clan erstellen, solange du Teil eines Clans bist!");
                  return true;
              }

              stats.setClan(tag);
              stats.setClan_rank("Leader");
              Main.getInstance().getDatabase().updatePlayerStats(stats);
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
            }

            Main.getInstance().getDatabase().safeClan(name, tag, 0);
            sender.sendMessage("§aDu hast erfolgreich den Clan §6" + name + " §8[§e" + tag + "§8] §aerstellt!");

        }
        return true;

    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
