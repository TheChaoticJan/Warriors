package plugin.ranksystem.models;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class RankHandler {

    public static List<String> rankList(){

        List<String> list = new ArrayList<>();
        list.add("Inhaber");
        list.add("Admin");
        list.add("Moderator");
        list.add("Goat");
        list.add("Simp");
        list.add("Spieler");

        return list;
    }


}
