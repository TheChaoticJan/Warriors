package jansparadise.jansparadise.db;

import jansparadise.jansparadise.models.PlayerStats;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private Connection connection;
    public Connection getConnection() throws SQLException {

        if(connection != null){
            return connection;
        }
        String url = "jdbc:mysql://localhost/stat_tracker";
        String user = "root";
        String password = "";

        this.connection = DriverManager.getConnection(url, user, password);
        System.out.println("Verbunden");
        return this.connection;
        }

        public void initiliazeDatabase() throws SQLException{
                Statement statement = getConnection().createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, name varchar(16), rank varchar(16), xp int, uwu long, deaths int, kills int, blocks_placed int, common_crates int, uncommon_crates int, epic_crates int, rare_crates int, mythic_crates int, clan varchar(16), perk1 boolean, perk2 boolean, perk3 boolean, perk4 boolean, perk5 boolean, infobar1 tinyint(6), infobar2 tinyint(6), infobar3 tinyint(6))";
                statement.execute(sql);
                statement.close();

        }

    public PlayerStats findPlayerStatsByUUID(String uuid) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_stats WHERE uuid = ?");
        statement.setString(1, uuid);
        ResultSet results = statement.executeQuery();

        if(results.next()){

            int deaths = results.getInt("deaths");
            int xp = results.getInt("xp");
            long uwu = results.getLong("uwu");
            String name = results.getString("name");
            String rank = results.getString("rank");
            int kills = results.getInt("kills");
            int blocks_placed = results.getInt("blocks_placed");
            int common_crates = results.getInt("common_crates");
            int uncommon_crates = results.getInt("uncommon_crates");
            int epic_crates = results.getInt("epic_crates");
            int rare_crates = results.getInt("rare_crates");
            int mythic_crates = results.getInt("mythic_crates");
            String clan = results.getString("clan");
            Boolean perk1 = results.getBoolean("perk1");
            Boolean perk2 = results.getBoolean("perk2");
            Boolean perk3 = results.getBoolean("perk3");
            Boolean perk4 = results.getBoolean("perk4");
            Boolean perk5 = results.getBoolean("perk5");
            int infobar1 = results.getInt("infobar1");
            int infobar2 = results.getInt("infobar2");
            int infobar3 = results.getInt("infobar3");

            PlayerStats playerStats = new PlayerStats(uuid, name, rank,  xp, uwu, deaths, kills, blocks_placed, common_crates, uncommon_crates, epic_crates, rare_crates, mythic_crates, clan, perk1, perk2, perk3, perk4, perk5, infobar1, infobar2, infobar3);

            statement.close();

            return playerStats;
        }

        statement.close();
        return null;

        }

        public void createPlayerStats(PlayerStats stats) throws SQLException{

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_stats(uuid, name, rank,  xp, uwu, deaths, kills, blocks_placed, common_crates, uncommon_crates, epic_crates, rare_crates, mythic_crates, clan, perk1, perk2, perk3, perk4, perk5, infobar1, infobar2, infobar3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, stats.getUuid());
            statement.setString(2, stats.getName());
            statement.setString(3, stats.getRank());
            statement.setInt(4, stats.getXp());
            statement.setLong(5, stats.getUwu());
            statement.setInt(6, stats.getDeaths());
            statement.setInt(7, stats.getKills());
            statement.setInt(8, stats.getBlocks_placed());
            statement.setInt(9, stats.getCommon_crates());
            statement.setInt(10, stats.getUncommon_crates());
            statement.setInt(11, stats.getEpic_crates());
            statement.setInt(12, stats.getRare_crates());
            statement.setInt(13, stats.getMythic_crates());
            statement.setString(14, stats.getClan());
            statement.setBoolean(15, stats.getPerk1());
            statement.setBoolean(16, stats.getPerk2());
            statement.setBoolean(17, stats.getPerk3());
            statement.setBoolean(18, stats.getPerk4());
            statement.setBoolean(19, stats.getPerk5());
            statement.setInt(20, stats.getInfobar1());
            statement.setInt(21, stats.getInfobar2());
            statement.setInt(22, stats.getInfobar3());

            statement.executeUpdate();

            statement.close();
        }

    public void updatePlayerStats(PlayerStats stats) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("UPDATE `player_stats` SET `name`=?,`rank`=?,`xp`=?,`uwu`=?,`deaths`=?,`kills`=?,`blocks_placed`=?,`common_crates`=?,`uncommon_crates`=?,`epic_crates`=?,`rare_crates`=? ,`mythic_crates`=?, `clan`=?, `perk1`=?,`perk2`=?,`perk3`=?,`perk4`=?,`perk5`=?, `infobar1`=?, `infobar2`=?, `infobar3`=? WHERE `uuid`= '" + stats.getUuid() + "';");

        statement.setString(1, stats.getName());
        statement.setString(2, stats.getRank());
        statement.setInt(3, stats.getXp());
        statement.setLong(4, stats.getUwu());
        statement.setInt(5, stats.getDeaths());
        statement.setInt(6, stats.getKills());
        statement.setInt(7, stats.getBlocks_placed());
        statement.setInt(8, stats.getCommon_crates());
        statement.setInt(9, stats.getUncommon_crates());
        statement.setInt(10, stats.getEpic_crates());
        statement.setInt(11, stats.getRare_crates());
        statement.setInt(12, stats.getMythic_crates());
        statement.setString(13, stats.getClan());
        statement.setBoolean(14, stats.getPerk1());
        statement.setBoolean(15, stats.getPerk2());
        statement.setBoolean(16, stats.getPerk3());
        statement.setBoolean(17, stats.getPerk4());
        statement.setBoolean(18, stats.getPerk5());
        statement.setInt(19, stats.getInfobar1());
        statement.setInt(20, stats.getInfobar2());
        statement.setInt(21, stats.getInfobar3());

        statement.executeUpdate();

        statement.close();
    }

    public ArrayList getTopTenStats(String columname) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM `player_stats` ORDER BY `player_stats`.`"+ columname +"` DESC LIMIT 7");
        ResultSet results = statement.executeQuery();


        ArrayList list = new ArrayList();
        while (results.next()) {
            String name = results.getString("name");
            int xp = results.getInt(columname);

            list.add(name);
            list.add(xp);

        }
        statement.close();
        return list;


    }







}


