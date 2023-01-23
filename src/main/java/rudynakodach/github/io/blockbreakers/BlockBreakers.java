package rudynakodach.github.io.blockbreakers;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;

public final class BlockBreakers extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().log(Level.INFO, "Hello, World!");

        getServer().getPluginManager().registerEvents(new BlockBreakerListener(this, getLogger()), this);
        getLogger().log(Level.INFO, "Events registered.");

        Commands cmds = new Commands(getLogger(), this);

        getCommand("givebreaker").setExecutor(cmds);
        getLogger().log(Level.INFO, "Commands registered.");

    }

    @Override
    public void onDisable() {

        getLogger().log(Level.INFO, "this is my final message");
        getLogger().log(Level.INFO, "goodb ye");

    }
}
