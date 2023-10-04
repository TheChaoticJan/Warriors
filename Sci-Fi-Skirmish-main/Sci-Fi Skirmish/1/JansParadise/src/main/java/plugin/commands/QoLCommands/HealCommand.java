package plugin.commands.QoLCommands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player p)) {
            commandSender.sendMessage("§cDu musst ein Spieler sein um §7´/heal´§c ausführen zu können!");
            return true;
        } else {

            if (args.length == 0) {

                if (p.getHealth() >= p.getMaxHealth()) {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                    p.sendActionBar("§cDeine Herzen sind bereits voll!");
                } else {
                    p.setHealth(p.getMaxHealth());
                    p.sendActionBar("§aErfolgreich deine Herzen aufgefüllt!");
                }


            } else if (args.length == 1) {
                String playername = args[0];
                Player r = Bukkit.getServer().getPlayerExact(playername);
                if (r == null) {
                    p.sendMessage("§cDer Spieler +§7´" + args[0] + "§7´ §ckonnte nicht geheilt werden, da er §7offline §cist!");
                } else {
                    if (r.getHealth() >= r.getMaxHealth()) {
                        p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                        p.sendActionBar(args[0] + " §cHerzen sind bereits voll!");
                    } else {
                        r.setHealth(p.getMaxHealth());
                        r.sendActionBar("§aDu wurdest von §7" + p.getName() + " §ageheilt!");
                        p.sendActionBar("§aErfolgreich §7" + args[0] + " §ageheilt");
                    }
                }


            } else if(args.length > 1){
                p.sendMessage("§cBitte benutze: §7`§e/heal§7´ §coder §7§e/heal <Name>§7`");
            }

            return false;
        }
    }
}