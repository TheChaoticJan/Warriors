package plugin.cratesystem;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import plugin.cratesystem.models.Crate;

public class SpawnCrateCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p) {
            new Crate(p, p.getLocation().getBlockX(), (float) (p.getLocation().getBlockY() - 0.7), p.getLocation().getBlockZ());
            p.sendActionBar("§aErfolgreich eine Crate gespawned!");
        }
        return true;
    }
}
