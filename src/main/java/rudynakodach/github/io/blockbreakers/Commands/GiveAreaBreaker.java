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

import java.util.HashMap;
import java.util.logging.Logger;

public class GiveAreaBreaker implements CommandExecutor {

    HashMap<Integer, Integer> delayMap;
    HashMap<Integer, Integer> durabilityMap;
    HashMap<Integer, ItemStack> itemMap;

    Logger logger;
    JavaPlugin plugin;
    FileConfiguration config;

    public GiveAreaBreaker(JavaPlugin _plugin, Logger _logger, FileConfiguration _config) {
        logger = _logger;
        plugin = _plugin;
        config = _config;

        BreakerLevels levels = new BreakerLevels(config);
        delayMap = levels.areaBreakerDelayMap;
        durabilityMap = levels.areaBreakerDurabilityMap;
        itemMap = levels.areaBreakerItemHashMap;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("giveareabreaker")) {
            if(args.length == 1) {
                int tier = Integer.parseInt(args[0]);
                int durability = durabilityMap.get(tier);
                int delay = durabilityMap.get(tier);
                ItemStack item = itemMap.get(tier);

                Player player = (Player) sender;

                player.getInventory().addItem(new AreaBreaker(delay, tier,durability, item).createAreaBreakerItem());

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fReceived &cArea&eBreaker &7MK" + tier));
                return true;
            }
        }

        return false;
    }


}
