package p.cambiosDificultad;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class DayConfig {

    private static Map<Integer, Boolean> activeDays = new HashMap<>();
    private static JavaPlugin plugin;

    public static void initialize(JavaPlugin pl) {
        plugin = pl;
        FileConfiguration cfg = plugin.getConfig();

        activeDays.put(5, cfg.getBoolean("days.5", false));
        activeDays.put(10, cfg.getBoolean("days.10", false));
        activeDays.put(15, cfg.getBoolean("days.15", false));
    }

    public static boolean isDayActive(int day) {
        return activeDays.getOrDefault(day, false);
    }

    public static void setDayActive(int day, boolean value) {
        activeDays.put(day, value);
        plugin.getConfig().set("days." + day, value);
        plugin.saveConfig();
    }

    // Configuración específica por día
    public static boolean spiderEffects(int day) { return day == 5 || day == 10 || day == 15; }
    public static boolean doubleMobs(int day) { return day == 10 || day == 15; }
    public static boolean cobwebs(int day) { return day >= 5; }
    public static boolean doubleDamage(int day) { return day >= 5; }
    public static int minPlayersNight(int day) { return 4; }
}