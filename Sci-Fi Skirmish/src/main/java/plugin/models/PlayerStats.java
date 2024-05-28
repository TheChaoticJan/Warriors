package plugin.models;

//perk1, perk2, perk3, perk4, perk5

import lombok.Getter;
import lombok.Setter;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

public class PlayerStats {

    private @Getter @Setter String uuid;
    private @Getter @Setter String name;
    private @Getter @Setter String rank;
    private @Getter @Setter String clan;
    private @Getter @Setter int xp;
    private @Getter @Setter int deaths;
    private @Getter @Setter int kills;

    private @Getter @Setter int [] crates; //sorted as: common, uncommon, epic, rare, mythic
    private @Getter @Setter boolean [] perks; //sorted as: first, second, third, ...
    private @Getter @Setter int [] infobarValues; // sorted as: first, second, third

    public PlayerStats(Player player, String rank, String clan, int xp, int deaths, int kills, int [] crates, boolean [] perks, int [] infobarValues) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.rank = rank;
        this.xp = xp;
        this.deaths = deaths;
        this.kills = kills;
        this.clan = clan;
        this.crates = crates;
        this.perks = perks;
        this.infobarValues = infobarValues;
    }

    public PlayerStats(OfflinePlayer player, String rank, String clan, int xp, int deaths, int kills, int [] crates, boolean [] perks, int [] infobarValues) {
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.rank = rank;
        this.xp = xp;
        this.deaths = deaths;
        this.kills = kills;
        this.clan = clan;
        this.crates = crates;
        this.perks = perks;
        this.infobarValues = infobarValues;
    }

    public PlayerStats(Player player){
        this.uuid = player.getUniqueId().toString();
        this.name = player.getName();
        this.rank = "Spieler";
        this.xp = 0;
        this.kills = 0;
        this.deaths = 0;
        this.clan = "";
        this.crates = new int[]{0, 0, 0, 0, 0};
        this.perks = new boolean[]{false, false, false, false, false, false};
        this.infobarValues = new int[]{1, 2, 3};
    }

    public void setInfobar(int index, int i){
        this.infobarValues[index] = i;
    }
    public void setPerk1(boolean bl){
        this.perks[0] = bl;
    }
    public void setPerk2(boolean bl){
        this.perks[1] = bl;
    }
    public void setPerk3(boolean bl){
        this.perks[2] = bl;
    }
    public void setPerk4(boolean bl){
        this.perks[3] = bl;
    }
    public void setPerk5(boolean bl){
        this.perks[4] = bl;
    }
    public void setPerk6(boolean bl){
        this.perks[5] = bl;
    }

}
