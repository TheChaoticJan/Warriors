package jansparadise.jansparadise.db;

import jansparadise.jansparadise.models.PlayerStats;

import java.sql.*;
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
                String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, name varchar(16), xp int, uwu long, deaths int, kills int, blocks_placed int, common_crates int, uncommon_crates int, epic_crates int, rare_crates int, mythic_crates int, clan varchar(16))";
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
            int kills = results.getInt("kills");
            int blocks_placed = results.getInt("blocks_placed");
            int common_crates = results.getInt("common_crates");
            int uncommon_crates = results.getInt("uncommon_crates");
            int epic_crates = results.getInt("epic_crates");
            int rare_crates = results.getInt("rare_crates");
            int mythic_crates = results.getInt("mythic_crates");
            String clan = results.getString("clan");

            PlayerStats playerStats = new PlayerStats(uuid, name, xp, uwu, deaths, kills, blocks_placed, common_crates, uncommon_crates, epic_crates, rare_crates, mythic_crates, clan);

            statement.close();

            return playerStats;
        }

        statement.close();
        return null;

        }

        public void createPlayerStats(PlayerStats stats) throws SQLException{

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_stats(uuid, name,  xp, uwu, deaths, kills, blocks_placed, common_crates, uncommon_crates, epic_crates, rare_crates, mythic_crates, clan) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, stats.getUuid());
            statement.setString(2, stats.getName());
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


            statement.executeUpdate();

            statement.close();
        }

    public void updatePlayerStats(PlayerStats stats) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("UPDATE `player_stats` SET `name`=?,`xp`=?,`uwu`=?,`deaths`=?,`kills`=?,`blocks_placed`=?,`common_crates`=?,`uncommon_crates`=?,`epic_crates`=?,`rare_crates`=? ,`mythic_crates`=?, `clan`=? WHERE `uuid`= '" + stats.getUuid() + "';");

        statement.setString(1, stats.getName());
        statement.setInt(2, stats.getXp());
        statement.setLong(3, stats.getUwu());
        statement.setInt(4, stats.getDeaths());
        statement.setInt(5, stats.getKills());
        statement.setInt(6, stats.getBlocks_placed());
        statement.setInt(7, stats.getCommon_crates());
        statement.setInt(8, stats.getUncommon_crates());
        statement.setInt(9, stats.getEpic_crates());
        statement.setInt(10, stats.getRare_crates());
        statement.setInt(11, stats.getMythic_crates());
        statement.setString(12, stats.getClan());

        statement.executeUpdate();

        statement.close();
    }







}


