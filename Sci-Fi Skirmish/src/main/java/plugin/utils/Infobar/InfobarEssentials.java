package plugin.utils.Infobar;

import plugin.models.PlayerStats;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class InfobarEssentials {

    public static ItemStack Enderpearl(){
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§5Enderperlen");
        ArrayList<String> pearlLore = new ArrayList<>();
        pearlLore.add("");
        pearlLore.add("§7Dieses Modul zeigt an");
        pearlLore.add("§7wieviele §5Enderperlen §7dein");
        pearlLore.add("§7Gegner im Inventar hat.");
        pearlLore.add("");
        pearlMeta.setLore(pearlLore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack XP(){
        ItemStack pearl = new ItemStack(Material.EXPERIENCE_BOTTLE);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§aXP-Flaschen");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviele §aXP-Flaschen §7dein");
        pearllore.add("§7Gegner im Inventar hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack tnt(){
        ItemStack pearl = new ItemStack(Material.TNT);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§cTNT");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviel §cTNT §7dein");
        pearllore.add("§7Gegner im Inventar hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack Webs(){
        ItemStack pearl = new ItemStack(Material.COBWEB);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§fSpinnenweben");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviele §fSpinnenweben §7dein");
        pearllore.add("§7Gegner im Inventar hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack Konto(){
        ItemStack pearl = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§6Kontostand");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviele §aXP-Flaschen §7dein");
        pearllore.add("§7Gegner auf dem §6Konto §7hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack Dura(){
        ItemStack pearl = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§7Haltbarkeit - §4Rüstung");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviel §4Haltbarkeit §7das");
        pearllore.add("§7lowste Piece deines Gegners hat.");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ItemStack MainHand(){
        ItemStack pearl = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§7Haltbarkeit - §bMainhand");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviel §bHaltbarkeit §7das Item");
        pearllore.add("§7in der Hand deines Gegners hat.");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ArrayList<ItemStack> neededItemstack(PlayerStats stats){
        ItemStack stack = null;
        ArrayList<ItemStack> stacks = new ArrayList<>();
        for(int i = 1; i <= 3; i++) {
            int infobar;
            if(i == 1) {
                infobar = stats.getInfobar1();
            }else if(i == 2){
                infobar = stats.getInfobar2();
            }else{
                infobar = stats.getInfobar3();
            }

            if (infobar == 1) {
                stack = InfobarEssentials.Dura();
            } else if (infobar == 2) {
                stack = InfobarEssentials.XP();
            } else if (infobar == 3) {
                stack = InfobarEssentials.Enderpearl();
            } else if (infobar == 4) {
                stack = InfobarEssentials.Konto();
            } else if (infobar == 5) {
                stack = InfobarEssentials.tnt();
            } else if (infobar == 6) {
                stack = InfobarEssentials.Webs();
            } else if (infobar == 7) {
                stack = InfobarEssentials.MainHand();
            }

            stacks.add(stack);
        }
        return stacks;
    }




}
