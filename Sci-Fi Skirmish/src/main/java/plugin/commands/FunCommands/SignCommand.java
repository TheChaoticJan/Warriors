package plugin.commands.FunCommands;


import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.text.SimpleDateFormat;
import java.util.*;


public class SignCommand implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player p)){
            commandSender.sendMessage("§cDu musst ein Spieler sein um §7´/sign´§c ausführen zu können!");
            return true;
        }
        else{
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String date = simpleDateFormat.format(new Date());

            if(p.getItemInHand().getAmount() == 0){
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                p.sendMessage("§cDu hast kein Item in der Hand!");
                return true;
            }if(p.getItemInHand().getItemMeta().getLore() == null){
                p.getItemInHand().getItemMeta();
                ArrayList<String> lore = new ArrayList<>();
                lore.add("");
                lore.add("§7» Signiert von §d" + p.getName());
                lore.add("   §7am " + date);
                (p.getItemInHand()).setLore(lore);
                p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 5, 1);
                p.sendActionBar("§aDu hast dein Item erfolgreich signiert!");

            }else{
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                p.sendMessage("§cItems mit Beschreibung können nicht signiert werden!");
                return true;
            }
           return true;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
