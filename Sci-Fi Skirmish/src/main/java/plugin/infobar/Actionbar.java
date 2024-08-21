package plugin.infobar;

import plugin.models.PlayerStats;
import plugin.utils.essentials.Count;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Actionbar {

    public static String buildActionbar(Player p, PlayerStats stats, int [] modules){

        Count counted = new Count(p);

        int HDura = counted.getHelmetDura();
        int CDura = counted.getChestDura();
        int LDura = counted.getLeggingsDura();
        int BDura = counted.getBootsDura();

        String Piece;

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

        if(Objects.equals(stats.getClan(), "")){
                stats.setClan("§cClanlos");
            }

        int mainHandDura = counted.getMainhanddura();
        String mainhand = "§8<§bMainhand§8> §9" + mainHandDura;
        
        String clan = "§8<§6Konto§8> §e" + stats.getXp() + " §6✧";
        String xp1 = "§8<§aXP§8> §2" + counted.getXp();
        String pearls1 = "§8<§5Pearls§8> §x§D§6§5§B§E§9" + counted.getPearls();
        String tnt1 = "§8<§x§9§E§1§B§5§0T§x§C§F§0§E§5§2N§x§F§F§0§0§5§3T§8> §x§C§F§0§E§5§2" + counted.getTnt();
        String webs1 = "§8<§fWebs§8> §§x§C§2§F§A§E§F" + counted.getWebs();

        String [] pieces = {"", "", ""};

        //Assigning Strings to Modules
        for(int i = 0; i < 3; i++){
            String [] cache = {Piece, xp1, pearls1, clan, tnt1, webs1, mainhand};

            pieces[i] = cache[modules[i] - 1];
        }

        return pieces[0] + " §7| " + pieces[1] + " §7| " + pieces[2];
    }
}
