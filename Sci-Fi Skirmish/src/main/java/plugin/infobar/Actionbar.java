package plugin.infobar;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.inventory.ItemStack;
import plugin.models.PlayerStats;
import plugin.utils.essentials.Count;
import org.bukkit.entity.Player;

import java.util.Objects;

import static java.lang.Float.POSITIVE_INFINITY;

public class Actionbar {

    public static String buildActionbar(Player p, PlayerStats stats, int [] modules){

        Count counted = new Count(p);

        String Piece;
        int durability = (int) POSITIVE_INFINITY;
        int pos = 0;
        int temp = 0;
        ItemStack lowest = null;

        for(ItemStack stack : p.getInventory().getArmorContents()){

            if(stack == null){
                pos = -1;
                break;
            }

            if(stack.getType().getMaxDurability() == 0){
                continue;
            }

            if(stack.getType().getMaxDurability() - stack.getDurability() < durability){
                lowest = stack;
                durability = stack.getType().getMaxDurability() - stack.getDurability();
                pos = temp;
            }
            temp++;

        }

        switch (pos){
            case 0 -> {Piece =  "§4§lSchuhe §c";}
            case 1 -> {Piece =  "§4§lHose §c";}
            case 2 -> {Piece = "§4§lChest §c";}
            case 3 -> {Piece = "§4§lHelm §c";}
            default -> Piece ="§c" + Math.round(p.getHealth()/2) + " §c❤";
        }

        if(!Piece.endsWith("§c❤")){
            Piece += durability;
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
