package plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.LootSystem.CrateEntities.CrateDeathEvent;
import plugin.LootSystem.CrateEntities.CrateHitEvent;
import plugin.LootSystem.CrateEntities.Crates;
import plugin.commands.DatabaseUsing.CrateStatsCommand;
import plugin.commands.DatabaseUsing.PerkCommand;
import plugin.commands.DatabaseUsing.TopCommand;
import plugin.commands.DatabaseUsing.XPCommand;
import plugin.commands.FunCommands.SignCommand;
import plugin.commands.FunCommands.UwUCommand;
import plugin.commands.InventoryCommands.CommonInventories.AnvilCommand;
import plugin.commands.InventoryCommands.CommonInventories.EnderchestCommand;
import plugin.commands.InventoryCommands.CommonInventories.TrashCommand;
import plugin.commands.InventoryCommands.GUIs.KitCommand;
import plugin.commands.InventoryCommands.GUIs.RezeptCommand;
import plugin.commands.InventoryCommands.GUIs.RezepteCommand;
import plugin.commands.InventoryCommands.GUIs.SpecialitemCommand;
import plugin.commands.ModerationsCommands.InfoCommand;
import plugin.commands.ModerationsCommands.InvseeCommand;
import plugin.commands.ModerationsCommands.VanishCommand;
import plugin.commands.QoLCommands.*;
import plugin.db.Database;
import plugin.events.BlockEvents.BlockEvents;
import plugin.events.ExplosionEvents.ExplodeEvent;
import plugin.events.InventoryEvents.ClickEvent;
import plugin.events.InventoryEvents.InfobarClick;
import plugin.events.InventoryEvents.Rezepte.RezeptClickEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.ChatEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.DropEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.JoinEvent;
import plugin.events.PlayerOrEntityEvents.Interactions.RightClickEvent;
import plugin.events.PlayerOrEntityEvents.PvP.PlayerDeathEvent;
import plugin.events.PlayerOrEntityEvents.PvP.PlayerFishingEvent;
import plugin.events.PlayerOrEntityEvents.PvP.PlayerGetHitEvent;
import plugin.events.PlayerOrEntityEvents.PvP.ProjectileHitEvent;
import plugin.utils.Infobar.InfobarCommand;
import plugin.utils.Recipes.Erfahrenrezepte;
import plugin.utils.Recipes.ExplosivRezepte;
import plugin.utils.Recipes.KlebrigRezepte;
import plugin.utils.Recipes.SciFiRezepte;
import plugin.utils.Scores.TablistManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public final class Main extends JavaPlugin{

    private TablistManager tablistManager;
    public static Main instance;
    public ArrayList<UUID> VanishList = new ArrayList<>();
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
            System.out.println("\u001B[31m Konnte sich nicht mit der Datenbank verbinden!");
            System.out.println("\u001B[31m Mögliche Quellen: Falsche Tabellen, Datenbank abgeschalten");
            e.printStackTrace();
        }
        
                getServer().getWorlds()
                        .forEach(world -> world.getEntitiesByClass(ArmorStand.class).stream()
                                .filter(entity -> (Objects.equals(entity.getCustomName(), "§x§F§F§E§2§5§9N§x§F§F§D§E§5§8a§x§F§F§D§A§5§8c§x§F§F§D§5§5§7h§x§F§F§D§1§5§7s§x§F§F§C§D§5§6c§x§F§F§C§9§5§6h§x§F§F§C§5§5§5u§x§F§F§C§0§5§4b§x§F§F§B§C§5§4s§x§F§F§B§8§5§3k§x§F§F§B§4§5§3i§x§F§F§A§F§5§2s§x§F§F§A§B§5§2t§x§F§F§A§7§5§1e §8» §7???")))
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
        getServer().getPluginManager().registerEvents(new BlockEvents(this), this );
        getServer().getPluginManager().registerEvents(new ExplodeEvent(), this );
        getServer().getPluginManager().registerEvents(new PlayerGetHitEvent(this), this );
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
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new FeedCommand());
        Objects.requireNonNull(getCommand("kit")).setExecutor(new KitCommand());
        Objects.requireNonNull(getCommand("sign")).setExecutor(new SignCommand());
        Objects.requireNonNull(getCommand("fix")).setExecutor(new FixCommand());
        Objects.requireNonNull(getCommand("uwu")).setExecutor(new UwUCommand(this));
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvseeCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(getCommand("ec")).setExecutor(new EnderchestCommand());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new WorkbenchCommand());
        Objects.requireNonNull(getCommand("anvil")).setExecutor(new AnvilCommand());
        Objects.requireNonNull(getCommand("specialitems")).setExecutor(new SpecialitemCommand());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCommand(this));
        Objects.requireNonNull(getCommand("rezepte")).setExecutor(new RezepteCommand());
        Objects.requireNonNull(getCommand("playerinfo")).setExecutor(new InfoCommand());
        Objects.requireNonNull(getCommand("xp")).setExecutor(new XPCommand(this));
        Objects.requireNonNull(getCommand("rezept")).setExecutor(new RezeptCommand());
        Objects.requireNonNull(getCommand("trash")).setExecutor(new TrashCommand());
        Objects.requireNonNull(getCommand("modify")).setExecutor(new ModifyCommand());
        Objects.requireNonNull(getCommand("cratestats")).setExecutor(new CrateStatsCommand(this));
        Objects.requireNonNull(getCommand("top")).setExecutor(new TopCommand(this));
        Objects.requireNonNull(getCommand("perks")).setExecutor(new PerkCommand(this));
        Objects.requireNonNull(getCommand("infobar")).setExecutor(new InfobarCommand(this));
        Objects.requireNonNull(getCommand("crate")).setExecutor(new SpawnArmorstandCommand());

    }
    public static Main getInstance(){
        return instance;
    }
    public Database getDatabase() {
        return database;
    }

    @Override
    public void onDisable() {

    }
}

