package rudynakodach.github.io.blockbreakers.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import rudynakodach.github.io.blockbreakers.Breakers.AreaBreakers.AreaBreaker;

import java.util.Objects;
import java.util.logging.Logger;

public class GiveAreaBreaker implements CommandExecutor {

    Logger logger;
    JavaPlugin plugin;
    FileConfiguration config;

    public GiveAreaBreaker(JavaPlugin _plugin, Logger _logger, FileConfiguration _config) {
        logger = _logger;
        plugin = _plugin;
        config = _config;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("giveareabreaker")) {
            if(args.length == 1) {
                int tier = Integer.parseInt(args[0]);

                Player player = (Player) sender;

                player.getInventory().addItem(new AreaBreaker(tier, config).createAreaBreakerItem());

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fReceived &cArea&eBreaker &7MK" + tier));
                return true;
            }
        }

        return false;
    }
}
