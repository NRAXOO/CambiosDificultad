package p.cambiosDificultad;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class SpiderHit implements Listener {

    @EventHandler
    public void onSpiderHit(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Spider)) return;
        if (!(event.getEntity() instanceof Player player)) return;

        for (int day : new int[]{5, 10, 15}) {
            if (!DayConfig.isDayActive(day)) continue;

            Block block = player.getLocation().getBlock().getRelative(0, 0, 0);
            if (block.getType() == Material.AIR) {
                block.setType(Material.COBWEB);
            }

            break;
        }
    }
}