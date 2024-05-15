package plugin.events.PlayerOrEntityEvents.Interactions;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataType;
import plugin.Main;
import plugin.cratesystem.CrateEntities.Crate;
import plugin.models.PlayerStats;
import plugin.utils.Scores.ScoreBoardBuilder;
import plugin.utils.essentials.PassiveHealing;

import java.sql.SQLException;
import java.util.Objects;

import static org.bukkit.Bukkit.getServer;


public class JoinEvent implements Listener {

    Main plugin;

    public JoinEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void joinEvent(PlayerJoinEvent event){

        this.plugin = Main.getInstance();

        Player player = event.getPlayer();

        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), () -> {
                PassiveHealing.start(player);
        }, 0,3 * 20);

        event.joinMessage(MiniMessage.miniMessage().deserialize("<hover:show_text:'<green>Serverjoin!'><dark_gray><<green>+<dark_gray>><reset> " + player.getName()));

        for (int i = 0; i < plugin.VanishList.size(); i++) {
            if (!player.isOp()) {
                player.hidePlayer(plugin, Objects.requireNonNull(Bukkit.getPlayer(plugin.VanishList.get(i))));
            }
        }
        if(plugin.VanishList.contains(player.getUniqueId())){
            player.setDisplayName(player.getPlayerListName() + " §5§lV");
        }

        if(Bukkit.getOnlinePlayers().size() == 1){

            getServer().getWorlds()
                    .forEach(world -> world.getEntitiesByClass(ArmorStand.class).stream()
                            .filter(entity -> (Objects.equals(entity.getCustomName(), "§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???")))
                            .forEach(Crate::startRotation)
                    );

        }

            try{
                PlayerStats stats = this.plugin.getDatabase().findPlayerStats(player);

                if(stats == null){

                    stats = new PlayerStats(player);
                    this.plugin.getDatabase().createPlayerStats(stats);

                }

                player.setScoreboard(ScoreBoardBuilder.Scoreboard(stats, player));
                for(Player p : Bukkit.getOnlinePlayers()){
                    Main.getInstance().getTablistManager().setTablist(p);
                }
                Main.getInstance().getTablistManager().setAllPlayerTeams();

            }catch (SQLException e){
                e.printStackTrace();
            }


    }
    }


