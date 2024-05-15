package plugin.commands.ModerationsCommands;

import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.models.PlayerStats;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class VanishCommand implements CommandExecutor, TabCompleter {

    Main plugin;
    public VanishCommand(Main plugin) {
        this.plugin = plugin;
    }

        @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

                if(sender instanceof Player p){
            if(plugin.VanishList.contains(p.getUniqueId())){
                for(Player people : Bukkit.getOnlinePlayers()){
                    people.showPlayer(plugin, p);
                }
                p.setInvulnerable(false);
                p.setAllowFlight(false);
                plugin.VanishList.remove(p.getUniqueId());
                p.sendActionBar("§7Vanish §8» §cDeaktiviert");
                p.setPlayerListName(p.getDisplayName());
                p.setCustomNameVisible(true);
            }else{
                for(Player people : Bukkit.getOnlinePlayers()){

                    try {
                        PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(people);

                        if(!Objects.equals(stats.getRank(), "Moderator") && !Objects.equals(stats.getRank(), "Admin")){
                            people.hidePlayer(plugin, p);
                        }
                    }catch (Exception exception){
                        exception.printStackTrace();
                    }


                }
                p.setInvulnerable(true);
                p.setAllowFlight(true);
                plugin.VanishList.add(p.getUniqueId());
                p.sendActionBar("§7Vanish §8» §aAktiviert");
                p.setCustomNameVisible(true);
            }

        }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
