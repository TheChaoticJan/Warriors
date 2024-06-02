package plugin.listeners.entitylisteners.interactions.chatevents;

import lombok.Getter;

import java.util.ArrayList;

public class ChatLists {

    private final @Getter ArrayList<String> filterList = new ArrayList<String>();
    private final @Getter ArrayList<String> okayList = new ArrayList<String>();

    public ChatLists(){

        //filling the filter-list
        filterList.add("hs");
        filterList.add("hurensohn");
        filterList.add("hitler");
        filterList.add("adolf");
        filterList.add("bastard");
        filterList.add("heil");
        filterList.add("h3il");
        filterList.add("anus");
        filterList.add("nazi");
        filterList.add("nationalsozialismus");
        filterList.add("siegheil");


        //filling the okay-list
        okayList.add("geheilt");

    }


}