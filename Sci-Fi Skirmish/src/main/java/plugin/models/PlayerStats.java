package plugin.models;

//perk1, perk2, perk3, perk4, perk5

import lombok.Getter;
import lombok.Setter;

public class PlayerStats {
    private @Getter
    @Setter String uuid;
    private @Getter
    @Setter String name;
    private @Getter
    @Setter String rank;
    private @Getter
    @Setter int xp;
    private @Getter
    @Setter int deaths;
    private @Getter
    @Setter int kills;
    private @Getter
    @Setter int common_crates;
    private @Getter
    @Setter int uncommon_crates;
    private @Getter
    @Setter int epic_crates;
    private @Getter
    @Setter int rare_crates;
    private @Getter
    @Setter int mythic_crates;
    private @Getter
    @Setter String clan;
    private @Getter
    @Setter Boolean perk1;
    private @Getter
    @Setter Boolean perk2;
    private @Getter
    @Setter Boolean perk3;
    private @Getter
    @Setter Boolean perk4;
    private @Getter
    @Setter Boolean perk5;
    private @Getter
    @Setter Boolean perk6;
    private @Getter
    @Setter int infobar1;
    private @Getter
    @Setter int infobar2;
    private @Getter
    @Setter int infobar3;


    public PlayerStats(String uuid, String name, String rank, int xp, int deaths, int kills, int common_crates, int uncommon_crates, int epic_crates, int rare_crates, int mythic_crates, String clan, Boolean perk1, Boolean perk2, Boolean perk3, Boolean perk4, Boolean perk5, Boolean perk6, int infobar1, int infobar2, int infobar3) {
        this.uuid = uuid;
        this.name = name;
        this.rank = rank;
        this.xp = xp;
        this.deaths = deaths;
        this.kills = kills;
        this.common_crates = common_crates;
        this.uncommon_crates = uncommon_crates;
        this.epic_crates = epic_crates;
        this.rare_crates = rare_crates;
        this.mythic_crates = mythic_crates;
        this.clan = clan;
        this.perk1 = perk1;
        this.perk2 = perk2;
        this.perk3 = perk3;
        this.perk4 = perk4;
        this.perk5 = perk5;
        this.perk6 = perk6;
        this.infobar1 = infobar1;
        this.infobar2 = infobar2;
        this.infobar3 = infobar3;
    }
}
