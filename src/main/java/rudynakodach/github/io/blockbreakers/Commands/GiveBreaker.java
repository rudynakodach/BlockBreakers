package rudynakodach.github.io.blockbreakers.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import rudynakodach.github.io.blockbreakers.AreaBreakers.AreaBreaker;
import rudynakodach.github.io.blockbreakers.BreakerLevels;
import rudynakodach.github.io.blockbreakers.StandardBreakers.Breaker;

import java.util.logging.Logger;
import java.util.HashMap;

public class GiveBreaker implements CommandExecutor {

    HashMap<Integer, Integer> delayMap;
    HashMap<Integer, Integer> durabilityMap;
    HashMap<Integer, ItemStack> itemMap;

    Logger logger;
    JavaPlugin plugin;
    FileConfiguration config;

    public GiveBreaker(Logger _logger, JavaPlugin _plugin) {
        logger = _logger;
        plugin = _plugin;

        config = plugin.getConfig();

        BreakerLevels breakerLevels = new BreakerLevels(config);

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

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fReceived &aBlock&eBreaker &7MK" + tier));

                return true;
            }
        }
        return false;
    }
}
