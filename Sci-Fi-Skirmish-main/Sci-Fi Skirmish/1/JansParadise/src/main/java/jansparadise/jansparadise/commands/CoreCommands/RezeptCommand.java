package jansparadise.jansparadise.commands.CoreCommands;

import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.ErfahrenRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.ExplosivRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.KlebrigRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.SciFiRezeptInventare;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivPicke;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiSilencer;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiWand;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SpecialResources;
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
                    p.openInventory(SciFiRezeptInventare.Schwert(p, null, SciFiSilencer.SciFiSchwert()));
                    break;
                case "Sci-Fi_Bogen":
                    p.openInventory(SciFiRezeptInventare.Bogen(p, null, SciFiBogen.SciFiSchwert()));
                    break;
                case "Sci-Fi_Axt":
                    p.openInventory(SciFiRezeptInventare.Axt(p, null, SciFiAxt.SciFiSchwert()));
                    break;
                case "Sci-Fi_Wand":
                    p.openInventory(SciFiRezeptInventare.Zauberstab(p, null, SciFiWand.Wand()));
                    break;
                case "Erfahrenfragment":
                    p.openInventory(ErfahrenRezeptInventare.Fragment(p, null, SpecialResources.ErfahrenFragment()));
                    break;
                case "Erfahrenbarren":
                    p.openInventory(ErfahrenRezeptInventare.Barren(p, null, SpecialResources.ErfahrenBarren()));
                    break;
                case "Erfahrenschwert":
                    p.openInventory(ErfahrenRezeptInventare.Schwert(p, null, ErfahrenSchwert.ErfahrenKatana()));
                    break;
                case "Erfahrenaxt":
                    p.openInventory(ErfahrenRezeptInventare.Axt(p, null, ErfahrenAxt.ErfahrenBeil()));
                    break;
                case "Erfahrenbogen":
                    p.openInventory(ErfahrenRezeptInventare.Bogen(p, null, ErfahrenBogen.ErfahrenBow()));
                    break;
                case "Explosivpuder":
                    p.openInventory(ExplosivRezeptInventare.Fragment(p, null, SpecialResources.ExplosivPuder()));
                    break;
                case "Explosivbarren":
                    p.openInventory(ExplosivRezeptInventare.Barren(p, null, SpecialResources.ExplosivBarren()));
                    break;
                case "Explosivbohrer":
                    p.openInventory(ExplosivRezeptInventare.Picke(p, null, ExplosivPicke.ErfahrenBow()));
                    break;
                case "Explosivangel":
                    p.openInventory(ExplosivRezeptInventare.Angel(p, null, ExplosivAngel.ExplosivAngel()));
                    break;
                case "Klebriger_Schleim":
                    p.openInventory(KlebrigRezeptInventare.Fragment(p, null, SpecialResources.KlebrigFragment()));
                    break;
                case "Klebriger_Kristall":
                    p.openInventory(KlebrigRezeptInventare.Barren(p, null, SpecialResources.KlebrigBarren()));
                    break;
                case "Klebrig_Schwert":
                    p.openInventory(KlebrigRezeptInventare.Schwert(p, null, KlebrigSchwert.KlebrigBogen()));
                    break;
                case "Klebrig_Angel":
                    p.openInventory(KlebrigRezeptInventare.Angel(p, null, KlebrigAngel.KlebrigAngel()));
                    break;
                case "Klebrig_Bogen":
                    p.openInventory(KlebrigRezeptInventare.Bogen(p, null, KlebrigBogen.KlebrigBogen()));
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
            subcommands.add("Sci-Fi_Wand");
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

            return subcommands;
        }
        if(strings.length >= 2) {
          return Collections.singletonList("");
        }
        return null;
    }
}
