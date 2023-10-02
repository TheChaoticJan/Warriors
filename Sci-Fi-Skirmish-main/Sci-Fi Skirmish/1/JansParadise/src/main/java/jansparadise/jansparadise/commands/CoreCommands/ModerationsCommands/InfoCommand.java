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

public class InfoCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player p){

            String playername = args[0];
            Player r = Bukkit.getServer().getPlayerExact(playername);
                if(r == null){
                    p.sendMessage("§cDer Spieler §7`" + playername + "` §cist nicht online!");
            }else{
                    if(r.isOp()){
                        p.sendMessage("\n§f" +
                                "§7Informationen von §d" + playername + "§7: \n§f" +
                                "\n§7UUID: §b" + r.getUniqueId() +
                                "\n§7Operator: §a✔" + "\n§7Aktueller Ping: §e" +r.getPing() + "\n§7IP: §e" + p.getAddress() + "\n§f");
                    }else {
                        p.sendMessage("\n§f" +
                                "§7Informationen von §d" + playername + "§7: \n§f"  +
                                "\n§7UUID: §b" + r.getUniqueId() +
                                "\n§7Operator: §c❌" + "\n§7Aktueller Ping: §e" + r.getPing() + "\n§7IP: §e" + p.getAddress() + "\n§f");
                    }
                }



        }



        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            return null;
        }
        return Collections.singletonList("");
    }
}
