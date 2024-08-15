package plugin.safe;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.Main;
import plugin.Utils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class SafeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player) {

            if (strings.length == 0 || !player.isOp()) {
                Inventory inventory = Bukkit.createInventory(player, 54, MiniMessage.miniMessage().deserialize("<b><red><u>TRESOR"));
                try {
                    for (int i = 0; i < 54; i++) {
                        ItemStack stack = Utils.itemStackFromBase64(player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Slot" + i), PersistentDataType.STRING));
                        if (stack == null) {
                            stack = new ItemStack(Material.AIR);
                        }
                        inventory.setItem(i, stack);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                player.openInventory(inventory);
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        return Collections.singletonList("");
    }
}
