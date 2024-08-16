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
import plugin.commands.inventorycommands.commoninventories.TrashCommand;
import plugin.commands.inventorycommands.gui.KitCommand;
import plugin.shop.ShopCommand;
import plugin.specialitems.SpecialitemCommand;
import plugin.commands.inventorycommands.commoninventories.WorkbenchCommand;
import plugin.commands.moderationcommands.InvseeCommand;
import plugin.commands.moderationcommands.VanishCommand;
import plugin.commands.qolcommands.*;
import plugin.cratesystem.models.Crate;
import plugin.cratesystem.SpawnCrateCommand;
import plugin.database.Database;
import plugin.listeners.blocklisteners.BlockEvents;
import plugin.listeners.explosionlisteners.ExplodeEvent;
import plugin.listeners.inventorylisteners.ClickEvent;
import plugin.listeners.inventorylisteners.InfobarClick;
import plugin.listeners.inventorylisteners.PerkClickEvent;
import plugin.listeners.entitylisteners.interactions.chatevents.ChatEvent;
import plugin.listeners.entitylisteners.pvp.*;
import plugin.infobar.InfobarCommand;
import plugin.models.PlayerCombatHandler;
import plugin.models.PlayerStats;
import plugin.ranksystem.commands.SetRankCommand;
import plugin.safe.SafeListener;
import plugin.safe.SafeCommand;
import plugin.specialitems.holy.HolyBackpack;
import plugin.utils.itembuilder.HolyFeather;
import plugin.specialitems.candles.JumpCandle;
import plugin.specialitems.candles.RepairCandle;
import plugin.specialitems.candles.TeleportCandle;
import plugin.specialitems.candles.UltimateCandle;
import plugin.specialitems.holy.HolyArmor;
import plugin.specialitems.holy.HolyCoin;
import plugin.specialitems.holy.HolyCookieBox;
import plugin.specialitems.vampiric.VampiricBow;
import plugin.specialitems.vampiric.VampiricHelmet;
import plugin.specialitems.vampiric.VampiricHoe;
import plugin.utils.scores.ScoreboardManager;
import plugin.listeners.entitylisteners.interactions.*;

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
            HolyArmor.startArmorCheck(player);
            PlayerCombatHandler.getCombatStatusByPlayer(player).startUnCombatCheck();
            try {
                if (getDatabase().findPlayerStats(player) == null) {
                    getDatabase().createPlayerStats(new PlayerStats(player));
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                for(Player player : Bukkit.getOnlinePlayers()) {
                   Main.getInstance().getTablistManager().setAllPlayerTeams();
                   Main.getInstance().getTablistManager().setScoreboard(player);
                }
            }
        }, 9, 9);

        getServer().getOnlinePlayers().forEach(player -> Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
                VampiricHelmet.start(player);
            }
        }, 0, 3 * 20));

        setupTablist();
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

    private void registerEvents(){
        getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        getServer().getPluginManager().registerEvents(new BlockEvents(), this);
        getServer().getPluginManager().registerEvents(new ExplodeEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerGetHitEvent(this), this);
        getServer().getPluginManager().registerEvents(new JoinEvent(this), this);
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
        getServer().getPluginManager().registerEvents(new BowHitEvent(this), this);
        getServer().getPluginManager().registerEvents(new PlayerDeathEvent(), this);
        getServer().getPluginManager().registerEvents(new RightClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new DropEvent(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingEvent(), this);
        getServer().getPluginManager().registerEvents(new InfobarClick(this), this);
        getServer().getPluginManager().registerEvents(new PerkClickEvent(this), this);
        getServer().getPluginManager().registerEvents(new MoveEvent(), this);
        getServer().getPluginManager().registerEvents(new LeaveEvent(), this);

        //functionality for the Candles
        getServer().getPluginManager().registerEvents(new JumpCandle(), this);
        getServer().getPluginManager().registerEvents(new RepairCandle(), this);
        getServer().getPluginManager().registerEvents(new TeleportCandle(), this);
        getServer().getPluginManager().registerEvents(new UltimateCandle(), this);
        //functionality for the holy Items
        getServer().getPluginManager().registerEvents(new HolyFeather(), this);
        getServer().getPluginManager().registerEvents(new HolyCoin(), this);
        getServer().getPluginManager().registerEvents(new HolyCookieBox(), this);
        getServer().getPluginManager().registerEvents(new HolyArmor(), this);
        getServer().getPluginManager().registerEvents(new HolyBackpack(), this);
        //functionality for the vampiric Items
        getServer().getPluginManager().registerEvents(new VampiricHelmet(), this);
        getServer().getPluginManager().registerEvents(new VampiricHoe(), this);
        getServer().getPluginManager().registerEvents(new VampiricBow(), this);

        getServer().getPluginManager().registerEvents(new SafeListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryUtils(), this);
        getServer().getPluginManager().registerEvents(new Crate(), this);
    }

    private void registerCommands(){
        Objects.requireNonNull(getCommand("heal")).setExecutor(new HealCommand());
        Objects.requireNonNull(getCommand("kit")).setExecutor(new KitCommand());
        Objects.requireNonNull(getCommand("sign")).setExecutor(new SignCommand());
        Objects.requireNonNull(getCommand("fix")).setExecutor(new FixCommand());
        Objects.requireNonNull(getCommand("uwu")).setExecutor(new UwUCommand());
        Objects.requireNonNull(getCommand("invsee")).setExecutor(new InvseeCommand(this));
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new SpawnCommand());
        Objects.requireNonNull(getCommand("workbench")).setExecutor(new WorkbenchCommand());
        Objects.requireNonNull(getCommand("anvil")).setExecutor(new AnvilCommand());
        Objects.requireNonNull(getCommand("specialitems")).setExecutor(new SpecialitemCommand());
        Objects.requireNonNull(getCommand("vanish")).setExecutor(new VanishCommand(this));
        Objects.requireNonNull(getCommand("stats")).setExecutor(new StatsCommand(this));
        Objects.requireNonNull(getCommand("xp")).setExecutor(new XPCommand(this));
        Objects.requireNonNull(getCommand("trash")).setExecutor(new TrashCommand());
        Objects.requireNonNull(getCommand("modify")).setExecutor(new ModifyCommand());
        Objects.requireNonNull(getCommand("top")).setExecutor(new TopCommand(this));
        Objects.requireNonNull(getCommand("perks")).setExecutor(new PerkCommand(this));
        Objects.requireNonNull(getCommand("infobar")).setExecutor(new InfobarCommand(this));
        Objects.requireNonNull(getCommand("crate")).setExecutor(new SpawnCrateCommand());
        Objects.requireNonNull(getCommand("nightvision")).setExecutor(new NightVisionCommand());
        Objects.requireNonNull(getCommand("setrank")).setExecutor(new SetRankCommand());
        Objects.requireNonNull(getCommand("safe")).setExecutor(new SafeCommand());
        Objects.requireNonNull(getCommand("shop")).setExecutor(new ShopCommand());
    }

    private void setupTablist(){
        tablistManager = new ScoreboardManager(this);
        tablistManager.registerAllTeams();
        tablistManager.removeAllPlayerTeams();
        tablistManager.setAllPlayerTeams();
    }
}
