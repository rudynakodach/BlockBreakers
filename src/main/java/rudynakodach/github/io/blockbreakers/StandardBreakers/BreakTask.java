package rudynakodach.github.io.blockbreakers.StandardBreakers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class BreakTask extends BukkitRunnable {

    ItemStack BLOCK_BREAKER_POWER;
    int delay;
    int durability;
    Block blockBreaker;
    Location target;
    public BreakTask(int _delay, int _durability, ItemStack _material, Block _blockBreaker, Location _target) {
        delay = _delay;
        durability = _durability;
        BLOCK_BREAKER_POWER = _material;
        blockBreaker = _blockBreaker;
        target = _target;
    }

    int i = 0;

    @Override
    public void run() {
        if (i >= durability) {
            blockBreaker.breakNaturally(new ItemStack(Material.AIR));
            this.cancel();
            return;
        }
        else {
            if(blockBreaker.getLocation().getBlock().getType() == Material.DISPENSER) {
                target.getBlock().breakNaturally(new ItemStack(Material.WOODEN_PICKAXE));
                i++;
            }
            else {
                blockBreaker.breakNaturally(new ItemStack(Material.AIR));
                this.cancel();
                return;
            }
        }
    }
}
