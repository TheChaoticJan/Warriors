package plugin.commands.QoLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import plugin.LootSystem.CrateEntities.Crates;

public class SpawnArmorstandCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player p) {
            Crates.spawnArmorstand(p, p.getLocation().getBlockX(), (float) (p.getLocation().getBlockY() - 0.7), p.getLocation().getBlockZ());
        }
        return true;
    }
}
