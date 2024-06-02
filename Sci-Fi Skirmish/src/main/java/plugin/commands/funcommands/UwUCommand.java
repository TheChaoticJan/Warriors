package plugin.commands.funcommands;


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



public class UwUCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {


        if(!(sender instanceof Player)){
            sender.sendMessage("§cDu musst ein Spieler sein um §7´/uwu´ §causführen zu können!");
        }
        else if(args.length != 1){
            sender.sendMessage("§cBitte benutze: §7`§e/uwu <Spielername>§7`");
        }
        else{
            Player p = (Player) sender;
            String playername = args[0];

            Player r = Bukkit.getServer().getPlayerExact(playername);
            if(r != null) {
                if( r == p){
                    p.sendMessage("§cDas ergibt keinen Sinn!");
                    return true;
                }
                r.sendMessage(

                        "\n" +
                                " \n" +
                                "§7=============================================\n" +
                                " \n" +
                                "      §d" + p.getDisplayName() + " §fwünscht dir jetzt ein herzliches:\n" +
                                " \n" +
                                "                         §b§k§lsd §d§lUwU §b§k§lsd\n" +
                                " \n" +
                                "§7=============================================\n" +
                                " \n" +
                                " \n"

                     );
                p.sendActionBar("§fDu hast " + r.getName() + " §ferfolgreich ein §b§kaa §d§lUwU §b§kaa §fgewünscht");

            }else {
                p.sendMessage("§cDer Spieler §7`" + playername + "` §cist nicht online!");
                return true;
            }
        }

        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            return null;
        }
        return Collections.singletonList("");
    }
}
