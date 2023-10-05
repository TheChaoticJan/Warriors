package plugin;

import plugin.commands.InventoryCommands.GUIs.RezeptCommand;
import plugin.sonstiges.Infobar.InfobarCommand;
import plugin.LootSystem.CrateEntities.CrateHitEvent;
import plugin.LootSystem.CrateEntities.Crates;
import plugin.commands.DatabaseUsing.CrateStatsCommand;
import plugin.commands.DatabaseUsing.TopCommand;
import plugin.commands.DatabaseUsing.XPCommand;
import plugin.commands.InventoryCommands.GUIs.RezepteCommand;
import plugin.commands.InventoryCommands.GUIs.SpecialitemCommand;
import plugin.commands.InventoryCommands.CommonInventories.TrashCommand;
import plugin.commands.DatabaseUsing.PerkCommand;
import plugin.commands.QoLCommands.*;
import plugin.events.InventoryEvents.ClickEvent;
import plugin.events.InventoryEvents.InfobarClick;
import plugin.events.InventoryEvents.Rezepte.RezeptClickEvent;
import plugin.LootSystem.CrateEntities.CrateDeathEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.ChatEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.DropEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.JoinEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.RightClickEvent;
import plugin.commands.ModerationsCommands.*;
import plugin.commands.FunCommands.*;
import plugin.commands.InventoryCommands.GUIs.KitCommand;
import plugin.commands.InventoryCommands.CommonInventories.AnvilCommand;
import plugin.commands.InventoryCommands.CommonInventories.EnderchestCommand;
import plugin.db.Database;
import plugin.events.BlockEvents.BlockBreakEvent;
import plugin.events.BlockEvents.BlockPlacedEvent;
import plugin.events.ExplosionEvents.ExplodeEvent;
import plugin.events.PlayerOrEntityEvents.PvP.*;
import plugin.sonstiges.Recipes.Erfahrenrezepte;
import plugin.sonstiges.Recipes.ExplosivRezepte;
import plugin.sonstiges.Recipes.KlebrigRezepte;
import plugin.sonstiges.Recipes.SciFiRezepte;
import plugin.sonstiges.Scores.TablistManager;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;

public final class Main extends JavaPlugin {

    private TablistManager tablistManager;
    public static Main instance;
    public ArrayList<Player> VanishList = new ArrayList<>();
    public TablistManager getTablistManager() {
        return tablistManager;
    }
    private Database database;

    @Override
    public void onEnable() {

        tablistManager = new TablistManager(this);

        instance = this;

        try{
            this.database = new Database();
            database.initiliazeDatabase();

        }catch (SQLException e){
            System.out.println("Unable to connect to Database and crate Tables");
            e.printStackTrace();
        }
        
                getServer().getWorlds()
                        .forEach(world -> world.getEntitiesByClass(ArmorStand.class).stream()
                                .filter(entity -> (entity.getCustomName().equals("§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???")))
                                .forEach(Crates::startRotation)
                        );


        //Adding all Special Recipes (Sci-Fi, Erfahren, Klebrig & Explosiv)
        Bukkit.addRecipe(Erfahrenrezepte.Recipe1());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe2());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe3());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe4());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe5());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe6());
        Bukkit.addRecipe(SciFiRezepte.Recipe1());
        Bukkit.addRecipe(SciFiRezepte.Recipe2());
        Bukkit.addRecipe(SciFiRezepte.Recipe3());
        Bukkit.addRecipe(SciFiRezepte.Recipe4());
        Bukkit.addRecipe(SciFiRezepte.Recipe5());
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

        //events
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockPlacedEvent(this), this );
        getServer().getPluginManager().registerEvents(new ExplodeEvent(), this );
        getServer().getPluginManager().registerEvents(new PlayerGetHitEvent(this), this );
        getServer().getPluginManager().registerEvents(new BlockBreakEvent(), this );
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this );
        getServer().getPluginManager().registerEvents(new ChatEvent(), this );
        getServer().getPluginManager().registerEvents(new ProjectileHitEvent(this), this );
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new CrateDeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new RightClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new RezeptClickEvent(), this);
        getServer().getPluginManager().registerEvents(new DropEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEvent(), this);
        getServer().getPluginManager().registerEvents(new CrateHitEvent(), this);
        getServer().getPluginManager().registerEvents(new InfobarClick(this), this);


        //commands
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("kit").setExecutor(new KitCommand());
        getCommand("sign").setExecutor(new SignCommand());
        getCommand("fix").setExecutor(new FixCommand());
        getCommand("uwu").setExecutor(new UwUCommand(this));
        getCommand("invsee").setExecutor(new InvseeCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("ec").setExecutor(new EnderchestCommand());
        getCommand("workbench").setExecutor(new WorkbenchCommand());
        getCommand("anvil").setExecutor(new AnvilCommand());
        getCommand("specialitems").setExecutor(new SpecialitemCommand());
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("rezepte").setExecutor(new RezepteCommand());
        getCommand("playerinfo").setExecutor(new InfoCommand());
        getCommand("xp").setExecutor(new XPCommand(this));
        getCommand("rezept").setExecutor(new RezeptCommand());
        getCommand("trash").setExecutor(new TrashCommand());
        getCommand("modify").setExecutor(new ModifyCommand());
        getCommand("cratestats").setExecutor(new CrateStatsCommand(this));
        getCommand("top").setExecutor(new TopCommand(this));
        getCommand("perks").setExecutor(new PerkCommand(this));
        getCommand("infobar").setExecutor(new InfobarCommand(this));

    }

    public static Main getInstance(){
        return instance;
    }
    public Database getDatabase() {
        return database;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

