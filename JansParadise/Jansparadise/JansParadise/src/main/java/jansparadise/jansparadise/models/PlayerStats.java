package jansparadise.jansparadise.models;

public class PlayerStats {

    private String uuid;
    private int deaths;
    private int kills;
    private int xp;

    private long uwu;

    private String name;

    private int blocks_placed;

    private int common_crates;
    private int uncommon_crates;
    private int epic_crates;
    private int rare_crates;
    private int mythic_crates;

    private String clan;


    public PlayerStats(String uuid, String name, int xp, long uwu, int deaths, int kills, int blocks_placed, int common_crates, int uncommon_crates, int epic_crates, int rare_crates, int mythic_crates, String clan) {
        this.uuid = uuid;
        this.deaths = deaths;
        this.kills = kills;
        this.xp = xp;
        this.name = name;
        this.blocks_placed = blocks_placed;
        this.uwu = uwu;
        this.common_crates = common_crates;
        this.uncommon_crates = uncommon_crates;
        this.epic_crates = epic_crates;
        this.rare_crates = rare_crates;
        this.mythic_crates = mythic_crates;
        this.clan = clan;

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



}
