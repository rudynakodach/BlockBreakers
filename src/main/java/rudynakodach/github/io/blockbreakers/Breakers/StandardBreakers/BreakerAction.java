package rudynakodach.github.io.blockbreakers.Breakers.StandardBreakers;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BreakerAction {

    JavaPlugin plugin;
    Logger logger;

    int delay;
    int durability;

    Block blockBreaker;
    Breaker breakerInstance;
    Location targetPosition;

    public BreakerAction(JavaPlugin _plugin, Logger _logger, Breaker _breaker, Block _blockBreaker, Location _targetLocation) {
        plugin = _plugin;
        breakerInstance = _breaker;

        blockBreaker = _blockBreaker;

        targetPosition = _targetLocation;

        durability = breakerInstance.durability;
        delay = breakerInstance.delay;

        logger = _logger;
        logger.log(Level.INFO, "Starting excavation...");

        StartBreaking();
    }

    private void StartBreaking() {
        new BreakTask(delay, durability, breakerInstance.BLOCK_BREAKER_POWER, blockBreaker, targetPosition).runTaskTimer(plugin, 20 * delay, 20 * delay);
    }
}
