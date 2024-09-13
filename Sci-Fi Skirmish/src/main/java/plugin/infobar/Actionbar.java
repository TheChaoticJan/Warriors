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
                    Piece =  "§4§lHose §c" + (i + (p.getInventory().getLeggings().getMaxItemUseDuration() - p.getInventory().getLeggings().getDurability()));
                }
                else if(BDura <= HDura && BDura <= CDura){
                    int i = p.getInventory().getBoots().getType().getMaxDurability();
                    Piece =  "§4§lSchuhe §c" + (i + (p.getInventory().getBoots().getMaxItemUseDuration() - p.getInventory().getBoots().getDurability()));
                }
                else if(CDura <= LDura && CDura <= BDura && CDura <= HDura) {
                    int i = p.getInventory().getChestplate().getType().getMaxDurability();
                    Piece = "§4§lChest §c" + (i + (p.getInventory().getChestplate().getMaxItemUseDuration() - p.getInventory().getChestplate().getDurability()));
                }
                else{
                    int i = p.getInventory().getHelmet().getType().getMaxDurability();
                    Piece = "§4§lHelm §c" + (i + (p.getInventory().getHelmet().getMaxItemUseDuration() - p.getInventory().getHelmet().getDurability()));
                }
            }
            else {
                Piece ="§c" + Math.round(p.getHealth()/2) + " §c❤";
            }

        if(Objects.equals(stats.getClan(), "")){
                stats.setClan("§cClanlos");
            }

        int mainHandDura = counted.getMainhanddura();
        String mainhand = "§b§lMainhand §9" + mainHandDura;
        
        String clan = "§6§lKonto §e" + stats.getXp() + " §6✧";
        String xp1 = "§a§lXP §2" + counted.getXp();
        String pearls1 = "§5§lPearls §x§D§6§5§B§E§9" + counted.getPearls();
        String tnt1 = "§x§9§E§1§B§5§0§lT§x§C§F§0§E§5§2§lN§x§F§F§0§0§5§3§lT §x§C§F§0§E§5§2" + counted.getTnt();
        String webs1 = "§f§lWebs §§x§C§2§F§A§E§F" + counted.getWebs();

        String [] pieces = {"", "", ""};

        //Assigning Strings to Modules
        for(int i = 0; i < 3; i++){
            String [] cache = {Piece, xp1, pearls1, clan, tnt1, webs1, mainhand};

            pieces[i] = cache[modules[i] - 1];
        }

        return pieces[0] + " §7| " + pieces[1] + " §7| " + pieces[2];
    }
}
