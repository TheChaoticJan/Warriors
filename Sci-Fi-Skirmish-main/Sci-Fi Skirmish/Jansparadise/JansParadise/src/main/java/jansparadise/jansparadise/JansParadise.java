package jansparadise.jansparadise;


import jansparadise.jansparadise.LootSystem.CrateEntities.ArmorstandRotation;
import jansparadise.jansparadise.LootSystem.CrateEntities.CrateHitEvent;
import jansparadise.jansparadise.commands.CoreCommands.*;
import jansparadise.jansparadise.commands.InventoryCommands.GUIs.RezepteCommand;
import jansparadise.jansparadise.commands.InventoryCommands.SpecialitemCommand;
import jansparadise.jansparadise.commands.InventoryCommands.TrashCommand;
import jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands.PerkCommand;
import jansparadise.jansparadise.commands.QoLCommands.*;
import jansparadise.jansparadise.events.InventoryEvents.ClickEvent;
import jansparadise.jansparadise.events.InventoryEvents.Rezepte.RezeptClickEvent;
import jansparadise.jansparadise.LootSystem.CrateEntities.CrateDeathEvent;
import jansparadise.jansparadise.LootSystem.CrateEntities.RightClickEvent;
import jansparadise.jansparadise.commands.CoreCommands.ModerationsCommands.*;
import jansparadise.jansparadise.commands.FunCommands.*;
import jansparadise.jansparadise.commands.InventoryCommands.GUIs.KitCommand;
import jansparadise.jansparadise.commands.InventoryCommands.AnvilCommand;
import jansparadise.jansparadise.commands.InventoryCommands.EnderchestCommand;
import jansparadise.jansparadise.db.Database;
import jansparadise.jansparadise.events.BlockEvents.BlockBreakEvent;
import jansparadise.jansparadise.events.BlockEvents.BlockPlacedEvent;
import jansparadise.jansparadise.events.ExplosionEvents.ExplodeEvent;
import jansparadise.jansparadise.events.PlayerOrEntityEvents.*;
import jansparadise.jansparadise.events.PlayerOrEntityEvents.PvPEvents.*;
import jansparadise.jansparadise.sonstiges.RecipeBuilder.Erfahrenrezepte;
import jansparadise.jansparadise.sonstiges.RecipeBuilder.ExplosivRezepte;
import jansparadise.jansparadise.sonstiges.RecipeBuilder.KlebrigRezepte;
import jansparadise.jansparadise.sonstiges.RecipeBuilder.SciFiRezepte;
import jansparadise.jansparadise.sonstiges.tablist.TablistManager;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;
import java.util.ArrayList;

public final class JansParadise extends JavaPlugin {

    private TablistManager tablistManager;

    public static JansParadise instance;

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
                                .forEach(entity -> ArmorstandRotation.Rotation(entity))
                        );



        

        //recepies
        //Erfahrerezepte
        Bukkit.addRecipe(Erfahrenrezepte.Recipe1());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe2());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe3());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe4());
        Bukkit.addRecipe(Erfahrenrezepte.Recipe5());

        //Sci-Fi Rezepte
        Bukkit.addRecipe(SciFiRezepte.Recipe1());
        Bukkit.addRecipe(SciFiRezepte.Recipe2());
        Bukkit.addRecipe(SciFiRezepte.Recipe3());
        Bukkit.addRecipe(SciFiRezepte.Recipe4());
        Bukkit.addRecipe(SciFiRezepte.Recipe5());
        Bukkit.addRecipe(SciFiRezepte.Recipe6());

        //KlebrigRezepte
        Bukkit.addRecipe(KlebrigRezepte.Recipe1());
        Bukkit.addRecipe(KlebrigRezepte.Recipe2());
        Bukkit.addRecipe(KlebrigRezepte.Recipe3());
        Bukkit.addRecipe(KlebrigRezepte.Recipe4());
        Bukkit.addRecipe(KlebrigRezepte.Recipe5());

        //ExplosivRezepte
        Bukkit.addRecipe(ExplosivRezepte.Recipe1());
        Bukkit.addRecipe(ExplosivRezepte.Recipe2());
        Bukkit.addRecipe(ExplosivRezepte.Recipe3());
        Bukkit.addRecipe(ExplosivRezepte.Recipe4());

        //events
        getServer().getPluginManager().registerEvents((Listener) new ClickEvent(), this);
        getServer().getPluginManager().registerEvents((Listener) new MoveEvent(), this );
        getServer().getPluginManager().registerEvents((Listener) new BlockPlacedEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new PlayerHitEvent(), this );
        getServer().getPluginManager().registerEvents((Listener) new ExplodeEvent(), this );
        getServer().getPluginManager().registerEvents((Listener) new RodEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new PlayerReceiveDamageEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new InventoryChangeEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new BlockBreakEvent(), this );
        getServer().getPluginManager().registerEvents((Listener) new JoinEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new ChatEvent(), this );
        getServer().getPluginManager().registerEvents((Listener) new BowEvent(this), this );
        getServer().getPluginManager().registerEvents((Listener) new PlayerDeathEvent(this), this);
        getServer().getPluginManager().registerEvents((Listener) new CrateDeathEvent(this), this);
        getServer().getPluginManager().registerEvents((Listener) new RightClickEvent(this), this);
        getServer().getPluginManager().registerEvents((Listener) new RezeptClickEvent(), this);
        getServer().getPluginManager().registerEvents((Listener) new DropEvent(), this);
        getServer().getPluginManager().registerEvents((Listener) new PlayerFishingEvent(), this);
        getServer().getPluginManager().registerEvents((Listener) new CrateHitEvent(), this);



        //commands
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("fly").setExecutor((CommandExecutor) new FlyCommand());
        getCommand("feed").setExecutor((CommandExecutor) new FeedCommand());
        getCommand("kit").setExecutor((CommandExecutor) new KitCommand());
        getCommand("sign").setExecutor((CommandExecutor) new SignCommand());
        getCommand("fix").setExecutor((CommandExecutor) new FixCommand());
        getCommand("uwu").setExecutor((CommandExecutor) new UwUCommand(this));
        getCommand("invsee").setExecutor((CommandExecutor) new InvseeCommand(this));
        getCommand("spawn").setExecutor((CommandExecutor) new SpawnCommand());
        getCommand("ec").setExecutor((CommandExecutor) new EnderchestCommand());
        getCommand("workbench").setExecutor((CommandExecutor) new WorkbenchCommand());
        getCommand("anvil").setExecutor((CommandExecutor) new AnvilCommand());
        getCommand("specialitems").setExecutor((CommandExecutor) new SpecialitemCommand());
        getCommand("vanish").setExecutor((CommandExecutor) new VanishCommand(this));
        getCommand("rezepte").setExecutor((CommandExecutor)  new RezepteCommand());
        getCommand("playerinfo").setExecutor((CommandExecutor) new InfoCommand());
        getCommand("xp").setExecutor((CommandExecutor) new XPCommand(this));
        getCommand("trade").setExecutor((CommandExecutor) new TradeCommand(this));
        getCommand("rezept").setExecutor((CommandExecutor) new RezeptCommand());
        getCommand("trash").setExecutor((CommandExecutor) new TrashCommand());
        getCommand("modify").setExecutor((CommandExecutor) new ModifyCommand());
        getCommand("cratestats").setExecutor((CommandExecutor) new CrateStatsCommand(this));
        getCommand("top").setExecutor((CommandExecutor) new TopCommand(this));
        getCommand("perks").setExecutor((CommandExecutor) new PerkCommand(this));
        getCommand("infobar").setExecutor((CommandExecutor) new InfobarCommand(this));


    }
    public static JansParadise getInstance(){
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

