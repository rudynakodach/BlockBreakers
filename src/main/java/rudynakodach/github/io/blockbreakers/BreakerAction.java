package rudynakodach.github.io.blockbreakers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.block.Dispenser;
import rudynakodach.github.io.blockbreakers.Breakers.BreakTask;
import rudynakodach.github.io.blockbreakers.Breakers.Breaker;

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
