package jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerHitEvent implements Listener{

    @EventHandler
    public void hitEvent(EntityDamageEvent d){

            if(d.getEntity().getType() == EntityType.PLAYER){
                Player p = (Player) d.getEntity();
                if(p.getInventory().getBoots() != null && p.getInventory().getBoots().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getBoots().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4){
                    if(p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getChestplate().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4){
                        if(p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getLeggings().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4){
                            if(p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getItemMeta().hasEnchant(Enchantment.PROTECTION_ENVIRONMENTAL) && p.getInventory().getHelmet().getEnchantmentLevel(Enchantment.PROTECTION_ENVIRONMENTAL) == 4){
                                d.setDamage(EntityDamageEvent.DamageModifier.ARMOR, -1000);
                            }
                        }
                    }
                }
            }else{return;}


            }

        }



