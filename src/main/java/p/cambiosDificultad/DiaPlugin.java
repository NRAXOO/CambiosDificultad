package p.cambiosDificultad;

import org.bukkit.plugin.java.JavaPlugin;

public class DiaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {

        // Crear config.yml si no existe
        saveDefaultConfig();

        // Inicializar DayConfig
        DayConfig.initialize(this);

        // Comandos
        getCommand("dia5").setExecutor(new DiaCommand(true, 5));
        getCommand("resetdia5").setExecutor(new DiaCommand(false, 5));
        getCommand("dia10").setExecutor(new DiaCommand(true, 10));
        getCommand("resetdia10").setExecutor(new DiaCommand(false, 10));
        getCommand("dia15").setExecutor(new DiaCommand(true, 15));
        getCommand("resetdia15").setExecutor(new DiaCommand(false, 15));

        // Listeners
        getServer().getPluginManager().registerEvents(new SpiderHandler(), this);
        getServer().getPluginManager().registerEvents(new SpiderHit(), this);
        getServer().getPluginManager().registerEvents(new DamageHandler(), this);
        getServer().getPluginManager().registerEvents(new NightHandler(), this);
    }
}