package p.cambiosDificultad;

import org.bukkit.entity.Spider;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class SpiderHandler implements Listener {

    private final Random random = new Random();
    private final PotionEffectType[] efectos = {
            PotionEffectType.SPEED,
            PotionEffectType.REGENERATION,
            PotionEffectType.STRENGTH,
            PotionEffectType.JUMP_BOOST,
            PotionEffectType.GLOWING,
            PotionEffectType.INVISIBILITY,
            PotionEffectType.SLOW_FALLING,
            PotionEffectType.RESISTANCE
    };

    @EventHandler
    public void onSpiderSpawn(CreatureSpawnEvent event) {
        if (!(event.getEntity() instanceof Spider spider)) return;

        for (int day : new int[]{5, 10, 15}) {
            if (!DayConfig.isDayActive(day)) continue;

            int efectosNum = 1 + random.nextInt(3);
            for (int i = 0; i < efectosNum; i++) {
                PotionEffectType efecto = efectos[random.nextInt(efectos.length)];
                int nivel = 1 + random.nextInt(4);
                spider.addPotionEffect(new PotionEffect(efecto, Integer.MAX_VALUE, nivel - 1, true, true));
            }
            break;
        }
    }
}