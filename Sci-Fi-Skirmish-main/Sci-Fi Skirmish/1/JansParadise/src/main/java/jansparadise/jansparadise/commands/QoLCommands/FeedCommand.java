package jansparadise.jansparadise.commands.QoLCommands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FeedCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(sender instanceof Player p)){
            sender.sendMessage("§cDu musst ein Spieler sein, um §7´/feed´§c ausführen zu können!");
            return true;
        }
        else{
            if(p.getFoodLevel() >= 20) {
             if(p.getSaturation() >= 20){
                 p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                 p.sendActionBar("§cDu hast bereits vollen Hunger!");
                 return true;
             }
             else{
                 p.setFoodLevel(20);
                 p.setSaturation(20);
                 p.sendActionBar("§aErfolgreich deinen Hunger aufgefüllt!");
                 return true;
             }
          }
          else{
              p.setFoodLevel(20);
              p.setSaturation(20);
              p.sendActionBar("§aErfolgreich deinen Hunger aufgefüllt!");
              return true;
          }
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
