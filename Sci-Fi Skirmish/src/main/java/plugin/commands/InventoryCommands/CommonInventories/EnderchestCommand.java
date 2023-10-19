package plugin.commands.InventoryCommands.CommonInventories;

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

public class EnderchestCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(sender instanceof Player p){
            if(args.length == 0) {
                p.openInventory(p.getEnderChest());
            }else if(!p.isOp()){
                p.sendMessage("§cBitte benutze §e/ec");
            }else{
                String playerName = args[0];
                Player r = Bukkit.getPlayerExact(playerName);
                if(r == null){
                    p.sendMessage("§cDer Spieler §7" + playerName + " §cist nicht online!");
                }else{
                    p.openInventory(r.getEnderChest());
                }
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            return null;
        }
        return Collections.singletonList("");
    }
}
