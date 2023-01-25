package rudynakodach.github.io.blockbreakers.Breakers.AreaBreakers;

import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.logging.Logger;

public class AreaBreakerAction {

    JavaPlugin plugin;
    Logger logger;

    int delay;
    int durability;

    Block areaBreakerBlock;
    AreaBreaker areaBreaker;
    Location initialPosition;

    World currentWorld;

    public AreaBreakerAction(JavaPlugin _plugin, Logger _logger, AreaBreaker _breaker, Block _blockBreaker, Location _targetLocation, World currentWorld) {
        plugin = _plugin;
        logger = _logger;

        delay = _breaker.delay;
        durability = _breaker.durability;

        areaBreakerBlock = _blockBreaker;
        areaBreaker = _breaker;
        initialPosition = _targetLocation;

        StartBreaking();
    }

    private void StartBreaking() {
        new AreaBreakerTask(delay, durability, areaBreaker.BLOCK_BREAKER_POWER, areaBreakerBlock, initialPosition, logger).runTaskTimer(plugin, 20 * delay, 20 * delay);
    }

}
