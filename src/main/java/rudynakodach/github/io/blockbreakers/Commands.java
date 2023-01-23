package rudynakodach.github.io.blockbreakers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import rudynakodach.github.io.blockbreakers.Breakers.Breaker;

import java.util.logging.Logger;
import java.util.HashMap;

public class Commands implements CommandExecutor {

    HashMap<Integer, Integer> delayMap = new HashMap<Integer, Integer>() {{
        put(1,5);
        put(2,4);
        put(3,3);
        put(4,2);
        put(5,1);
    }};

    HashMap<Integer, Integer> durabilityMap = new HashMap<Integer, Integer>() {{
       put(1,16);
       put(2,64);
       put(3,128);
       put(4,256);
       put(5,512);
    }};

    HashMap<Integer, ItemStack> materialHashMap = new HashMap<Integer, ItemStack>() {{
        put(1,new ItemStack(Material.WOODEN_PICKAXE, 1));
        put(2,new ItemStack(Material.STONE_PICKAXE, 1));
        put(3,new ItemStack(Material.IRON_PICKAXE,1));
        put(4,new ItemStack(Material.DIAMOND_PICKAXE, 1));
        put(5,new ItemStack(Material.NETHERITE_PICKAXE,1));
    }};

    Logger logger;
    JavaPlugin plugin;

    public Commands(Logger _logger, JavaPlugin _plugin) {
        logger = _logger;
        plugin = _plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(command.getName().equalsIgnoreCase("givebreaker")) {

            if(args.length == 1) {
                int tier = Integer.parseInt(args[0]);
                int durability = durabilityMap.get(tier);
                int delay = durabilityMap.get(tier);
                ItemStack item = materialHashMap.get(tier);

                Player player = (Player) sender;

                player.getInventory().addItem(new Breaker(delay, tier,durability, item).createBlockBreaker());

                return true;
            }
        }

        return false;
    }
}
