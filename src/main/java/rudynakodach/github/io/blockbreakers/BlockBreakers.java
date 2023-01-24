package rudynakodach.github.io.blockbreakers;

import org.bukkit.plugin.java.JavaPlugin;
import rudynakodach.github.io.blockbreakers.Commands.GiveAreaBreaker;
import rudynakodach.github.io.blockbreakers.Commands.GiveBreaker;

import java.util.logging.Level;

public final class BlockBreakers extends JavaPlugin {

    @Override
    public void onEnable() {

        getLogger().log(Level.INFO, "Hello, World!");

        saveDefaultConfig();
        getLogger().log(Level.INFO, "Config ready.");

        getServer().getPluginManager().registerEvents(new BlockBreakerListener(this, getLogger()), this);
        getLogger().log(Level.INFO, "Events registered.");

        GiveBreaker breakerCommand = new GiveBreaker(getLogger(), this);
        getCommand("givebreaker").setExecutor(breakerCommand);

        GiveAreaBreaker areaBreakerCommand = new GiveAreaBreaker(this, getLogger(), getConfig());
        getCommand("giveareabreaker").setExecutor(areaBreakerCommand);
        getLogger().log(Level.INFO, "Commands registered.");

    }

    @Override
    public void onDisable() {

        getLogger().log(Level.INFO, "this is my final message");
        getLogger().log(Level.INFO, "goodb ye");

    }
}
