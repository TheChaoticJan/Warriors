package jansparadise.jansparadise.Infobar;

import jansparadise.jansparadise.models.PlayerStats;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Actionbar {

    public static String Actionbar(Player p, PlayerStats stats, Player d, int module1, int module2, int module3){
        String Actionbar = "";

        //Creating different values to display
        int xp = 0;
        int pearls = 0;
        int webs = 0;
        int tnt = 0;
        for(int m = 0; m <= 35; m++){
            if(p.getInventory().getItem(m) != null){
                if(p.getInventory().getItem(m).getType().equals(Material.EXPERIENCE_BOTTLE)){
                    xp = xp + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.ENDER_PEARL)){
                    pearls = pearls + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.TNT)){
                    tnt = tnt + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.COBWEB)){
                    webs = webs + p.getInventory().getItem(m).getAmount();
                }
            }
        }

            int HDura = 0;
            int BDura = 0;
            int CDura = 0;
            int LDura = 0;
            String Piece = "";
            if(!(p.getInventory().getHelmet() == null)){
                HDura = p.getInventory().getHelmet().getType().getMaxDurability() - p.getInventory().getHelmet().getDurability();
            }

            if(!(p.getInventory().getBoots() == null)){
                BDura = p.getInventory().getBoots().getType().getMaxDurability() - p.getInventory().getBoots().getDurability();
            }

            if(!(p.getInventory().getChestplate() == null)){
                CDura = p.getInventory().getChestplate().getType().getMaxDurability() - p.getInventory().getChestplate().getDurability();
            }

            if(!(p.getInventory().getLeggings() == null)){
                LDura = p.getInventory().getLeggings().getType().getMaxDurability() - p.getInventory().getLeggings().getDurability();
            }

            if(!(p.getInventory().getLeggings() == null) && !(p.getInventory().getBoots() == null)  && !(p.getInventory().getChestplate() == null)  && !(p.getInventory().getHelmet() == null)){
                if(LDura <= HDura && LDura <= CDura && LDura <= BDura){
                    int i = p.getInventory().getLeggings().getType().getMaxDurability();
                    Piece =  "§8<§4Hose§8>§c " + (i + (p.getInventory().getLeggings().getMaxItemUseDuration() - p.getInventory().getLeggings().getDurability()));

                }else
                if(BDura <= HDura && BDura <= CDura && BDura <= LDura){
                    int i = p.getInventory().getBoots().getType().getMaxDurability();
                    Piece =  "§8<§4Schuhe§8>§c " + (i + (p.getInventory().getBoots().getMaxItemUseDuration() - p.getInventory().getBoots().getDurability()));
                }else
                if(CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                    int i = p.getInventory().getChestplate().getType().getMaxDurability();
                    Piece = "§8<§4Chest§8>§c " + (i + (p.getInventory().getChestplate().getMaxItemUseDuration() - p.getInventory().getChestplate().getDurability()));
                }        else
                if(HDura <= BDura && HDura <= LDura && HDura <= CDura){
                    int i = p.getInventory().getHelmet().getType().getMaxDurability();
                    Piece = "§8<§4Helm§8>§c " + (i + (p.getInventory().getHelmet().getMaxItemUseDuration() - p.getInventory().getHelmet().getDurability()));
                }}
            else {
                Piece ="§c" + Math.round(p.getHealth()/2) + " §c❤";
            }

        if(stats.getClan() == ""){
                stats.setClan("§cClanlos");
            }
        String clan = "§8<§6Konto§8> §e" + stats.getXp() + " §6✧";
        String xp1 = "§8<§aXP§8> §2" + xp;
        String pearls1 = "§8<§5Pearls§8> §x§D§6§5§B§E§9" + pearls;
        String tnt1 = "§8<§x§9§E§1§B§5§0T§x§C§F§0§E§5§2N§x§F§F§0§0§5§3T§8> §x§C§F§0§E§5§2" + tnt;
        String webs1 = "§8<§fWebs§8> §§x§C§2§F§A§E§F" + webs;

        //Assigning Strings to Modules

        String piece1 = "";
        String piece2 = "";
        String piece3 = "";

        if(module1 == 1){
            piece1 = Piece;
        }else if(module1 == 2){
            piece1 = xp1;
        }else if(module1 == 3){
            piece1 = pearls1;
        }else if(module1 == 4){
            piece1 = clan;
        }else if(module1 == 5){
            piece1 = tnt1;
        }else if(module1 == 6){
            piece1 = webs1;
        }

        if(module2 == 1){
            piece2 = Piece;
        }else if(module2 == 2){
            piece2 = xp1;
        }else if(module2 == 3){
            piece2 = pearls1;
        }else if(module2 == 4){
            piece2 = clan;
        }else if(module2 == 5){
            piece2 = tnt1;
        }else if(module2 == 6){
            piece2 = webs1;
        }

        if(module3 == 1){
            piece3 = Piece;
        }else if(module3 == 2){
            piece3 = xp1;
        }else if(module3 == 3){
            piece3 = pearls1;
        }else if(module3 == 4){
            piece3 = clan;
        }else if(module3 == 5){
            piece3 = tnt1;
        }else if(module3 == 6){
            piece3 = webs1;
        }

        Actionbar = piece1 + " §7| " + piece2 + " §7| " + piece3;
   return Actionbar;
}}
