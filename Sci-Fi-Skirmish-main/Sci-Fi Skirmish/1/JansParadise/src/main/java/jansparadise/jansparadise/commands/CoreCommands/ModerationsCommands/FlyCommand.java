package jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class FlyCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player p)){
            commandSender.sendMessage("§cDu musst ein Spieler sein um §7´/fly´§c ausführen zu können!");
            return true;
        }
        else{

            if(p.getAllowFlight()){
                p.setAllowFlight(false);
                p.sendActionBar("§7Flugmodus §8» §cDeaktiviert");
            }
            else{
                p.setAllowFlight(true);
                p.sendActionBar("§7Flugmodus §8» §aAktiviert");
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
