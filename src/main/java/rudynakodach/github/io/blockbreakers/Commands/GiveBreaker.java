package rudynakodach.github.io.blockbreakers.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import rudynakodach.github.io.blockbreakers.Breakers.StandardBreakers.Breaker;
import java.util.logging.Logger;

public class GiveBreaker implements CommandExecutor {

    Logger logger;
    JavaPlugin plugin;
    FileConfiguration config;

    public GiveBreaker(Logger _logger, JavaPlugin _plugin) {
        logger = _logger;
        plugin = _plugin;

        config = plugin.getConfig();
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(command.getName().equalsIgnoreCase("givebreaker")) {
            if(args.length == 1) {
                int tier = Integer.parseInt(args[0]);

                Player player = (Player) sender;

                player.getInventory().addItem(new Breaker(tier, config).createBlockBreaker());

                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fReceived &aBlock&eBreaker &7MK" + tier));

                return true;
            }
        }
        return false;
    }
}
