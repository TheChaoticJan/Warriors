package plugin.commands.QoLCommands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FixCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player p)){
            commandSender.sendMessage("§cDu musst ein Spieler sein um §7´/fix´ §cauführen zu können!");
        }
        else {
            if (p.getItemInHand().getAmount() == 0){
                p.sendMessage("§cDu musst ein Item in der Hand halten, um es reparieren zu können!");
            }
            else{
                if(!(p.getItemInHand().getDurability() == p.getItemInHand().getMaxItemUseDuration())){
                    p.getItemInHand().setDurability((short) p.getItemInHand().getMaxItemUseDuration());
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 5, 1);
                    p.sendActionBar("§aErfolgreich dein Item repariert");
                }
                else{
                    p.sendMessage("§cDas Item, was du reparieren willst, hat bereits volle Haltbarkeit!");
                }
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
