package plugin.commands.QoLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

public class NightVisionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(!(commandSender instanceof Player player)){
            commandSender.sendMessage("§cDu musst ein Spieler sein, um diesen Befehl ausführen zu können!");
            return true;
        }else{
            if(player.hasPotionEffect(PotionEffectType.NIGHT_VISION)){
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendActionBar("Nachtsicht §8▸ §cDeaktiviert");
            }else{
                player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, PotionEffect.INFINITE_DURATION, 0, true, false));
                player.sendActionBar("Nachtsicht §8▸ §aAktiviert");
            }
        }

        return true;
    }
}
