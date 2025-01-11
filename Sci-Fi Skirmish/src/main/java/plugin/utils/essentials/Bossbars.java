package plugin.utils.essentials;

import net.kyori.adventure.text.minimessage.MiniMessage;
import plugin.Main;
import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Bossbars {

    private BossBar bossBar;



    public void healBar(Player player, String value, int amount) {
        if (bossBar != null) {
            bossBar.removeAll();
        }

        bossBar = Bukkit.createBossBar("§7" + value + " geheilt §8» §a+" + amount, BarColor.GREEN, BarStyle.SEGMENTED_6);
        if(Objects.equals(value, "§cNichts")){
            bossBar = Bukkit.createBossBar(value + " geheilt, deine Rüstung ist kaputt oder voll!", BarColor.RED, BarStyle.SOLID);
        }
        bossBar.addPlayer(player);

        Bukkit.getScheduler().runTaskLater(Main.getInstance(), () -> {
            bossBar.removeAll();
            bossBar = null;
        }, 60); // 40 ticks = 2 seconds
    }

}
