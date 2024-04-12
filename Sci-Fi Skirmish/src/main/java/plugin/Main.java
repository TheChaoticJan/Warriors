package plugin;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.commands.DatabaseUsing.PerkCommand;
import plugin.commands.DatabaseUsing.StatsCommand;
import plugin.commands.DatabaseUsing.TopCommand;
import plugin.commands.DatabaseUsing.XPCommand;
import plugin.commands.FunCommands.SignCommand;
import plugin.commands.FunCommands.UwUCommand;
import plugin.commands.InventoryCommands.CommonInventories.*;
import plugin.commands.InventoryCommands.GUIs.KitCommand;
import plugin.commands.InventoryCommands.GUIs.RezeptCommand;
import plugin.commands.InventoryCommands.GUIs.RezepteCommand;
import plugin.commands.InventoryCommands.GUIs.SpecialitemCommand;
import plugin.commands.ModerationsCommands.InvseeCommand;
import plugin.commands.ModerationsCommands.VanishCommand;
import plugin.commands.QoLCommands.FixCommand;
import plugin.commands.QoLCommands.HealCommand;
import plugin.commands.QoLCommands.ModifyCommand;
import plugin.commands.QoLCommands.SpawnCommand;
import plugin.cratesystem.CrateEntities.Crate;
import plugin.cratesystem.CrateEntities.CrateDeathEvent;
import plugin.cratesystem.CrateEntities.CrateHitEvent;
import plugin.cratesystem.SpawnCrateCommand;
import plugin.database.Database;
import plugin.events.BlockEvents.BlockEvents;
import plugin.events.ExplosionEvents.ExplodeEvent;
import plugin.events.InventoryEvents.CandleClickEvent;
import plugin.events.InventoryEvents.ClickEvent;
import plugin.events.InventoryEvents.InfobarClick;
import plugin.events.InventoryEvents.PerkClickEvent;
import plugin.events.InventoryEvents.Rezepte.RezeptClickEvent;
import plugin.events.PlayerOrEntityEvents.interactions.*;
import plugin.events.PlayerOrEntityEvents.PvP.*;
import plugin.events.PlayerOrEntityEvents.interactions.chatevents.ChatEvent;
import plugin.infobar.InfobarCommand;
import plugin.utils.Recipes.*;
import plugin.utils.Scores.ScoreBoardBuilder;
import plugin.utils.Scores.TablistManager;
import plugin.utils.essentials.PassiveHealing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;
public final class Main extends JavaPlugin{

    private TablistManager tablistManager;
    private static @Getter Main instance;
    public ArrayList<UUID> VanishList = new ArrayList<>();
    public TablistManager getTablistManager() {
        return tablistManager;
    }
    private static @Getter Database database;


    @Override
    public void onEnable() {

        tablistManager = new TablistManager(this);

        instance = this;

        try{
            database = new Database();
            database.initiliazeDatabase();

        }catch (SQLException e){
            System.out.println("\u001B[31m Konnte sich nicht mit der Datenbank verbinden!");
            System.out.println("\u001B[31m Mögliche Quellen: Falsche Tabellen, Datenbank abgeschalten");
            e.printStackTrace();
        }
        getServer().getWorlds()
                .forEach(world -> world.getEntitiesByClass(ArmorStand.class).stream().
                                filter(entity -> (Objects.equals(entity.getCustomName(), "§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???")))
                                .forEach(Crate::startRotation)
                        );

        getServer().getOnlinePlayers().forEach(player -> Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                PassiveHealing.start(player);
            }
        }, 0, 3 * 20));

        getServer().getOnlinePlayers().forEach(player -> {
            try {
                player.setScoreboard(ScoreBoardBuilder.Scoreboard(getDatabase().findPlayerStatsByUUID(String.valueOf(player.getUniqueId())), player));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });

        //Adding all Special Recipes (Sci-Fi, Erfahren, Klebrig & Explosiv)
        Bukkit.addRecipe(Erfahrenrezepte.Recipe1());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe2());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe3());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe4());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe5());
        Bukkit.addRecipe(SciFiRezepte.Recipe1());
        Bukkit.addRecipe(SciFiRezepte.Recipe2());
        Bukkit.addRecipe(SciFiRezepte.Recipe3());
        Bukkit.addRecipe(SciFiRezepte.Recipe4());
        Bukkit.addRecipe(SciFiRezepte.Recipe6());
        Bukkit.addRecipe(KlebrigRezepte.Recipe1());
        Bukkit.addRecipe(KlebrigRezepte.Recipe2());
        Bukkit.addRecipe(KlebrigRezepte.Recipe3());
        Bukkit.addRecipe(KlebrigRezepte.Recipe4());
        Bukkit.addRecipe(KlebrigRezepte.Recipe5());
        Bukkit.addRecipe(ExplosivRezepte.Recipe1());
        Bukkit.addRecipe(ExplosivRezepte.Recipe2());
        Bukkit.addRecipe(ExplosivRezepte.Recipe3());
        Bukkit.addRecipe(ExplosivRezepte.Recipe4());
        Bukkit.addRecipe(CandleRecipes.healCandle());
        Bukkit.addRecipe(CandleRecipes.boostCandle());
        Bukkit.addRecipe(CandleRecipes.crateCandle());
        Bukkit.addRecipe(CandleRecipes.teleportCandle());
        Bukkit.addRecipe(CandleRecipes.superRecipe());

        //events
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockEvents(this), this );
        getServer().getPluginManager().registerEvents(new ExplodeEvent(), this );
        getServer().getPluginManager().registerEvents(new PlayerGetHitEvent(this), this );
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this );
        getServer().getPluginManager().registerEvents(new ChatEvent(), this );
        getServer().getPluginManager().registerEvents(new ProjectileHitEvent(this), this );
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new CrateDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new RightClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new RezeptClickEvent(), this);
        getServer().getPluginManager().registerEvents(new DropEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEvent(), this);
        getServer().getPluginManager().registerEvents(new CrateHitEvent(), this);
        getServer().getPluginManager().registerEvents(new InfobarClick(this), this);
        getServer().getPluginManager().registerEvents(new PerkClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new AnvilEvent(), this);
        getServer().getPluginManager().registerEvents(new CandleClickEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerRepairEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);

        //commands
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("kit")).setExecutor(new KitCommand());
        Objects.requireNonNull(getCommand("sign")).setExecutor(new SignCommand());
        Objects.requireNonNull(getCommand("fix")).setExecutor(new FixCommand());
        Objects.requireNonNull(getCommand("uwu")).setExecutor(new UwUCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvseeCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EnderchestCommand());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new WorkbenchCommand());
        Objects.requireNonNull(getCommand("anvil")).setExecutor(new AnvilCommand());
        Objects.requireNonNull(getCommand("specialitems")).setExecutor(new SpecialitemCommand());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCommand(this));
        Objects.requireNonNull(getCommand("rezepte")).setExecutor(new RezepteCommand());
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand(this));
        Objects.requireNonNull(getCommand("xp")).setExecutor(new XPCommand(this));
        Objects.requireNonNull(getCommand("rezept")).setExecutor(new RezeptCommand());
        Objects.requireNonNull(getCommand("trash")).setExecutor(new TrashCommand());
        Objects.requireNonNull(getCommand("modify")).setExecutor(new ModifyCommand());
        Objects.requireNonNull(getCommand("top")).setExecutor(new TopCommand(this));
        Objects.requireNonNull(getCommand("perks")).setExecutor(new PerkCommand());
        Objects.requireNonNull(getCommand("infobar")).setExecutor(new InfobarCommand(this));
        Objects.requireNonNull(getCommand("crate")).setExecutor(new SpawnCrateCommand());
        Objects.requireNonNull(getCommand("smithingtable")).setExecutor(new SmithingTableCommand());


    }

    @Override
    public void onDisable() {

        for(Block block : BlockEvents.blocks){
            block.setType(Material.AIR);
        }

    }
}

