package jansparadise.jansparadise.sonstiges;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Actionbar {

    public static String Actionbar(Player p, Player d, int module1, int module2){

        String Actionbar = "";
        int xp = 0;
        int pearls = 0;
        for(int m = 0; m <= 35; m++){
            if(p.getInventory().getItem(m) != null){
                if(p.getInventory().getItem(m).getType().equals(Material.EXPERIENCE_BOTTLE)){
                    xp = xp + p.getInventory().getItem(m).getAmount();
                }
                if(p.getInventory().getItem(m).getType().equals(Material.ENDER_PEARL)){
                    pearls = pearls + p.getInventory().getItem(m).getAmount();
                }
            }}




        if(!(p.getInventory().getArmorContents() == null)){
            int HDura = 0;
            int BDura = 0;
            int CDura = 0;
            int LDura = 0;
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
                    Actionbar = ("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Hose§8)§c " + (i + (p.getInventory().getLeggings().getMaxItemUseDuration() - p.getInventory().getLeggings().getDurability())) + " §7| §8<§aXP§8>: §2" + xp);

                }else
                if(BDura <= HDura && BDura <= CDura && BDura <= LDura){
                    int i = p.getInventory().getBoots().getType().getMaxDurability();
                    Actionbar = ("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Schuhe§8)§c " + (i + (p.getInventory().getBoots().getMaxItemUseDuration() - p.getInventory().getBoots().getDurability()))  + " §7| §8<§aXP§8>: §2" + xp);
                }else
                if(CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                    int i = p.getInventory().getChestplate().getType().getMaxDurability();
                    Actionbar = ("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Chest§8)§c " + (i + (p.getInventory().getChestplate().getMaxItemUseDuration() - p.getInventory().getChestplate().getDurability())) + " §7| §8<§aXP§8>: §2" + xp);
                }        else
                if(HDura <= BDura && HDura <= LDura && HDura <= CDura){
                    int i = p.getInventory().getHelmet().getType().getMaxDurability();
                    Actionbar = ("§cⓘ §8<§5Pearls§8> §5" + pearls +  " §7| §8(§4Helm§8)§c " + (i + (p.getInventory().getHelmet().getMaxItemUseDuration() - p.getInventory().getHelmet().getDurability()))  + " §7| §8<§aXP§8>: §2" + xp);
                }}
            else {
                Actionbar = ("§c" + Math.round(p.getHealth()/2) + " §c❤ §7| §8<§5Pearls§8> §5" + pearls);
            }
    }
   return Actionbar;
}}
