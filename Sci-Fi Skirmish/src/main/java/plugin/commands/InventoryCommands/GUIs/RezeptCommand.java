package plugin.commands.InventoryCommands.GUIs;

import plugin.utils.InventoryBuilder.Rezepte.ErfahrenRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.ExplosivRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.KlebrigRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.SciFiRezeptInventare;
import plugin.utils.ItemBuilder.*;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RezeptCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player p){
            if(args.length == 0){
                p.sendMessage("§cBitte benutze: §e/rezept <Rezept>");
                return true;
            }
            switch (args[0]){
                case "Sci-Fi_Barren":
                    p.openInventory(SciFiRezeptInventare.Barren(p, null, SpecialResources.SciFiBarren()));
                    break;
                case "Sci-Fi_Fragment":
                    p.openInventory(SciFiRezeptInventare.Fragment(p, null, SpecialResources.SciFiFragment()));
                    break;
                case "Sci-Fi_Schwert":
                    p.openInventory(SciFiRezeptInventare.Schwert(p, null, SciFiItems.Schwert()));
                    break;
                case "Sci-Fi_Bogen":
                    p.openInventory(SciFiRezeptInventare.Bogen(p, null, SciFiItems.Bogen()));
                    break;
                case "Sci-Fi_Axt":
                    p.openInventory(SciFiRezeptInventare.Axt(p, null, SciFiItems.Axt()));
                    break;
                case "Sci-Fi_Zauberstab":
                    p.openInventory(SciFiRezeptInventare.Zauberstab(p, null, SciFiItems.Zahlungsvorschuss()));
                    break;
                case "Erfahrenfragment":
                    p.openInventory(ErfahrenRezeptInventare.Fragment(p, null, SpecialResources.ErfahrenFragment()));
                    break;
                case "Erfahrenbarren":
                    p.openInventory(ErfahrenRezeptInventare.Barren(p, null, SpecialResources.ErfahrenBarren()));
                    break;
                case "Erfahrenschwert":
                    p.openInventory(ErfahrenRezeptInventare.Schwert(p, null, ErfahrenItems.Schwert()));
                    break;
                case "Erfahrenaxt":
                    p.openInventory(ErfahrenRezeptInventare.Axt(p, null, ErfahrenItems.Axt()));
                    break;
                case "Erfahrenbogen":
                    p.openInventory(ErfahrenRezeptInventare.Bogen(p, null, ErfahrenItems.Bogen()));
                    break;
                case "Explosivpuder":
                    p.openInventory(ExplosivRezeptInventare.Fragment(p, null, SpecialResources.ExplosivPuder()));
                    break;
                case "Explosivbarren":
                    p.openInventory(ExplosivRezeptInventare.Barren(p, null, SpecialResources.ExplosivBarren()));
                    break;
                case "Explosivbohrer":
                    p.openInventory(ExplosivRezeptInventare.Picke(p, null, ExplosivItems.Spitzhacke()));
                    break;
                case "Explosivangel":
                    p.openInventory(ExplosivRezeptInventare.Angel(p, null, ExplosivItems.Angel()));
                    break;
                case "Klebriger_Schleim":
                    p.openInventory(KlebrigRezeptInventare.Fragment(p, null, SpecialResources.KlebrigFragment()));
                    break;
                case "Klebriger_Kristall":
                    p.openInventory(KlebrigRezeptInventare.Barren(p, null, SpecialResources.KlebrigBarren()));
                    break;
                case "Klebrig_Schwert":
                    p.openInventory(KlebrigRezeptInventare.Schwert(p, null, KlebrigItems.Schwert()));
                    break;
                case "Klebrig_Angel":
                    p.openInventory(KlebrigRezeptInventare.Angel(p, null, KlebrigItems.Angel()));
                    break;
                case "Klebrig_Bogen":
                    p.openInventory(KlebrigRezeptInventare.Bogen(p, null, KlebrigItems.Bogen()));
                    break;
                case "Erfahren_Zauberstab":
                    p.openInventory(ErfahrenRezeptInventare.Zauberstab(p, null, ErfahrenItems.Zauberstab()));
                    break;
                default:
                    p.sendMessage("§cDies ist kein Servereigenes Specialitem!");
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
            }
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length == 1) {
            ArrayList<String> subcommands = new ArrayList<>();

            subcommands.add("Sci-Fi_Barren");
            subcommands.add("Sci-Fi_Fragment");
            subcommands.add("Sci-Fi_Schwert");
            subcommands.add("Erfahrenfragment");
            subcommands.add("Sci-Fi_Bogen");
            subcommands.add("Sci-Fi_Axt");
            subcommands.add("Sci-Fi_Zauberstab");
            subcommands.add("Erfahrenbarren");
            subcommands.add("Erfahrenaxt");
            subcommands.add("Erfahrenbogen");
            subcommands.add("Explosivpuder");
            subcommands.add("Explosivbarren");
            subcommands.add("Explosivbohrer");
            subcommands.add("Explosivangel");
            subcommands.add("Klebriger_Schleim");
            subcommands.add("Klebriger_Kristall");
            subcommands.add("Klebrig_Schwert");
            subcommands.add("Klebrig_Angel");
            subcommands.add("Klebrig_Bogen");
            subcommands.add("Erfahren_Zauberstab");

            return subcommands;
        }
        if(strings.length >= 2) {
          return Collections.singletonList("");
        }
        return null;
    }
}
