package jansparadise.jansparadise.Infobar;

import jansparadise.jansparadise.models.PlayerStats;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Infobar {

    public static ItemStack Enderpearl(){
        ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
        ItemMeta pearlMeta = pearl.getItemMeta();
        pearlMeta.setDisplayName("§5Enderperlen");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviele §5Enderperlen §7dein");
        pearllore.add("§7Gegner im Inventar hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
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
        pearlMeta.setDisplayName("§4Haltbarkeit");
        ArrayList<String> pearllore = new ArrayList<>();
        pearllore.add("");
        pearllore.add("§7Dieses Modul zeigt an");
        pearllore.add("§7wieviel §4Haltbarkeit §7das");
        pearllore.add("§7lowste Piece deines Gegners hat.");
        pearllore.add("");
        pearlMeta.setLore(pearllore);
        pearl.setItemMeta(pearlMeta);
        return pearl;
    }

    public static ArrayList<ItemStack> neededItemstack(PlayerStats stats){
        ItemStack stack = null;
        if(stats.getInfobar1() == 1){
            stack = Infobar.Dura();
        }else if(stats.getInfobar1() == 2){
            stack = Infobar.XP();
        }else if(stats.getInfobar1() == 3){
            stack = Infobar.Enderpearl();
        }else if(stats.getInfobar1() == 4){
            stack = Infobar.Konto();
        }else if(stats.getInfobar1() == 5){
            stack = Infobar.tnt();
        }else if(stats.getInfobar1() == 6){
            stack = Infobar.Webs();
        }

        ItemStack stack1 = null;
        if(stats.getInfobar2() == 1){
            stack1 = Infobar.Dura();
        }else if(stats.getInfobar2() == 2){
            stack1 = Infobar.XP();
        }else if(stats.getInfobar2() == 3){
            stack1 = Infobar.Enderpearl();
        }else if(stats.getInfobar2() == 4){
            stack1 = Infobar.Konto();
        }else if(stats.getInfobar2() == 5){
            stack1 = Infobar.tnt();
        }else if(stats.getInfobar2() == 6){
            stack1 = Infobar.Webs();
        }

        ItemStack stack2 = null;
        if(stats.getInfobar3() == 1){
            stack2 = Infobar.Dura();
        }else if(stats.getInfobar3() == 2){
            stack2 = Infobar.XP();
        }else if(stats.getInfobar3() == 3){
            stack2 = Infobar.Enderpearl();
        }else if(stats.getInfobar3() == 4){
            stack2 = Infobar.Konto();
        }else if(stats.getInfobar3() == 5){
            stack2 = Infobar.tnt();
        }else if(stats.getInfobar3() == 6){
            stack2 = Infobar.Webs();
        }

        ArrayList<ItemStack> stacks = new ArrayList<>();
        stacks.add(stack);
        stacks.add(stack1);
        stacks.add(stack2);

        return stacks;
    }




}
