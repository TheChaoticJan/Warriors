package jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class CPSCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("§cDu musst ein Spieler sein, um §7´/cps´§c ausführen zu können!");
        } else if (args.length == 1) {
            Player p = (Player) sender;
            String playername = args[0];

            Player r = Bukkit.getServer().getPlayerExact(playername);
            if(r == null){
                p.sendMessage("§cDer Spieler §7`" + playername + "§7` §cist nicht online!");
            }else{

            }

        } else {
            sender.sendMessage("§cBitte benutze:§7`§e/cps <Spielername>§7`");
        }
        return true;
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
