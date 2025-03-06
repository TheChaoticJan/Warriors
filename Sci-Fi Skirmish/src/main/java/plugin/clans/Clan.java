package plugin.clans;

import org.bukkit.entity.Player;
import plugin.Main;
import plugin.models.PlayerStats;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class Clan {

    private static String name;
    private static String tag;
    private static int bankBalance;
    private static boolean open;
    private static final ArrayList requests = new ArrayList<Request>();


    public Clan(String name, String tag)
    {
        this.name = name;
        this.tag = tag;
        this.bankBalance = 0;
        this.open = false;

        initClan(name, tag, 0);
    }

    public Clan(String name, String tag, int balance)
    {
        this.name = name;
        this.tag = tag;
        this.bankBalance = balance;
        this.open = false;
    }

    private static void initClan(String name, String tag, int balance)
    {
            Clan clan = Main.getInstance().getDatabase().findClanByTag(tag);

            if(clan == null){
                Main.getInstance().getDatabase().safeClan(name, tag, balance);
            }
    }

    public static void delete(Player player)
    {
        try
        {
            PlayerStats stats = Main.getInstance().getDatabase().findPlayerStats(player);

            if(!Objects.equals(stats.getClan_rank(), "Leader"))
            {
                player.sendMessage("§cNur der Anführer eines Clans darf seinen Clan löschen!");
                return;
            }

            Main.getInstance().getDatabase().deleteClan(stats.getClan());
            player.sendMessage("§aDu hast deinen Clan erfolgreich gelöscht!");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }



}
