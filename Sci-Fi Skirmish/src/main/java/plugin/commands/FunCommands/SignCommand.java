package plugin.commands.FunCommands;


import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.models.PlayerStats;
import plugin.models.TextHandler;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;


public class SignCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(!(commandSender instanceof Player p)){
            commandSender.sendMessage("§cDu musst ein Spieler sein um §7´/sign´§c ausführen zu können!");
        }
        else{
            try {
                PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(p);

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
                String date = simpleDateFormat.format(new Date());

                if (p.getItemInHand().getAmount() == 0) {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                    p.sendMessage("§cDu hast kein Item in der Hand!");
                    return true;
                }
                if (p.getItemInHand().getItemMeta().getLore() == null) {
                    p.getItemInHand().getItemMeta();
                    ArrayList<Component> lore = new ArrayList<>();
                    lore.add(Component.text(""));
                    lore.add(MiniMessage.miniMessage().deserialize( "<i:false><white>Signiert von " + TextHandler.setRankGradient(stats.getRank()) + p.getName() + "</gradient>"));
                    lore.add(Component.text("§7("+ date + ")"));
                    (p.getItemInHand()).lore(lore);
                    p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_USE, 5, 1);
                    p.sendActionBar("§aDu hast das Item erfolgreich signiert!");

                } else {
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 5, 1);
                    p.sendMessage("§cItems mit Beschreibung können nicht signiert werden!");
                    return true;
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
