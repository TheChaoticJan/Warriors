package plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import plugin.commands.databasedependant.PerkCommand;
import plugin.commands.databasedependant.StatsCommand;
import plugin.commands.databasedependant.TopCommand;
import plugin.commands.databasedependant.XPCommand;
import plugin.commands.funcommands.SignCommand;
import plugin.commands.funcommands.UwUCommand;
import plugin.commands.inventorycommands.commoninventories.AnvilCommand;
import plugin.commands.inventorycommands.commoninventories.EnderchestCommand;
import plugin.commands.inventorycommands.commoninventories.SmithingTableCommand;
import plugin.commands.inventorycommands.commoninventories.TrashCommand;
import plugin.commands.inventorycommands.gui.KitCommand;
import plugin.commands.inventorycommands.gui.RezeptCommand;
import plugin.commands.inventorycommands.gui.RezepteCommand;
import plugin.commands.inventorycommands.gui.SpecialitemCommand;
import plugin.commands.inventorycommands.commoninventories.WorkbenchCommand;
import plugin.commands.moderationcommands.InvseeCommand;
import plugin.commands.moderationcommands.VanishCommand;
import plugin.commands.qolcommands.*;
import plugin.cratesystem.entities.CrateDeathEvent;
import plugin.cratesystem.entities.CrateHitEvent;
import plugin.cratesystem.entities.Crate;
import plugin.cratesystem.SpawnCrateCommand;
import plugin.database.Database;
import plugin.listeners.blocklisteners.BlockEvents;
import plugin.listeners.explosionlisteners.ExplodeEvent;
import plugin.listeners.inventorylisteners.CandleClickEvent;
import plugin.listeners.inventorylisteners.ClickEvent;
import plugin.listeners.inventorylisteners.InfobarClick;
import plugin.listeners.inventorylisteners.PerkClickEvent;
import plugin.listeners.inventorylisteners.Rezepte.RezeptClickEvent;
import plugin.listeners.entitylisteners.interactions.chatevents.ChatEvent;
import plugin.listeners.entitylisteners.pvp.*;
import plugin.infobar.InfobarCommand;
import plugin.models.PlayerCombatHandler;
import plugin.models.PlayerStats;
import plugin.ranksystem.commands.SetRankCommand;
import plugin.utils.itembuilder.Feather;
import plugin.utils.itembuilder.candles.JumpCandle;
import plugin.utils.itembuilder.candles.RepairCandle;
import plugin.utils.itembuilder.candles.TeleportCandle;
import plugin.utils.itembuilder.candles.UltimateCandle;
import plugin.utils.itembuilder.holy.Coin;
import plugin.utils.itembuilder.holy.CookieBox;
import plugin.utils.recipes.*;
import plugin.utils.scores.ScoreboardManager;
import plugin.utils.essentials.PassiveHealing;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public final class Main extends JavaPlugin {

    private ScoreboardManager tablistManager;
    public static Main instance;
    public ArrayList<UUID> VanishList = new ArrayList<>();

    public ScoreboardManager getTablistManager() {
        return tablistManager;
    }

    private Database database;

    @Override
    public void onEnable() {
        instance = this;

        try {
            this.database = new Database();
            database.initiliazeDatabase();

        } catch (SQLException e) {
            System.out.println("\u001B[31m Konnte sich nicht mit der Datenbank verbinden!");
            System.out.println("\u001B[31m Mögliche Quellen: Falsche Tabellen, Datenbank abgeschalten");
            e.printStackTrace();
        }


        getServer().getWorlds()
                .forEach(world -> world.getEntitiesByClass(ArmorStand.class).stream().
                        filter(entity -> (Objects.equals(entity.getPersistentDataContainer().has(new NamespacedKey(this, "key")), true)))
                        .forEach(Crate::new)
                );

        for (Player player : getServer().getOnlinePlayers()) {
            new PlayerCombatHandler(player);
            PlayerCombatHandler.getCombatStatusByPlayer(player).startUnCombatCheck();
            try {
                if (getDatabase().findPlayerStats(player) == null) {
                    getDatabase().createPlayerStats(new PlayerStats(player));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        getServer().getOnlinePlayers().forEach(player -> Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                PassiveHealing.start(player);
            }
        }, 0, 3 * 20));

        setupTablist();
        addRecipes();
        registerCommands();
        registerEvents();

    }

    public static Main getInstance() {
        return instance;
    }

    public Database getDatabase() {
        return database;
    }

    @Override
    public void onDisable() {

        for (BukkitTask task : Bukkit.getScheduler().getPendingTasks()) {
            Runnable runnable = (Runnable) task;
            runnable.run();
            task.cancel();
        }

        for (Block block : BlockEvents.blocks) {
            block.setType(Material.AIR);
        }

    }

    private void addRecipes(){
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
        Bukkit.addRecipe(CandleRecipes.teleportCandle());
        Bukkit.addRecipe(CandleRecipes.superRecipe());
    }

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockEvents(this), this);
        getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerGetHitEvent(this), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new ProjectileHitEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new CrateDeathEvent(this), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.RightClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new RezeptClickEvent(), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.DropEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEvent(), this);
        getServer().getPluginManager().registerEvents(new CrateHitEvent(), this);
        getServer().getPluginManager().registerEvents(new InfobarClick(this), this);
        getServer().getPluginManager().registerEvents(new PerkClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.AnvilEvent(), this);
        getServer().getPluginManager().registerEvents(new CandleClickEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerRepairEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerDamageEvent(), this);
        getServer().getPluginManager().registerEvents(new plugin.listeners.entitylisteners.interactions.LeaveEvent(), this);
        getServer().getPluginManager().registerEvents(new Feather(), this);
        getServer().getPluginManager().registerEvents(new Coin(), this);
        getServer().getPluginManager().registerEvents(new JumpCandle(), this);
        getServer().getPluginManager().registerEvents(new RepairCandle(), this);
        getServer().getPluginManager().registerEvents(new TeleportCandle(), this);
        getServer().getPluginManager().registerEvents(new UltimateCandle(), this);
        getServer().getPluginManager().registerEvents(new CookieBox(), this);
    }

    private void registerCommands(){
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
        Objects.requireNonNull(getCommand("perks")).setExecutor(new PerkCommand(this));
        Objects.requireNonNull(getCommand("infobar")).setExecutor(new InfobarCommand(this));
        Objects.requireNonNull(getCommand("crate")).setExecutor(new SpawnCrateCommand());
        Objects.requireNonNull(getCommand("smithingtable")).setExecutor(new SmithingTableCommand());
        Objects.requireNonNull(getCommand("nightvision")).setExecutor(new NightVisionCommand());
        Objects.requireNonNull(getCommand("setrank")).setExecutor(new SetRankCommand());
    }

    private void setupTablist(){
        tablistManager = new ScoreboardManager(this);
        tablistManager.registerAllTeams();
        tablistManager.removeAllPlayerTeams();
        tablistManager.setAllPlayerTeams();
        getServer().getOnlinePlayers().forEach(player -> {
            tablistManager.setAllPlayerTeams();
            tablistManager.setScoreboard(player);
        });
    }
}
