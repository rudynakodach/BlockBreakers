package rudynakodach.github.io.blockbreakers.Breakers.AreaBreakers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaBreakerTask extends BukkitRunnable {

    int delay;
    int durability;
    ItemStack item;
    Block areaBreaker;
    Location initialLocation;

    World breakerWorld;
    Logger logger;
    public AreaBreakerTask(int _delay, int _durability, ItemStack _item, Block _areaBreaker, Location _initialPosition, Logger _logger) {
        delay = _delay;
        durability = _durability;
        item = _item;
        areaBreaker = _areaBreaker;
        initialLocation = _initialPosition;

        breakerWorld = areaBreaker.getWorld();

        logger = _logger;
    }

    int i = 0;
    @Override
    public void run() {
        if(i >= durability) {
            areaBreaker.breakNaturally(new ItemStack(Material.AIR, 1));
            this.cancel();
            return;
        }
        else {
            if (areaBreaker.getType() == Material.OBSERVER) {
                for (int x = -1; x < 2; x++) {
                    for (int z = -1; z < 2; z++) {
                        breakerWorld.getBlockAt(areaBreaker.getX() + x, areaBreaker.getY() - 1, areaBreaker.getZ() + z).breakNaturally(item);
                    }
                }
                i++;
            }
            else {
                areaBreaker.breakNaturally(new ItemStack(Material.AIR, 1));
                this.cancel();
                return;
            }
        }
    }
}
