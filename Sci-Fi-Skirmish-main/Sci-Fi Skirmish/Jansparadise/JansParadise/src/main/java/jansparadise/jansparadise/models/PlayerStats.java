package jansparadise.jansparadise.models;

//perk1, perk2, perk3, perk4, perk5

public class PlayerStats {

    private String uuid;
    private String name;
    private String rank;
    private int xp;
    private long uwu;
    private int deaths;
    private int kills;
    private int blocks_placed;
    private int common_crates;
    private int uncommon_crates;
    private int epic_crates;
    private int rare_crates;
    private int mythic_crates;
    private String clan;
    private Boolean perk1;
    private Boolean perk2;
    private Boolean perk3;
    private Boolean perk4;
    private Boolean perk5;

    private int infobar1;
    private int infobar2;
    private int infobar3;



    public PlayerStats(String uuid, String name, String rank, int xp, long uwu, int deaths, int kills, int blocks_placed, int common_crates, int uncommon_crates, int epic_crates, int rare_crates, int mythic_crates, String clan, Boolean perk1, Boolean perk2, Boolean perk3, Boolean perk4, Boolean perk5, int infobar1, int infobar2, int infobar3) {
        this.uuid = uuid;
        this.name = name;
        this.rank = rank;
        this.xp = xp;
        this.uwu = uwu;
        this.deaths = deaths;
        this.kills = kills;
        this.blocks_placed = blocks_placed;
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
        this.infobar1 = infobar1;
        this.infobar2 = infobar2;
        this.infobar3 = infobar3;
    }

    public int getInfobar1() {
        return infobar1;
    }

    public void setInfobar1(int infobar1) {
        this.infobar1 = infobar1;
    }

    public int getInfobar2() {
        return infobar2;
    }

    public void setInfobar2(int infobar2) {
        this.infobar2 = infobar2;
    }

    public int getInfobar3() {
        return infobar3;
    }

    public void setInfobar3(int infobar3) {
        this.infobar3 = infobar3;
    }

    public String getClan() {
        return clan;
    }

    public void setClan(String clan) {
        this.clan = clan;
    }

    public long getUwu() {
        return (long) uwu;
    }

    public int getCommon_crates() {
        return common_crates;
    }

    public void setCommon_crates(int common_crates) {
        this.common_crates = common_crates;
    }

    public int getUncommon_crates() {
        return uncommon_crates;
    }

    public void setUncommon_crates(int uncommon_crates) {
        this.uncommon_crates = uncommon_crates;
    }

    public int getEpic_crates() {
        return epic_crates;
    }

    public void setEpic_crates(int epic_crates) {
        this.epic_crates = epic_crates;
    }

    public int getRare_crates() {
        return rare_crates;
    }

    public void setRare_crates(int rare_crates) {
        this.rare_crates = rare_crates;
    }

    public int getMythic_crates() {
        return mythic_crates;
    }

    public void setMythic_crates(int mythic_crates) {
        this.mythic_crates = mythic_crates;
    }

    public void setUwu(long uwu) {
        this.uwu = uwu;
    }

    public int getBlocks_placed() {
        return blocks_placed;
    }

    public void setBlocks_placed(int blocks_placed) {
        this.blocks_placed = blocks_placed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Boolean getPerk1() {
        return perk1;
    }

    public void setPerk1(Boolean perk1) {
        this.perk1 = perk1;
    }

    public Boolean getPerk2() {
        return perk2;
    }

    public void setPerk2(Boolean perk2) {
        this.perk2 = perk2;
    }

    public Boolean getPerk3() {
        return perk3;
    }

    public void setPerk3(Boolean perk3) {
        this.perk3 = perk3;
    }

    public Boolean getPerk4() {
        return perk4;
    }

    public void setPerk4(Boolean perk4) {
        this.perk4 = perk4;
    }

    public Boolean getPerk5() {
        return perk5;
    }

    public void setPerk5(Boolean perk5) {
        this.perk5 = perk5;
    }



}
