package p.cambiosDificultad;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageHandler implements Listener {

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        for (int day : new int[]{5, 10, 15}) {
            if (DayConfig.isDayActive(day) && DayConfig.doubleDamage(day)) {
                event.setDamage(event.getDamage() * 2);
            }
        }
    }
}
