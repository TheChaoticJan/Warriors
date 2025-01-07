package plugin.specialitems.uniques;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import plugin.Main;

public interface Unique {

     static final NamespacedKey uniqueKey = new NamespacedKey(Main.getInstance(), "unique");
    // Boolean isSpecialized(String itemID, Player player);


     static final NamespacedKey [] keyList = new NamespacedKey[]{
             new NamespacedKey(Main.getInstance(), "ice_sword"),
             new NamespacedKey(Main.getInstance(), "assasin_sword"),
             new NamespacedKey(Main.getInstance(), "swift_sword"),
             new NamespacedKey(Main.getInstance(), "bloody_hoe"),
             new NamespacedKey(Main.getInstance(), "titan_sword")
     };

}



