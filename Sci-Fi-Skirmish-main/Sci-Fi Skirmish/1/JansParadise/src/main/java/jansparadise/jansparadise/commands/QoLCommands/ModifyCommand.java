package jansparadise.jansparadise.commands.QoLCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ModifyCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (commandSender instanceof Player p) {
            switch (args[0].toLowerCase()) {
                case "name":
                    if(!(p.getItemInHand() == null)){
                        ItemMeta RenameMeta = p.getItemInHand().getItemMeta();
                        for(int i = 1; i <= args.length; i++){
                            if(i == 2){
                                RenameMeta.setDisplayName(args[i - 1].replace("&", "§"));
                            }else{
                                RenameMeta.setDisplayName(RenameMeta.getDisplayName() + " " + args[i - 1].replace("&", "§"));
                            }

                        }
                        p.getItemInHand().setItemMeta(RenameMeta);
                        p.sendActionBar("§aErfolgreich dein Item umbenannt!");
                    }else{
                        p.sendMessage("§cDu musst ein Item in der halten, welches du umbenennen möchtest!");
                    }
                    break;
                case "lore":
                    if(p.getItemInHand().equals(null)){
                        p.sendMessage("§cDu musst ein Item in der Hand halten");
                    }else{
                        int length = args.length;
                        ArrayList lore = new ArrayList();
                        for(int i = 1; i < length; i++) {
                            lore.add(args[i].replace("&", "§").replace("_" , " "));
                        }
                        ItemMeta LoreMeta = p.getItemInHand().getItemMeta();
                        LoreMeta.setLore(lore);
                        p.getItemInHand().setItemMeta(LoreMeta);
                        p.sendActionBar("§aErfolgreich die Lore hinzugefügt!");

                    }
                    break;

                case "glow":

                    if(p.getItemInHand() == null){
                        p.sendMessage("§cDu musst ein Item in der Hand halten");
                        return true;
                    }
                        ItemStack item = p.getItemInHand();
                        ItemMeta itemMeta = item.getItemMeta();
                        itemMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                        itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        item.setItemMeta(itemMeta);

                    break;
                default: p.sendMessage("§cBitte benutze: \n§e/modify name <name> \n§e/modify lore <lore> \n§e/modify type <type>");
            }

        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1){
            ArrayList sc = new ArrayList();
            sc.add("name");
            sc.add("lore");
            sc.add("glow");
            return sc;
        }

        return Collections.singletonList("");
    }
}
