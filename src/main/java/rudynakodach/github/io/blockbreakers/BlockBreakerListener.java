package rudynakodach.github.io.blockbreakers;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import rudynakodach.github.io.blockbreakers.Breakers.Breaker;
import rudynakodach.github.io.blockbreakers.Breakers.BreakerLevels;

import java.util.logging.Level;
import java.util.logging.Logger;

public class BlockBreakerListener implements Listener {

    JavaPlugin plugin;
    Logger logger;

    public BlockBreakerListener(JavaPlugin _plugin, Logger _logger) {
        plugin = _plugin;
        logger = _logger;
    }

    @EventHandler
    public void onBlockPlaced(BlockPlaceEvent event) {

        ItemStack item = event.getItemInHand();

        if(item.getType() == Material.DISPENSER) {

            ItemMeta meta = item.getItemMeta();
            PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

            Block target = event.getBlock().getRelative(BlockFace.DOWN);
            BreakerLevels levels = new BreakerLevels(plugin.getConfig());

            int tier = meta.getCustomModelData();

            new BreakerAction(plugin,logger, new Breaker(levels.delayMap.get(tier),tier, levels.durabilityMap.get(tier), new ItemStack(levels.breakerItemHashMap.get(tier).getType(), 1)), event.getBlock(), target.getLocation());
        }
    }
}
