package p.cambiosDificultad;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.TimeSkipEvent;

public class NightHandler implements Listener {

    @EventHandler
    public void onTimeSkip(TimeSkipEvent event) {
        if (event.getSkipReason() != TimeSkipEvent.SkipReason.NIGHT_SKIP) return;

        for (int day : new int[]{5, 10, 15}) {
            if (DayConfig.isDayActive(day) && Bukkit.getOnlinePlayers().size() < DayConfig.minPlayersNight(day)) {
                event.setCancelled(true);
            }
        }
    }
}