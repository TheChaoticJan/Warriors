package jansparadise.jansparadise.events.InventoryEvents.Rezepte;

import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.ErfahrenRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.ExplosivRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.KlebrigRezeptInventare;
import jansparadise.jansparadise.sonstiges.InventoryBuilder.Rezepte.SciFiRezeptInventare;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class RezeptClickEvent implements Listener{

    @EventHandler
    public void ClickEvent(InventoryClickEvent e){

        if(e.getCurrentItem() == null){
            return;
        }

        if(e.getCurrentItem().getItemMeta() == null){
            return;
        }


        if(e.getCurrentItem().getType().equals(Material.WHITE_STAINED_GLASS_PANE) || e.getCurrentItem().getItemMeta().getDisplayName().startsWith("§e")){
            e.setCancelled(true);
        }
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle() == "§x§F§F§5§9§F§4R§x§F§4§5§8§F§6e§x§E§9§5§6§F§8z§x§D§E§5§5§F§Ae§x§D§3§5§4§F§Bp§x§C§8§5§2§F§Dt§x§B§D§5§1§F§Fe"){
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§8§D§F§F§lZ§x§2§6§6§E§F§F§la§x§4§B§4§E§F§F§lu§x§7§1§2§F§F§F§lb§x§9§6§1§0§F§F§le§x§A§C§0§1§F§E§lr§x§B§3§0§4§F§D§ls§x§B§9§0§6§F§C§lt§x§C§0§0§9§F§A§la§x§C§6§0§B§F§9§lb §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka")){
                p.openInventory(SciFiRezeptInventare.Zauberstab(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§0§0§8§D§F§F§lS§x§1§6§6§5§F§F§li§x§2§B§3§C§F§F§ll§x§4§1§1§4§F§F§le§x§5§D§0§2§F§E§ln§x§8§0§0§5§F§C§lc§x§A§3§0§8§F§B§le§x§C§6§0§B§F§9§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka")){

                p.openInventory(SciFiRezeptInventare.Schwert(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§2§D§9§6§D§D§lG§x§3§F§8§0§D§7§le§x§5§2§6§9§D§1§lw§x§7§0§4§B§C§C§le§x§9§9§2§6§C§9§lh§x§C§3§0§0§C§5§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka")){

                p.openInventory(SciFiRezeptInventare.Bogen(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§C§6§0§B§F§9§ka§x§0§0§8§D§F§F§ka §8§l[§x§0§0§8§D§F§F§lS§x§1§E§5§5§F§F§lc§x§3§D§1§C§F§F§li§x§6§4§0§2§F§E§l-§x§9§5§0§7§F§B§lF§x§C§6§0§B§F§9§li§8§l] §x§2§D§9§6§D§D§lZ§x§3§9§8§8§D§9§le§x§4§4§7§A§D§6§lr§x§5§0§6§C§D§2§lh§x§5§B§5§E§C§E§la§x§7§5§4§7§C§C§lc§x§8§F§2§F§C§A§lk§x§A§9§1§8§C§7§le§x§C§3§0§0§C§5§lr §x§0§0§8§D§F§F§ka§x§C§6§0§B§F§9§ka")){

                p.openInventory(SciFiRezeptInventare.Axt(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lK§x§E§2§D§7§7§4§la§x§D§9§D§6§6§C§lt§x§D§0§D§6§6§5§la§x§C§7§D§5§5§D§ln§x§B§E§D§5§5§6§la §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka")){

                p.openInventory(ErfahrenRezeptInventare.Schwert(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lZ§x§E§7§D§7§7§8§lu§x§E§4§D§7§7§5§lr§x§E§0§D§7§7§2§le§x§D§C§D§6§6§F§lc§x§D§8§D§6§6§C§lh§x§D§5§D§6§6§9§lt§x§D§1§D§6§6§5§lw§x§C§D§D§6§6§2§le§x§C§9§D§6§5§F§li§x§C§6§D§5§5§C§ls§x§C§2§D§5§5§9§le§x§B§E§D§5§5§6§lr §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka")){

                p.openInventory(ErfahrenRezeptInventare.Bogen(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§E§B§D§7§7§B§ka§x§B§E§D§5§5§6§ka §8§l[§x§E§B§D§7§7§B§lE§x§E§5§D§7§7§6§lr§x§D§E§D§6§7§0§lf§x§D§8§D§6§6§B§la§x§D§1§D§6§6§6§lh§x§C§B§D§6§6§1§lr§x§C§4§D§5§5§B§le§x§B§E§D§5§5§6§ln§8§l] §x§E§B§D§7§7§B§lB§x§D§C§D§6§6§F§le§x§C§D§D§6§6§2§li§x§B§E§D§5§5§6§ll §x§B§E§D§5§5§6§ka§x§E§B§D§7§7§B§ka")){

                p.openInventory(ErfahrenRezeptInventare.Axt(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§7§5§8i§x§F§F§D§2§5§7s§x§F§F§C§D§5§6e§x§F§F§C§7§5§5n§x§F§F§C§2§5§5b§x§F§F§B§C§5§4a§x§F§F§B§7§5§3r§x§F§F§B§2§5§2r§x§F§F§A§C§5§2e§x§F§F§A§7§5§1n")){

                p.openInventory(ErfahrenRezeptInventare.Barren(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§F§F§E§2§5§9W§x§F§F§D§D§5§8e§x§F§F§D§9§5§8i§x§F§F§D§4§5§7s§x§F§F§D§0§5§7e§x§F§F§C§B§5§6n§x§F§F§C§7§5§5f§x§F§F§C§2§5§5r§x§F§F§B§E§5§4a§x§F§F§B§9§5§3g§x§F§F§B§5§5§3m§x§F§F§B§0§5§2e§x§F§F§A§C§5§2n§x§F§F§A§7§5§1t")){

                p.openInventory(ErfahrenRezeptInventare.Fragment(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FK§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fi§x§5§3§C§2§F§Fs§x§5§3§B§C§F§Ft§x§5§2§B§6§F§Fa§x§5§2§B§0§F§Fl§x§5§1§A§A§F§Fl")){

                p.openInventory(SciFiRezeptInventare.Barren(p, e, null));
                e.setCancelled(true);
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§5§9§F§8§F§FS§x§5§8§F§2§F§Fc§x§5§8§E§C§F§Fi§x§5§7§E§6§F§F-§x§5§7§E§0§F§FF§x§5§6§D§A§F§Fi §x§5§5§D§4§F§FF§x§5§5§C§E§F§Fr§x§5§4§C§8§F§Fa§x§5§3§C§2§F§Fg§x§5§3§B§C§F§Fm§x§5§2§B§6§F§Fe§x§5§2§B§0§F§Fn§x§5§1§A§A§F§Ft")){

                p.openInventory(SciFiRezeptInventare.Fragment(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§F§F§0§0§0§0E§x§F§5§0§3§0§1x§x§E§B§0§7§0§3p§x§E§1§0§A§0§4l§x§D§7§0§E§0§6o§x§C§D§1§1§0§7s§x§C§4§1§5§0§9i§x§B§A§1§8§0§Av§x§B§0§1§B§0§Bp§x§A§6§1§F§0§Du§x§9§C§2§2§0§Ed§x§9§2§2§6§1§0e§x§8§8§2§9§1§1r")){

                p.openInventory(ExplosivRezeptInventare.Fragment(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§F§F§0§0§0§0E§x§F§6§0§3§0§1x§x§E§D§0§6§0§3p§x§E§4§0§9§0§4l§x§D§A§0§D§0§5o§x§D§1§1§0§0§7s§x§C§8§1§3§0§8i§x§B§F§1§6§0§9v§x§B§6§1§9§0§Ab§x§A§D§1§C§0§Ca§x§A§3§2§0§0§Dr§x§9§A§2§3§0§Er§x§9§1§2§6§1§0e§x§8§8§2§9§1§1n")){

                p.openInventory(ExplosivRezeptInventare.Barren(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§0§0§F§F§1§1K§x§0§3§F§5§1§2l§x§0§5§E§B§1§2e§x§0§8§E§1§1§3b§x§0§A§D§8§1§4r§x§0§D§C§E§1§4i§x§0§F§C§4§1§5g§x§1§2§B§A§1§6e§x§1§4§B§0§1§6r §x§1§7§A§6§1§7S§x§1§9§9§C§1§8c§x§1§C§9§2§1§8h§x§1§E§8§9§1§9l§x§2§1§7§F§1§Ae§x§2§3§7§5§1§Ai§x§2§6§6§B§1§Bm")){

                p.openInventory(KlebrigRezeptInventare.Fragment(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§0§0§F§F§1§1K§x§0§2§F§6§1§2l§x§0§5§E§D§1§2e§x§0§7§E§3§1§3b§x§0§A§D§A§1§4r§x§0§C§D§1§1§4i§x§0§E§C§8§1§5g§x§1§1§B§E§1§5e§x§1§3§B§5§1§6r §x§1§5§A§C§1§7K§x§1§8§A§3§1§7r§x§1§A§9§9§1§8i§x§1§D§9§0§1§9s§x§1§F§8§7§1§9t§x§2§1§7§E§1§Aa§x§2§4§7§4§1§Al§x§2§6§6§B§1§Bl")){

                p.openInventory(KlebrigRezeptInventare.Barren(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§x§5§A§D§D§2§D§ka§x§4§0§A§A§1§C§ka §8§l[§x§5§A§D§D§2§D§lK§x§5§8§C§5§2§5§ll§x§5§7§A§C§1§E§le§x§5§5§9§4§1§6§lb§x§4§E§9§B§1§8§lr§x§4§7§A§3§1§A§li§x§4§0§A§A§1§C§lg§8§l] §x§5§A§D§D§2§D§lS§x§5§9§C§D§2§8§lu§x§5§8§B§D§2§3§lm§x§5§7§A§C§1§E§lp§x§5§6§9§C§1§9§lf§x§5§3§9§6§1§7§la§x§4§E§9§B§1§8§ln§x§4§9§A§0§1§9§lg§x§4§5§A§5§1§B§le§x§4§0§A§A§1§C§ll §x§4§0§A§A§1§C§ka§x§5§A§D§D§2§D§ka")){

                p.openInventory(KlebrigRezeptInventare.Angel(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getLore().contains("§eExplosiv") && e.getCurrentItem().getType().equals(Material.FISHING_ROD)){

                p.openInventory(ExplosivRezeptInventare.Angel(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getLore().contains("§eExplosiv") && e.getCurrentItem().getType().equals(Material.DIAMOND_PICKAXE)){

                p.openInventory(ExplosivRezeptInventare.Picke(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getLore().contains("§eKlebrig") && e.getCurrentItem().getType().equals(Material.DIAMOND_SWORD)){

                p.openInventory(KlebrigRezeptInventare.Schwert(p, e, null));
                e.setCancelled(true);
            }

            if(e.getCurrentItem().getItemMeta().getLore().contains("§eKlebrig") && e.getCurrentItem().getType().equals(Material.BOW)){

                p.openInventory(KlebrigRezeptInventare.Bogen(p, e, null));
                e.setCancelled(true);
            }
            e.setCancelled(true);
        }
    }
}
