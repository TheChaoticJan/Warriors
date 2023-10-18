package plugin.utils.InventoryBuilder;

import plugin.utils.ItemBuilder.*;
import plugin.utils.ItemBuilder.Inventarteile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpecialItemInventory {

    public static Inventory inventory(Player p, String name){
        Inventory rezepte = Bukkit.createInventory(p,54 , name);

        for(int i = 0; i <= 9; i++){
            rezepte.setItem(i, Inventarteile.Glass());
        }
        rezepte.setItem(17, Inventarteile.Glass());
        rezepte.setItem(18, Inventarteile.Glass());
        rezepte.setItem(26, Inventarteile.Glass());
        rezepte.setItem(27, Inventarteile.Glass());
        rezepte.setItem(35, Inventarteile.Glass());
        rezepte.setItem(36, Inventarteile.Glass());
        for(int i2 = 44; i2 <= 53; i2++){
            rezepte.setItem(i2, Inventarteile.Glass());
        }

        //Sci-Fi
        ItemStack SciGlass = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta SciGlassMeta = SciGlass.getItemMeta();
        SciGlassMeta.setDisplayName("§eSci-Fi");
        SciGlassMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SciGlass.setItemMeta(SciGlassMeta);
        rezepte.setItem(10, SciGlass);
        rezepte.setItem(11, SpecialResources.SciFiFragment());
        rezepte.setItem(12, SpecialResources.SciFiBarren());
        rezepte.setItem(13, SciFiItems.Schwert());
        rezepte.setItem(14, SciFiItems.Axt());
        rezepte.setItem(15, SciFiItems.Bogen());
        rezepte.setItem(16, SciFiItems.Zahlungsvorschuss());

        //Erfahren
        ItemStack EGlass = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta EMeta = EGlass.getItemMeta();
        EMeta.setDisplayName("§eErfahren");
        EMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        EGlass.setItemMeta(EMeta);
        rezepte.setItem(19, EGlass);
        rezepte.setItem(20, SpecialResources.ErfahrenFragment());
        rezepte.setItem(21, SpecialResources.ErfahrenBarren());
        rezepte.setItem(22, ErfahrenItems.Schwert());
        rezepte.setItem(23, ErfahrenItems.Axt());
        rezepte.setItem(24, ErfahrenItems.Bogen());
        rezepte.setItem(25, ErfahrenItems.Zauberstab());

        //Explosiv
        ItemStack ExGlass = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta ExMeta = ExGlass.getItemMeta();
        ExMeta.setDisplayName("§eExplosiv");
        ExMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ExGlass.setItemMeta(ExMeta);
        rezepte.setItem(28, ExGlass);
        rezepte.setItem(29, SpecialResources.ExplosivPuder());
        rezepte.setItem(30, SpecialResources.ExplosivBarren());
        rezepte.setItem(31, ExplosivItems.Spitzhacke());
        rezepte.setItem(32, ExplosivItems.Angel());
        rezepte.setItem(34, ExplosivItems.Zündkerze());

        //Klebrig
        ItemStack KGlass = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta KMeta = KGlass.getItemMeta();
        KMeta.setDisplayName("§eKlebrig");
        KMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        KGlass.setItemMeta(KMeta);
        rezepte.setItem(37, KGlass);
        rezepte.setItem(38, SpecialResources.KlebrigFragment());
        rezepte.setItem(39, SpecialResources.KlebrigBarren());
        rezepte.setItem(40, KlebrigItems.Schwert());
        rezepte.setItem(41, KlebrigItems.Angel());
        rezepte.setItem(42, KlebrigItems.Bogen());
        rezepte.setItem(43, KlebrigItems.Peilsender());

        p.openInventory(rezepte);
        return rezepte;

    }
}
