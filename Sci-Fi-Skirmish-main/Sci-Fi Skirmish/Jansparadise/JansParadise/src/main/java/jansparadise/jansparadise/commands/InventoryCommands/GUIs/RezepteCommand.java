package jansparadise.jansparadise.commands.InventoryCommands.GUIs;

import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.*;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivPicke;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Füllerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiSilencer;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiWand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class RezepteCommand implements CommandExecutor, TabCompleter {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            Inventory rezepte = Bukkit.createInventory(p,54 , "§x§F§F§5§9§F§4R§x§F§4§5§8§F§6e§x§E§9§5§6§F§8z§x§D§E§5§5§F§Ae§x§D§3§5§4§F§Bp§x§C§8§5§2§F§Dt§x§B§D§5§1§F§Fe");

            for(int i = 0; i <= 9; i++){
                rezepte.setItem(i, Füllerglas.Glas());
            }
            rezepte.setItem(17, Füllerglas.Glas());
            rezepte.setItem(18, Füllerglas.Glas());
            rezepte.setItem(26, Füllerglas.Glas());
            rezepte.setItem(27, Füllerglas.Glas());
            rezepte.setItem(35, Füllerglas.Glas());
            rezepte.setItem(36, Füllerglas.Glas());
            for(int i2 = 44; i2 <= 53; i2++){
                rezepte.setItem(i2, Füllerglas.Glas());
            }

            //Sci-Fi
            ItemStack SciGlass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
            ItemMeta SciGlassMeta = SciGlass.getItemMeta();
            SciGlassMeta.setDisplayName("§eSci-Fi");
            SciGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            SciGlass.setItemMeta(SciGlassMeta);
            rezepte.setItem(10, SciGlass);
            rezepte.setItem(11, SciFiFragment.SciFiFragment());
            rezepte.setItem(12, SciFiBarren.SciFiBarren());
            rezepte.setItem(13, SciFiSilencer.SciFiSchwert());
            rezepte.setItem(14, SciFiAxt.SciFiSchwert());
            rezepte.setItem(15, SciFiBogen.SciFiSchwert());
            rezepte.setItem(16, SciFiWand.Wand());

            //Erfahren
            ItemStack EGlass = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
            ItemMeta EMeta = EGlass.getItemMeta();
            EMeta.setDisplayName("§eErfahren");
            EMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            EGlass.setItemMeta(EMeta);
            rezepte.setItem(19, EGlass);
            rezepte.setItem(20, Erfahrenfragment.SuperGold());
            rezepte.setItem(21, Erfahrenbarren.ErfahrenBarren());
            rezepte.setItem(22, ErfahrenSchwert.ErfahrenKatana());
            rezepte.setItem(23, ErfahrenAxt.ErfahrenBeil());
            rezepte.setItem(24, ErfahrenBogen.ErfahrenBow());

            //Explosiv
            ItemStack ExGlass = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            ItemMeta ExMeta = ExGlass.getItemMeta();
            ExMeta.setDisplayName("§eExplosiv");
            ExMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            ExGlass.setItemMeta(ExMeta);
            rezepte.setItem(28, ExGlass);
            rezepte.setItem(29, ExplosivPowder.Powder());
            rezepte.setItem(30, ExplosivKelp.DriedKelp());
            rezepte.setItem(31, ExplosivPicke.ErfahrenBow());
            rezepte.setItem(32, ExplosivAngel.ExplosivAngel());

            //Klebrig
            ItemStack KGlass = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
            ItemMeta KMeta = KGlass.getItemMeta();
            KMeta.setDisplayName("§eKlebrig");
            KMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
            KGlass.setItemMeta(KMeta);
            rezepte.setItem(37, KGlass);
            rezepte.setItem(38, KlebrigSlime.Slime());
            rezepte.setItem(39, KlebrigSuperSlime.Emerald());
            rezepte.setItem(40, KlebrigSchwert.KlebrigBogen());
            rezepte.setItem(41, KlebrigAngel.KlebrigAngel());
            rezepte.setItem(42, KlebrigBogen.KlebrigBogen());

            p.openInventory(rezepte);

        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return Collections.singletonList("");
    }
}
