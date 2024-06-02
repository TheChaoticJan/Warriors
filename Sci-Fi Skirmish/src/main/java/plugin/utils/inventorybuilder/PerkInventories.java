package plugin.utils.inventorybuilder;

import net.kyori.adventure.text.Component;
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
import plugin.models.PlayerStats;
import plugin.utils.itembuilder.InventoryEssentials;

import java.util.ArrayList;

public class PerkInventories {

    //Armorer-Perk
    private static ItemStack armorerPerk(PlayerStats stats) {
        ItemStack ArmorerPerk = new ItemStack(Material.LODESTONE);
        ItemMeta ArmorerMeta = ArmorerPerk.getItemMeta();
        ArmorerMeta.setDisplayName("§3Rüstungsfanatiker");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7Mit dem §3Rüstungsfanatiker §7Perk");
        lore.add("§7hast du eine kleine Chance, dass");
        lore.add("§7dein §ckaputtestes Rüstungsteil");
        lore.add("§7um 10 Haltbarkeit §arepariert wird§7!");
        ArmorerMeta.setLore(lore);
        if (stats.getPerks()[0]) {
            ArmorerMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            ArmorerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        ArmorerPerk.setItemMeta(ArmorerMeta);
        return ArmorerPerk;
    }

    private static ItemStack thievePerk(PlayerStats stats){

        ItemStack ArmorerPerk = new ItemStack(Material.LEAD);
        ItemMeta ArmorerMeta = ArmorerPerk.getItemMeta();
        ArmorerMeta.setDisplayName("§6Taschendieb");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("");
        lore.add("§7Als §aTaschendieb §7kannst du");
        lore.add("§7alle §660 Sekunden §7mit Rechtsklick");
        lore.add("§7 & einem §bDiamantschwert §7in der Hand");
        lore.add("§7das Inventar deines §cGegners §7auf Cooldown setzen!");
        ArmorerMeta.setLore(lore);
        if (stats.getPerks()[5]) {
            ArmorerMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            ArmorerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        ArmorerPerk.setItemMeta(ArmorerMeta);
        return ArmorerPerk;
    }


    //Cobweb-Perk
    private static ItemStack cobwebPerk(PlayerStats stats) {
        ItemStack CobwebPerk = new ItemStack(Material.SLIME_BALL);
        ItemMeta CobwebMeta = CobwebPerk.getItemMeta();
        CobwebMeta.setDisplayName("§aKlebrige Angelegenheit");
        ArrayList<String> lore1 = new ArrayList<>();
        lore1.add("");
        lore1.add("§7Mit der §aklebrigen Angelegenheit");
        lore1.add("§7Hast du eine kleine Chance, §fSpinnenweben");
        lore1.add("§7in deinem §cGegner §7zu spawnen, wenn du");
        lore1.add("§7Diesen schlägst!");
        CobwebMeta.setLore(lore1);
        if (stats.getPerks()[3]) {
            CobwebMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            CobwebMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        CobwebPerk.setItemMeta(CobwebMeta);
        return CobwebPerk;
    }

    //Bow - Perk
    private static ItemStack bowPerk(PlayerStats stats) {
        ItemStack BowPerk = new ItemStack(Material.CROSSBOW);
        ItemMeta BowMeta = BowPerk.getItemMeta();
        BowMeta.setDisplayName("§2Geübter Schütze");
        ArrayList<String> lore2 = new ArrayList<>();
        lore2.add("");
        lore2.add("§7Als §2geübter Schütze §7verursacht");
        lore2.add("§ajeder §7Pfeil, der deine §cGegner");
        lore2.add("§7trifft, für §910 Sekunden §7den Effekt");
        lore2.add("§5Slowness I§7.");
        BowMeta.setLore(lore2);
        if (stats.getPerks()[1]) {
            BowMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            BowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        BowPerk.setItemMeta(BowMeta);
        return BowPerk;
    }

    //Risk-Perk
    private static ItemStack riskPerk(PlayerStats stats) {

    ItemStack RiskPerk = new ItemStack(Material.GOLD_NUGGET);
    ItemMeta RiskMeta = RiskPerk.getItemMeta();
        RiskMeta.setDisplayName("§4Risikobehaftet");
    ArrayList<String> lore3 = new ArrayList<>();
        lore3.add("");
        lore3.add("§7Bist du §4risikobehaftet§7, so");
        lore3.add("§7erhältst du §ajedesmal §7wenn dein");
        lore3.add("§7Lowstes Piece unter 30 Dura fällt,");
        lore3.add("§7während du geschlagen wirst, für");
        lore3.add("§910 Sekunden §bSpeed I §7und §cStärke I§7.");
        RiskMeta.setLore(lore3);
        if(stats.getPerks()[2]){
            RiskMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            RiskMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        RiskPerk.setItemMeta(RiskMeta);
        return RiskPerk;
}

    //Spionagemeister
    private static ItemStack spyPerk(PlayerStats stats) {
        ItemStack InfoPerk = new ItemStack(Material.SPYGLASS);
        ItemMeta InfoMeta = InfoPerk.getItemMeta();
        InfoMeta.setDisplayName("§5Spionagemeister");
        ArrayList<String> lore6 = new ArrayList<>();
        lore6.add("");
        lore6.add("§7Mit dem §5Spionagemeister §7Perk");
        lore6.add("§7kannst du den §e/infobar §7Command");
        lore6.add("§7nutzen, und somit deine §6Infobar");
        lore6.add("§7modular §aanpassen §7und nutzen.");
        InfoMeta.setLore(lore6);
        if(stats.getPerks()[4]){
            InfoMeta.addEnchant(Enchantment.DURABILITY, 1, true);
            InfoMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        }
        InfoPerk.setItemMeta(InfoMeta);
        return InfoPerk;
    }


    public static Inventory overview(Player p, PlayerStats stats){
        Inventory Perks = Bukkit.createInventory(p, 36, "§c§lPerks");
        for(int i = 0; i <= 9; i++) {
            Perks.setItem(i, InventoryEssentials.glass());
        }

        //Cooming Soon
        ItemStack CS = new ItemStack(Material.BARRIER);
        ItemMeta meta = CS.getItemMeta();
        meta.setDisplayName("§c§l§oCooming Soon...");
        CS.setItemMeta(meta);
        Perks.setItem(16, CS);
        Perks.setItem(17, InventoryEssentials.glass());
        Perks.setItem(18, InventoryEssentials.glass());

        //Buyed
        ItemStack buyed = new ItemStack(Material.EMERALD);
        ItemMeta buyedMeta = buyed.getItemMeta();
        buyedMeta.setDisplayName("§a§lBereits gekauft!");
        ArrayList<String> lore4 = new ArrayList<>();
        lore4.add("");
        lore4.add("§7Du §abesitzt §7dieses Perk bereits.");
        lore4.add("§7dadurch ist es automatisch §aaktiv§7!");
        lore4.add("");
        buyedMeta.setLore(lore4);
        buyed.setItemMeta(buyedMeta);

        //toBuy
        ItemStack toBuy = new ItemStack(Material.GOLD_INGOT);
        ItemMeta toBuyMeta = toBuy.getItemMeta();
        toBuyMeta.setDisplayName("§6§lKaufen?");
        ArrayList<String> toBuyLore = new ArrayList<>();
        toBuyLore.add("");
        toBuyLore.add("§7Du besitzt dieses Perk noch §cnicht§7!");
        toBuyLore.add("§7Willst du es jetzt §6kaufen§7?");
        toBuyLore.add("");
        toBuyLore.add("");
        toBuyLore.add("");

        Perks.setItem(10, armorerPerk(stats));

        if(stats.getPerks()[0]){
            Perks.setItem(19, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §3Rüstungsfanatiker");
            toBuyLore.set(5, "§7Kosten: §e1000 §6✧");
            toBuyMeta.setLore(toBuyLore);
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 1000);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(19, toBuy);
        }

        if(stats.getPerks()[1]){
            Perks.setItem(20, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §2Geübter Schütze");
            toBuyLore.set(5, "§7Kosten: §e1300 §6✧");
            toBuyMeta.setLore(toBuyLore);
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 1300);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(20, toBuy);
        }
        Perks.setItem(11, bowPerk(stats));

        if(stats.getPerks()[2]){
            Perks.setItem(21, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §4Risikobehaftet");
            toBuyLore.set(5, "§7Kosten: §e1800 §6✧");
            toBuyMeta.setLore(toBuyLore);
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 1800);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(21, toBuy);
        }
        Perks.setItem(12, riskPerk(stats));

        if(stats.getPerks()[3]){
            Perks.setItem(22, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §aKlebrige Angelegenheit");
            toBuyLore.set(5, "§7Kosten: §e750 §6✧");
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 750);
            toBuyMeta.setLore(toBuyLore);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(22, toBuy);
        }
        Perks.setItem(13, cobwebPerk(stats));

        if(stats.getPerks()[4]){
            Perks.setItem(23, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §5Spionagemeister");
            toBuyLore.set(5, "§7Kosten: §e500 §6✧");
            toBuyMeta.setLore(toBuyLore);
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 500);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(23, toBuy);
        }
        Perks.setItem(14, spyPerk(stats));

        if(stats.getPerks()[5]){
            Perks.setItem(24, buyed);
        }else{
            toBuyLore.set(4, "§7Perk: §6Taschendieb");
            toBuyLore.set(5, "§7Kosten: §e2100 §6✧");
            toBuyMeta.setLore(toBuyLore);
            toBuyMeta.getPersistentDataContainer().set(new NamespacedKey(Main.getInstance(), "price"), PersistentDataType.INTEGER, 2100);
            toBuy.setItemMeta(toBuyMeta);
            Perks.setItem(24, toBuy);
        }
        Perks.setItem(15, thievePerk(stats));

        for(int i2 = 26; i2 <= 35; i2++){
            Perks.setItem(i2, InventoryEssentials.glass());
        }


        return Perks;
    }



    public static Inventory confirmBuy(Player p, ItemStack price){

        Component name = MiniMessage.miniMessage().deserialize("<rainbow>Kaufen?sfsdfsdfsfsdf</rainbow>");
        Inventory inventory = Bukkit.createInventory(p, 9, "§c§lPerk kaufen?");
        inventory.setItem(0, InventoryEssentials.glass());
        inventory.setItem(1, InventoryEssentials.glass());
        inventory.setItem(2, InventoryEssentials.back());
        inventory.setItem(3, InventoryEssentials.glass());
        inventory.setItem(4, price);
        inventory.setItem(5, InventoryEssentials.glass());
        inventory.setItem(6, InventoryEssentials.confirm());
        inventory.setItem(7, InventoryEssentials.glass());
        inventory.setItem(8, InventoryEssentials.glass());
        return inventory;
    }

}
