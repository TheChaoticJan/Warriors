package plugin.commands.InventoryCommands.GUIs;

import plugin.utils.InventoryBuilder.SpecialItemInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class SpecialitemCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player p){

            p.openInventory(SpecialItemInventory.inventory(p, "§x§0§0§F§F§E§0§l§nS§x§0§8§7§4§F§1§l§np§x§1§6§0§1§F§2§l§ne§x§4§9§0§6§A§1§l§nc§x§7§9§0§C§7§7§l§ni§x§A§7§1§5§9§B§l§na§x§B§E§1§6§8§1§l§nl§x§B§E§0§F§2§A§l§ni§x§D§6§5§4§0§8§l§nt§x§F§9§B§D§0§1§l§ne§x§9§4§B§D§0§B§l§nm§x§1§4§A§8§1§8§l§ns"));

        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
