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

            if(meta.getCustomModelData() == 1) {
                new BreakerAction(plugin, logger, new Breaker(5,1,16,new ItemStack(Material.WOODEN_PICKAXE, 1)), event.getBlock(), target.getLocation());
            }
            else if(meta.getCustomModelData() == 2) {
                new BreakerAction(plugin, logger, new Breaker(4, 2, 32, new ItemStack(Material.STONE_PICKAXE, 1)), event.getBlock(), target.getLocation());
            }
        }
    }
}
