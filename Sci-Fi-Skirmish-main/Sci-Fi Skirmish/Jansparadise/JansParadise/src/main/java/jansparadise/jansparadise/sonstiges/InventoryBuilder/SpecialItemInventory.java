package jansparadise.jansparadise.sonstiges.InventoryBuilder;

import jansparadise.jansparadise.sonstiges.ItemBuilder.CraftingEssentials.*;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Erfahren.ErfahrenSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Explosiv.ExplosivPicke;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Fuellerglas;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigAngel;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.Klebrig.KlebrigSchwert;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiAxt;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiBogen;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiSilencer;
import jansparadise.jansparadise.sonstiges.ItemBuilder.SciFi.SciFiWand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialItemInventory {

    public static Inventory inventory(Player p){
        Inventory rezepte = Bukkit.createInventory(p, 54 , "§x§0§0§F§F§E§0§l§nS§x§0§8§7§4§F§1§l§np§x§1§6§0§1§F§2§l§ne§x§4§9§0§6§A§1§l§nc§x§7§9§0§C§7§7§l§ni§x§A§7§1§5§9§B§l§na§x§B§E§1§6§8§1§l§nl§x§B§E§0§F§2§A§l§ni§x§D§6§5§4§0§8§l§nt§x§F§9§B§D§0§1§l§ne§x§9§4§B§D§0§B§l§nm§x§1§4§A§8§1§8§l§ns");

        for(int i = 0; i <= 9; i++){
            rezepte.setItem(i, Fuellerglas.Glas());
        }
        rezepte.setItem(17, Fuellerglas.Glas());
        rezepte.setItem(18, Fuellerglas.Glas());
        rezepte.setItem(26, Fuellerglas.Glas());
        rezepte.setItem(27, Fuellerglas.Glas());
        rezepte.setItem(35, Fuellerglas.Glas());
        rezepte.setItem(36, Fuellerglas.Glas());
        for(int i2 = 44; i2 <= 53; i2++){
            rezepte.setItem(i2, Fuellerglas.Glas());
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

        return rezepte;


    }
}
