package plugin.clans;

import org.bukkit.entity.Player;

import java.util.Date;

public class Request {

    private static byte type; // can either be "Invite" or "JoinRequest" (depending on if the clan invited the player or vice versa) -> 0 means JoinRequest, 1 means Invitation
    private static Player requestingPlayer;
    private static Player requestedPlayer;
    private static Clan requestingClan;
    private static Clan requestedClan;
    private static Date date; //The Date the request has been sent, maybe useful for the clan to know about

    //used, when a player is sending a JoinRequest to a Clan
    public Request(Player requestingPlayer, Clan requestedClan)
    {
        this.type = (byte) 0;
        this.requestingPlayer = requestingPlayer;
        this.requestedClan = requestedClan;
    }

    //used, when a clan is sending an invitation to a player
    public Request(Clan requestingClan, Player requestedPlayer)
    {
        this.type = (byte) 1;
        this.requestingClan = requestingClan;
        this.requestedPlayer = requestedPlayer;
    }




}
