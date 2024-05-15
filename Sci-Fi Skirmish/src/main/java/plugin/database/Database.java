package plugin.database;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import plugin.models.PlayerStats;

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
        System.out.println("\u001B[32m Erfolgreich mit der Datenbank verbunden!");
        return this.connection;
        }

        public void initiliazeDatabase() throws SQLException{
                Statement statement = getConnection().createStatement();
                String sql = "CREATE TABLE IF NOT EXISTS player_stats(uuid varchar(36) primary key, name varchar(16), rank varchar(16), xp int, deaths int, kills int, common_crates int, uncommon_crates int, epic_crates int, rare_crates int, mythic_crates int, clan varchar(16), perk1 boolean, perk2 boolean, perk3 boolean, perk4 boolean, perk5 boolean, perk6 boolean, infobar1 tinyint(6), infobar2 tinyint(6), infobar3 tinyint(6))";
                statement.execute(sql);
                statement.close();
        }

    public PlayerStats findPlayerStats(OfflinePlayer player) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM player_stats WHERE uuid = ?");
        statement.setString(1, player.getUniqueId().toString());
        ResultSet results = statement.executeQuery();

        if(results.next()){

            String rank = results.getString("rank");
            String clan = results.getString("clan");

            int xp = results.getInt("xp");
            int deaths = results.getInt("deaths");
            int kills = results.getInt("kills");

            int [] crates = new int[]{
                    results.getInt("common_crates"),
                    results.getInt("uncommon_crates"),
                    results.getInt("epic_crates"),
                    results.getInt("rare_crates"),
                    results.getInt("mythic_crates")
            };

            boolean [] perks = new boolean[]{
                    results.getBoolean("perk1"),
                    results.getBoolean("perk2"),
                    results.getBoolean("perk3"),
                    results.getBoolean("perk4"),
                    results.getBoolean("perk5"),
                    results.getBoolean("perk6")
            };

            int [] infobarValues = new int[]{
                    results.getInt("infobar1"),
                    results.getInt("infobar2"),
                    results.getInt("infobar3")
            };


            PlayerStats playerStats = new PlayerStats(player,  rank,  clan, xp, deaths, kills, crates, perks, infobarValues);

            statement.close();

            return playerStats;
        }

        statement.close();
        return null;

        }

        public void createPlayerStats(PlayerStats stats) throws SQLException{

            PreparedStatement statement = getConnection().prepareStatement("INSERT INTO player_stats(uuid, name, rank,  xp, deaths, kills, common_crates, uncommon_crates, epic_crates, rare_crates, mythic_crates, clan, perk1, perk2, perk3, perk4, perk5, perk6, infobar1, infobar2, infobar3) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setString(1, stats.getUuid());
            statement.setString(2, stats.getName());
            statement.setString(3, stats.getRank());
            statement.setString(12, stats.getClan());

            statement.setInt(4, stats.getXp());
            statement.setInt(5, stats.getDeaths());
            statement.setInt(6, stats.getKills());

            statement.setInt(7, stats.getCrates()[0]);
            statement.setInt(8, stats.getCrates()[1]);
            statement.setInt(9, stats.getCrates()[2]);
            statement.setInt(10, stats.getCrates()[3]);
            statement.setInt(11, stats.getCrates()[4]);

            statement.setBoolean(13, stats.getPerks()[0]);
            statement.setBoolean(14, stats.getPerks()[1]);
            statement.setBoolean(15, stats.getPerks()[2]);
            statement.setBoolean(16, stats.getPerks()[3]);
            statement.setBoolean(17, stats.getPerks()[4]);
            statement.setBoolean(18, stats.getPerks()[5]);

            statement.setInt(19, stats.getInfobarValues()[0]);
            statement.setInt(20, stats.getInfobarValues()[1]);
            statement.setInt(21, stats.getInfobarValues()[2]);

            statement.executeUpdate();

            statement.close();
        }

    public void updatePlayerStats(PlayerStats stats) throws SQLException{

        PreparedStatement statement = getConnection().prepareStatement("UPDATE `player_stats` SET `name`=?,`rank`=?,`xp`=?,`deaths`=?,`kills`=?,`common_crates`=?,`uncommon_crates`=?,`epic_crates`=?,`rare_crates`=? ,`mythic_crates`=?, `clan`=?, `perk1`=?,`perk2`=?,`perk3`=?,`perk4`=?,`perk5`=?,`perk6`=?, `infobar1`=?, `infobar2`=?, `infobar3`=? WHERE `uuid`= '" + stats.getUuid() + "';");

        statement.setString(1, stats.getName());
        statement.setString(2, stats.getRank());
        statement.setInt(3, stats.getXp());
        statement.setInt(4, stats.getDeaths());
        statement.setInt(5, stats.getKills());
        statement.setInt(6, stats.getCrates()[0]);
        statement.setInt(7, stats.getCrates()[1]);
        statement.setInt(8, stats.getCrates()[2]);
        statement.setInt(9, stats.getCrates()[3]);
        statement.setInt(10, stats.getCrates()[4]);
        statement.setString(11, stats.getClan());
        statement.setBoolean(12, stats.getPerks()[0]);
        statement.setBoolean(13, stats.getPerks()[1]);
        statement.setBoolean(14, stats.getPerks()[2]);
        statement.setBoolean(15, stats.getPerks()[3]);
        statement.setBoolean(16, stats.getPerks()[4]);
        statement.setBoolean(17, stats.getPerks()[5]);
        statement.setInt(18, stats.getInfobarValues()[0]);
        statement.setInt(19, stats.getInfobarValues()[1]);
        statement.setInt(20, stats.getInfobarValues()[2]);

        statement.executeUpdate();

        statement.close();
        
    }

    public ArrayList<String> getTopTenStats(String columname) throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM `player_stats` ORDER BY `player_stats`.`"+ columname +"` DESC LIMIT 7");
        ResultSet results = statement.executeQuery();


        ArrayList<String> list = new ArrayList<>();
        while (results.next()) {
            String name = results.getString("name");
            String xp = String.valueOf(results.getInt(columname));

            list.add(name);
            list.add(xp);
        }
        statement.close();
        return list;


    }







}


