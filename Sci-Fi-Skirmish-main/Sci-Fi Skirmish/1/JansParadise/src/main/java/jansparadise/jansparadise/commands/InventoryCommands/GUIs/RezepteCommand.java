package jansparadise.jansparadise.commands.InventoryCommands.GUIs;

import jansparadise.jansparadise.sonstiges.InventoryBuilder.SpecialItemInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class RezepteCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            p.openInventory(SpecialItemInventory.inventory(p, "§x§F§F§5§9§F§4R§x§F§4§5§8§F§6e§x§E§9§5§6§F§8z§x§D§E§5§5§F§Ae§x§D§3§5§4§F§Bp§x§C§8§5§2§F§Dt§x§B§D§5§1§F§Fe"));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
