package jansparadise.jansparadise.commands.CoreCommands;

import jansparadise.jansparadise.JansParadise;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class TradeCommand implements CommandExecutor {

    private JansParadise plugin;

    public TradeCommand(JansParadise plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if(sender instanceof Player){

            Player p = (Player) sender;

            if(args.length != 1){
                p.sendMessage("§cBitte benutze: §e/trade <Spieler>");
                return true;
            }



            String playername = args[0];
            Player r = Bukkit.getServer().getPlayerExact(playername);



            if(r == null){

                p.sendMessage("§cDer Spieler §7" + playername + " §cist nicht online!");
                return true;

            }else if(r == p){
                p.sendMessage("§cDas ergibt keinen Sinn, oder?");
                return true;
            }
            else{

                TextComponent component = Component.text( "§b" + p.getName() + " §7möchte mit dir handeln! §8§l<§e§lAnnehmen§8§l>").hoverEvent(Component.text("§7<Klick>")).clickEvent(ClickEvent.clickEvent(ClickEvent.Action.RUN_COMMAND, "/tradeinventar"));
                 r.sendMessage(component);

            }




        }













        return true;
    }
}
