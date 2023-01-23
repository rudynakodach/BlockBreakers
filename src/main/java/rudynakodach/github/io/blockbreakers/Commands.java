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
import rudynakodach.github.io.blockbreakers.Breakers.BreakerLevels;

import java.util.logging.Logger;
import java.util.HashMap;

public class Commands implements CommandExecutor {

    HashMap<Integer, Integer> delayMap;
    HashMap<Integer, Integer> durabilityMap;
    HashMap<Integer, ItemStack> itemMap;

    Logger logger;
    JavaPlugin plugin;

    public Commands(Logger _logger, JavaPlugin _plugin) {
        logger = _logger;
        plugin = _plugin;

        BreakerLevels breakerLevels = new BreakerLevels(plugin.getConfig());

        delayMap = breakerLevels.delayMap;
        durabilityMap = breakerLevels.durabilityMap;
        itemMap = breakerLevels.breakerItemHashMap;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(command.getName().equalsIgnoreCase("givebreaker")) {

            if(args.length == 1) {
                int tier = Integer.parseInt(args[0]);
                int durability = durabilityMap.get(tier);
                int delay = durabilityMap.get(tier);
                ItemStack item = itemMap.get(tier);

                Player player = (Player) sender;

                player.getInventory().addItem(new Breaker(delay, tier,durability, item).createBlockBreaker());

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fReceived &aBlock&eBreaker&7MK" + tier));

                return true;
            }
        }

        return false;
    }
}
