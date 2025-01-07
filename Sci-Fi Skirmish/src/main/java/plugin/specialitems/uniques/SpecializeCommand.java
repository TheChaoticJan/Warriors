package plugin.specialitems.uniques;

import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class SpecializeCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player player){

            ItemStack stack = player.getItemInHand();

            //if(!stack.hasItemMeta()){return true;}

            PersistentDataContainer container = stack.getItemMeta().getPersistentDataContainer();

            Boolean bool = false;
            NamespacedKey trueKey = null;
            for(NamespacedKey key : Unique.keyList){
                if(container.has(key)){
                    bool = true;
                     trueKey = key;
                    break;
                }
            }

            if(bool)
            {

                PersistentDataContainer playerContainer = player.getPersistentDataContainer();
                for(NamespacedKey key : Unique.keyList){
                    if(playerContainer.has(key)){
                        playerContainer.remove(key);
                    }
                }
                playerContainer.set(trueKey, PersistentDataType.BYTE, (byte) 0);

                player.sendMessage("§aDu hast dich erfolgreich auf das Item in deiner Hand spezialisiert!");

            } else {
                player.sendMessage("§cDas Item welches du in der Hand hältst ist nicht einzigartig, weshalb du es nicht erlernen kannst!");
                return true;
            }

        }


        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
