package plugin.models;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;

public class Stats {

    Player player;

    public Stats(Player player){
        this.player = player;
    }

    public boolean getPerk1(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk1"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk2(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk2"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk3(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk3"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk4(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk4"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk5(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk5"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk6(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk6"), PersistentDataType.BOOLEAN));
    }
    public boolean getPerk7(){
        return Boolean.TRUE.equals(this.player.getPersistentDataContainer().get(new NamespacedKey(Main.getInstance(), "Perk7"), PersistentDataType.BOOLEAN));
    }
}
