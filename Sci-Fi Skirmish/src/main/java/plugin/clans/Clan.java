package plugin.clans;

import plugin.Main;

public class Clan {

    private static String name;
    private static String tag;
    private static int bankBalance;
    private static boolean open;


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



}
