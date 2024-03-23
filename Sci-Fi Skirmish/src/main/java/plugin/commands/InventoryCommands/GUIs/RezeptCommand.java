package plugin.commands.InventoryCommands.GUIs;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import plugin.utils.InventoryBuilder.Rezepte.ErfahrenRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.ExplosivRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.KlebrigRezeptInventare;
import plugin.utils.InventoryBuilder.Rezepte.SciFiRezeptInventare;
import plugin.utils.ItemBuilder.*;

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
            switch (args[0]) {
                case "Sci-Fi_Barren" ->
                        p.openInventory(SciFiRezeptInventare.Barren(p, null, SpecialResources.SciFiBarren(1)));
                case "Sci-Fi_Fragment" ->
                        p.openInventory(SciFiRezeptInventare.Fragment(p, null, SpecialResources.SciFiFragment(1)));
                case "Sci-Fi_Schwert" ->
                        p.openInventory(SciFiRezeptInventare.Schwert(p, null, SciFiItems.Schwert()));
                case "Sci-Fi_Bogen" ->
                        p.openInventory(SciFiRezeptInventare.Bogen(p, null, SciFiItems.Bogen()));
                case "Sci-Fi_Axt" ->
                        p.openInventory(SciFiRezeptInventare.Axt(p, null, SciFiItems.Axt()));
                case "Sci-Fi_Zauberstab" ->
                        p.openInventory(SciFiRezeptInventare.Zauberstab(p, null, Candles.crateCandle()));
                case "Erfahrenfragment" ->
                        p.openInventory(ErfahrenRezeptInventare.Fragment(p, null, SpecialResources.ErfahrenFragment(1)));
                case "Erfahrenbarren" ->
                        p.openInventory(ErfahrenRezeptInventare.Barren(p, null, SpecialResources.ErfahrenBarren(1)));
                case "Erfahrenschwert" ->
                        p.openInventory(ErfahrenRezeptInventare.Schwert(p, null, ErfahrenItems.sword()));
                case "Erfahrenaxt" ->
                        p.openInventory(ErfahrenRezeptInventare.Axt(p, null, ErfahrenItems.Axt()));
                case "Erfahrenbogen" ->
                        p.openInventory(ErfahrenRezeptInventare.Bogen(p, null, ErfahrenItems.bow()));
                case "Explosivpuder" ->
                        p.openInventory(ExplosivRezeptInventare.Fragment(p, null, SpecialResources.ExplosivPuder(1)));
                case "Explosivbarren" ->
                        p.openInventory(ExplosivRezeptInventare.Barren(p, null, SpecialResources.ExplosivBarren(1)));
                case "Explosivbohrer" ->
                        p.openInventory(ExplosivRezeptInventare.Picke(p, null, Explosiv.Spitzhacke()));
                case "Explosivangel" ->
                        p.openInventory(ExplosivRezeptInventare.Angel(p, null, Explosiv.Angel()));
                case "Klebriger_Schleim" ->
                        p.openInventory(KlebrigRezeptInventare.Fragment(p, null, SpecialResources.KlebrigFragment(1)));
                case "Klebriger_Kristall" ->
                        p.openInventory(KlebrigRezeptInventare.Barren(p, null, SpecialResources.KlebrigBarren(1)));
                case "Klebrig_Schwert" ->
                        p.openInventory(KlebrigRezeptInventare.Schwert(p, null, Klebrig.Schwert()));
                case "Klebrig_Angel" ->
                        p.openInventory(KlebrigRezeptInventare.Angel(p, null, Klebrig.Angel()));
                case "Klebrig_Bogen" ->
                        p.openInventory(KlebrigRezeptInventare.Bogen(p, null, Klebrig.Bogen()));
                case "Erfahren_Zauberstab" ->
                        p.openInventory(ErfahrenRezeptInventare.Zauberstab(p, null, Candles.healCandle()));
                default -> {
                    p.sendMessage("§cDies ist kein Servereigenes Specialitem!");
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 2, 1);
                }
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
