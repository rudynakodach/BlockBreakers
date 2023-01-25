package rudynakodach.github.io.blockbreakers;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.java.JavaPlugin;
import rudynakodach.github.io.blockbreakers.Breakers.AreaBreakers.AreaBreaker;
import rudynakodach.github.io.blockbreakers.Breakers.AreaBreakers.AreaBreakerAction;
import rudynakodach.github.io.blockbreakers.Breakers.StandardBreakers.Breaker;
import rudynakodach.github.io.blockbreakers.Breakers.StandardBreakers.BreakerAction;

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
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

        if(item.getType() == Material.DISPENSER) {

            if(dataContainer.has(BreakerNamespaceKeys.blockBreakerTag)) {

                Block target = event.getBlock().getRelative(BlockFace.DOWN);

                int tier = meta.getCustomModelData();

                new BreakerAction(plugin, logger, new Breaker(tier, plugin.getConfig()), event.getBlock(), target.getLocation());
            }
        }
        else if(item.getType() == Material.OBSERVER) {
            if(dataContainer.has(BreakerNamespaceKeys.areaBreakerTag)) {

                Block target = event.getBlock().getRelative(BlockFace.DOWN);
                int tier = meta.getCustomModelData();

                new AreaBreakerAction(plugin, logger, new AreaBreaker(tier, plugin.getConfig()),event.getBlock(),target.getLocation(), event.getBlock().getWorld());
            }
        }
    }
}
