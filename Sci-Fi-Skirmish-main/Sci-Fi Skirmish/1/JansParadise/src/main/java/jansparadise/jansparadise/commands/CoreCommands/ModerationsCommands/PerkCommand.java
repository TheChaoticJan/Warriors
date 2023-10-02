package jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands;

import jansparadise.jansparadise.Main;
import jansparadise.jansparadise.models.PlayerStats;
import jansparadise.jansparadise.sonstiges.ItemBuilder.InventoryEssentials.Inventarteile;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PerkCommand implements CommandExecutor, TabCompleter {

    Main plugin;

    public PerkCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if(commandSender instanceof Player p){

            try{
                PlayerStats stats = this.plugin.getDatabase().findPlayerStatsByUUID(p.getUniqueId().toString());

                if(stats == null){
                    stats = new PlayerStats(p.getUniqueId().toString(), p.getName(), "", 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, "", false, false, false, false, false, 1,2, 3);
                    this.plugin.getDatabase().createPlayerStats(stats);
                }

                Inventory Perks = Bukkit.createInventory(p, 36, "§c§lPerks");
                     for(int i = 0; i <= 9; i++) {
                        Perks.setItem(i, Inventarteile.Glas());
                     }

                    //Armorer-Perk
                    ItemStack ArmorerPerk = new ItemStack(Material.LODESTONE);
                    ItemMeta ArmorerMeta = ArmorerPerk.getItemMeta();
                    ArmorerMeta.setDisplayName("§3§oRüstungsfanatiker");
                    ArrayList<String> lore = new ArrayList<>();
                    lore.add("");
                    lore.add("§7Mit dem §3Rüstungsfanatiker §7Perk");
                    lore.add("§7hast du eine kleine Chance, dass");
                    lore.add("§7dein §ckaputtestes Rüstungsteil");
                    lore.add("§7um 10 Haltbarkeit §arepariert wird§7!");
                    ArmorerMeta.setLore(lore);

                   //Cobweb-Perk
                   ItemStack CobwebPerk = new ItemStack(Material.SLIME_BALL);
                   ItemMeta CobwebMeta = CobwebPerk.getItemMeta();
                   CobwebMeta.setDisplayName("§a§oKlebrige Angelegenheit");
                   ArrayList <String> lore1 = new ArrayList<>();
                   lore1.add("");
                   lore1.add("§7Mit der §aklebrigen Angelegenheit");
                   lore1.add("§7Hast du eine kleine Chance, §fSpinnenweben");
                   lore1.add("§7in deinem §cGegner §7zu spawnen, wenn du");
                   lore1.add("§7Diesen schlägst!");
                   CobwebMeta.setLore(lore1);

                   //Bow - Perk
                   ItemStack BowPerk = new ItemStack(Material.CROSSBOW);
                   ItemMeta BowMeta = BowPerk.getItemMeta();
                   BowMeta.setDisplayName("§2§oGeübter Schütze");
                   ArrayList<String> lore2 = new ArrayList<>();
                   lore2.add("");
                   lore2.add("§7Als §2geübter Schütze §7verursacht");
                   lore2.add("§ajeder §7Pfeil, der deine §cGegner");
                   lore2.add("§7trifft, für §910 Sekunden §7den Effekt");
                   lore2.add("§5Slowness I§7.");
                   BowMeta.setLore(lore2);

                   //Risk-Perk
                   ItemStack RiskPerk = new ItemStack(Material.GOLD_NUGGET);
                   ItemMeta RiskMeta = RiskPerk.getItemMeta();
                   RiskMeta.setDisplayName("§4§oRisikobehaftet");
                   ArrayList<String> lore3 = new ArrayList<>();
                   lore3.add("");
                   lore3.add("§7Bist du §4risikobehaftet§7, so");
                   lore3.add("§7erhältst du §ajedesmal §7wenn dein");
                   lore3.add("§7Lowstes Piece unter 30 Dura fällt,");
                   lore3.add("§7während du geschlagen wirst, für");
                   lore3.add("§910 Sekunden §bSpeed II §7und §cStärke II§7.w     ");
                   RiskMeta.setLore(lore3);


                    //Cooming Soon
                    ItemStack CS = new ItemStack(Material.BARRIER);
                    ItemMeta meta = CS.getItemMeta();
                    meta.setDisplayName("§c§l§oCooming Soon...");
                    CS.setItemMeta(meta);
                    for(int i1 = 15; i1 <= 16; i1++){
                        Perks.setItem(i1, CS);
                    }
                    Perks.setItem(17, Inventarteile.Glas());
                    Perks.setItem(18, Inventarteile.Glas());

                    //Buyed
                    ItemStack buyed = new ItemStack(Material.EMERALD);
                    ItemMeta buyedMeta = buyed.getItemMeta();
                    buyedMeta.setDisplayName("§a§lBereits gekauft!");
                    ArrayList<String> lore4 = new ArrayList<>();
                    lore4.add("");
                    lore4.add("§7Du §abesitzt §7dieses Perk bereits.");
                    lore4.add("§7Dadurch ist es automatisch §aaktiv§7!");
                    lore4.add("");
                    buyedMeta.setLore(lore4);
                    buyed.setItemMeta(buyedMeta);

                    //toBuy
                    ItemStack toBuy = new ItemStack(Material.GOLD_INGOT);
                    ItemMeta toBuyMeta = toBuy.getItemMeta();
                    toBuyMeta.setDisplayName("§6§lKaufen?");
                    ArrayList<String> lore5 = new ArrayList<>();
                    lore5.add("");
                    lore5.add("§7Du besitzt dieses Perk noch §cnicht§7!");
                    lore5.add("§7Willst du es jetzt §6kaufen§7?");
                    lore5.add("");

                    Boolean b1 = stats.getPerk1();
                    if(b1){
                        ArmorerMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        ArmorerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        ArmorerPerk.setItemMeta(ArmorerMeta);
                        Perks.setItem(19, buyed);
                    }else{
                        ArmorerPerk.setItemMeta(ArmorerMeta);
                        lore5.add(3, "§7Kosten: §e750 §6✧");
                        toBuyMeta.setLore(lore5);
                        toBuy.setItemMeta(toBuyMeta);
                        Perks.setItem(19, toBuy);
                        lore5.remove(3);
                    }
                     Perks.setItem(10, ArmorerPerk);

                    Boolean b2 = stats.getPerk2();
                    if(b2){
                        BowMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        BowMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        BowPerk.setItemMeta(BowMeta);
                        Perks.setItem(20, buyed);
                    }else{
                        BowPerk.setItemMeta(BowMeta);
                        lore5.add(3, "§7Kosten: §e850 §6✧");
                        toBuyMeta.setLore(lore5);
                        toBuy.setItemMeta(toBuyMeta);
                        Perks.setItem(20, toBuy);
                        lore5.remove(3);
                    }
                     Perks.setItem(11, BowPerk);


                    Boolean b3 = stats.getPerk3();
                    if(b3){
                        RiskMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        RiskMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        RiskPerk.setItemMeta(RiskMeta);
                        Perks.setItem(21, buyed);
                    }else{
                        RiskPerk.setItemMeta(RiskMeta);
                        lore5.add(3, "§7Kosten: §e1000 §6✧");
                        toBuyMeta.setLore(lore5);
                        toBuy.setItemMeta(toBuyMeta);
                        Perks.setItem(21, toBuy);
                        lore5.remove(3);
                    }
                     Perks.setItem(12, RiskPerk);


                    Boolean b4 = stats.getPerk4();
                    if(b4){
                        CobwebMeta.addEnchant(Enchantment.DURABILITY, 1, true);
                        CobwebMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                        CobwebPerk.setItemMeta(CobwebMeta);
                        Perks.setItem(22, buyed);
                    }else{
                        CobwebPerk.setItemMeta(CobwebMeta);
                        lore5.add(3, "§7Kosten: §e1200 §6✧");
                        toBuyMeta.setLore(lore5);
                        toBuy.setItemMeta(toBuyMeta);
                        Perks.setItem(22, toBuy);
                        lore5.remove(3);
                    }
                     Perks.setItem(13, CobwebPerk);

                    Boolean b5 = stats.getPerk5();



                    for(int i2 = 26; i2 <= 35; i2++){
                        Perks.setItem(i2, Inventarteile.Glas());
                    }

                p.openInventory(Perks);

            }catch (SQLException e){
                e.printStackTrace();
            }


        }

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
