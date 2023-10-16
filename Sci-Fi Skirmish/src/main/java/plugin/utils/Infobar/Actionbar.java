package plugin.utils.Infobar;

import plugin.models.PlayerStats;
import plugin.utils.essentials.Count;
import org.bukkit.entity.Player;

public class Actionbar {


    public static String Actionbar(Player p, PlayerStats stats, Player d, int module1, int module2, int module3){

        int HDura = Count.CountValues(p).get(4);
        int CDura = Count.CountValues(p).get(5);
        int LDura = Count.CountValues(p).get(6);
        int BDura = Count.CountValues(p).get(7);

        String Piece = "";

            if(!(p.getInventory().getLeggings() == null) && !(p.getInventory().getBoots() == null)  && !(p.getInventory().getChestplate() == null)  && !(p.getInventory().getHelmet() == null)){
                if(LDura <= HDura && LDura <= CDura && LDura <= BDura){
                    int i = p.getInventory().getLeggings().getType().getMaxDurability();
                    Piece =  "§8<§4Hose§8>§c " + (i + (p.getInventory().getLeggings().getMaxItemUseDuration() - p.getInventory().getLeggings().getDurability()));

                }else
                if(BDura <= HDura && BDura <= CDura){
                    int i = p.getInventory().getBoots().getType().getMaxDurability();
                    Piece =  "§8<§4Schuhe§8>§c " + (i + (p.getInventory().getBoots().getMaxItemUseDuration() - p.getInventory().getBoots().getDurability()));
                }else
                if(CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                    int i = p.getInventory().getChestplate().getType().getMaxDurability();
                    Piece = "§8<§4Chest§8>§c " + (i + (p.getInventory().getChestplate().getMaxItemUseDuration() - p.getInventory().getChestplate().getDurability()));
                }else{
                    int i = p.getInventory().getHelmet().getType().getMaxDurability();
                    Piece = "§8<§4Helm§8>§c " + (i + (p.getInventory().getHelmet().getMaxItemUseDuration() - p.getInventory().getHelmet().getDurability()));
                }
            }
            else {
                Piece ="§c" + Math.round(p.getHealth()/2) + " §c❤";
            }

        if(stats.getClan() == ""){
                stats.setClan("§cClanlos");
            }

        int mainHandDura = Count.CountValues(p).get(8);
        String mainhand = "§8<§bMainhand§8> §9" + mainHandDura;
        
        String clan = "§8<§6Konto§8> §e" + stats.getXp() + " §6✧";
        String xp1 = "§8<§aXP§8> §2" + Count.CountValues(p).get(0);
        String pearls1 = "§8<§5Pearls§8> §x§D§6§5§B§E§9" + Count.CountValues(p).get(1);
        String tnt1 = "§8<§x§9§E§1§B§5§0T§x§C§F§0§E§5§2N§x§F§F§0§0§5§3T§8> §x§C§F§0§E§5§2" + Count.CountValues(p).get(2);
        String webs1 = "§8<§fWebs§8> §§x§C§2§F§A§E§F" + Count.CountValues(p).get(3);

        //Assigning Strings to Modules

        String piece1 = "";
        String piece2 = "";
        String piece3 = "";

        for(int i = 1; i <= 3; i++){
            String var = "";
            int val = 0;
            //Gathering moduleX
            if(i == 1) { val = module1; }
            if(i == 2) { val = module2; }
            if(i == 3) { val = module3; }

            if(val == 1){ var = Piece; }
            else if(val == 2){ var = xp1; }
            else if(val == 3){ var = pearls1; }
            else if(val == 4){ var = clan; }
            else if(val == 5){ var = tnt1; }
            else if(val == 6){ var = webs1; }
            else if(val == 7){ var = mainhand; }
            //Assigning to pieceX
            if(i == 1) { piece1 = var; }
            if(i == 2) { piece2 = var; }
            if(i == 3) { piece3 = var; }
        }

        String Actionbar = "";
        Actionbar = piece1 + " §7| " + piece2 + " §7| " + piece3;

        return Actionbar;
    }
}
