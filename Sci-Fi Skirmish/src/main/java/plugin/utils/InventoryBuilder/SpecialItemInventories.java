package plugin.utils.InventoryBuilder;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.utils.ItemBuilder.*;

import java.util.ArrayList;
public class SpecialItemInventories {
    private static ItemStack createSelectionItem(Material material, String name, String key){
        ItemStack stack = new ItemStack(material);
        ItemMeta meta = stack.getItemMeta();
        meta.displayName(MiniMessage.miniMessage().deserialize(name));
        meta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "special"), PersistentDataType.STRING, key);
        meta.addEnchant(Enchantment.MENDING, 1 ,true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ArrayList<String> lore = new ArrayList<>();
        lore.add("§7§o*Click*");
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }
    public static Inventory selection(Player p, String name){
        Inventory inventory = Bukkit.createInventory(p,36 , MiniMessage.miniMessage().deserialize(name));

        for(int i = 0; i <= 35; i++){
            inventory.setItem(i, InventoryEssentials.glass());
        }

        inventory.setItem(10, createSelectionItem(Material.BLUE_DYE, "<gradient:#008DFF:#C60BF9><b>Sci-Fi",("scifi")));
        inventory.setItem(11, createSelectionItem(Material.YELLOW_DYE, "<gradient:#EBD77B:#BED556><b>Erfahren",("erfahren")));
        inventory.setItem(19, createSelectionItem(Material.RED_DYE, "<gradient:#DD2D2D:#AA781C><b>Explosiv",("explosive")));
        inventory.setItem(20, createSelectionItem(Material.LIME_DYE, "<gradient:#5ADD2D:#40AA1C><b>Klebrig",("sticky")));

        inventory.setItem(13, createSelectionItem(Material.PURPLE_DYE, "<gradient:#824622:#b5185c><b>Vampirisch",("vampiric")));
        inventory.setItem(22, createSelectionItem(Material.ORANGE_DYE, "<gradient:#6a3e0a:#9d2323:#e5e814><b>Berserker",("berserker")));

        inventory.setItem(15, createSelectionItem(Material.GRAY_DYE, "<gradient:#b9c6bf:#a4b19b><b>Sonstiges",("else")));
        inventory.setItem(16, createSelectionItem(Material.WHITE_DYE, "<gradient:#4cd98d:#77cd3b><b>Kerzen",("candles")));

        inventory.setItem(24, createSelectionItem(Material.GOLD_INGOT, "<gradient:gold:red><b>Western", ("western")));

        return inventory;

    }
    public static Inventory showOff(Player player, String tag, String name){
        Inventory inventory = Bukkit.createInventory(player, 36, MiniMessage.miniMessage().deserialize(name));
        for(int i = 0; i <= 34; i++){
            inventory.setItem(i, InventoryEssentials.glass());
            if(i == 9){
                i = 25;
            }
        }

        inventory.setItem(17, InventoryEssentials.glass());
        inventory.setItem(18, InventoryEssentials.glass());
        inventory.setItem(35, InventoryEssentials.back());

        switch (tag) {
            case "western" -> {
                inventory.setItem(10, Western.Schwert(player));
                inventory.setItem(11, Western.Bogen(player));
                inventory.setItem(12, Western.Rod(player));
                inventory.setItem(13, Western.Picke(player));
                inventory.setItem(19, Western.Helmet(player));
                inventory.setItem(20, Western.Chestplate(player));
                inventory.setItem(21, Western.Leggings(player));
                inventory.setItem(22, Western.Boots(player));
            }
            case "candles" -> {
                inventory.setItem(10, Candles.emptyCandle());
                inventory.setItem(12, Candles.crateCandle());
                inventory.setItem(13, Candles.healCandle());
                inventory.setItem(14, Candles.boostCandle());
                inventory.setItem(15, Candles.teleportCandle());
                inventory.setItem(16, Candles.superCandle());
            }
            case "scifi" -> {
                inventory.setItem(10, SpecialResources.SciFiFragment(1));
                inventory.setItem(11, SpecialResources.SciFiBarren(1));
                inventory.setItem(13, SciFiItems.Schwert());
                inventory.setItem(14, SciFiItems.Axt());
                inventory.setItem(15, SciFiItems.Bogen());
            }
            case "vampiric" -> {
                inventory.setItem(10, Vampirisch.ComboHoe(player));
                inventory.setItem(11, Vampirisch.EssenceBow(player));
                inventory.setItem(12, Vampirisch.VampireCrown(player));
            }
            case "berserker" -> {
                inventory.setItem(10, Berserker.Axe(player));
                inventory.setItem(11, Berserker.Tracker());
            }
            case "erfahren" -> {
                inventory.setItem(10, SpecialResources.ErfahrenFragment(1));
                inventory.setItem(11, SpecialResources.ErfahrenBarren(1));
                inventory.setItem(13, ErfahrenItems.sword());
                inventory.setItem(14, ErfahrenItems.Axt());
                inventory.setItem(15, ErfahrenItems.bow());
            }
            case "explosive" -> {
                inventory.setItem(10, SpecialResources.ExplosivPuder(1));
                inventory.setItem(11, SpecialResources.ExplosivBarren(1));
                inventory.setItem(13, Explosiv.Spitzhacke());
                inventory.setItem(14, Explosiv.Angel());
            }
            case "sticky" -> {
                inventory.setItem(10, SpecialResources.KlebrigFragment(1));
                inventory.setItem(11, SpecialResources.KlebrigBarren(1));
                inventory.setItem(13, Klebrig.Schwert());
                inventory.setItem(14, Klebrig.Angel());
                inventory.setItem(15, Klebrig.Bogen());
            }
            case "else" -> inventory.setItem(10, UnsortableItems.loveStick());

            default -> player.sendMessage("DA IST WAS FALSCH");
        }
        return inventory;
    }

}
