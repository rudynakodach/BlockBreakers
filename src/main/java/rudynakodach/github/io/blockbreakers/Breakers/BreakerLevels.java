package rudynakodach.github.io.blockbreakers.Breakers;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class BreakerLevels {

    FileConfiguration config;
    public BreakerLevels(FileConfiguration configuration) {
        config = configuration;
    }

    public HashMap<Integer, Integer> delayMap = new HashMap<Integer, Integer>() {{
        put(1,config.getInt("breakers.tier1.delay"));
        put(2,config.getInt("breakers.tier2.delay"));
        put(3,config.getInt("breakers.tier3.delay"));
        put(4,config.getInt("breakers.tier4.delay"));
        put(5,config.getInt("breakers.tier5.delay"));
    }};

    public HashMap<Integer, Integer> durabilityMap = new HashMap<Integer, Integer>() {{
        put(1,config.getInt("breakers.tier1.durability"));
        put(2,config.getInt("breakers.tier2.durability"));
        put(3,config.getInt("breakers.tier3.durability"));
        put(4,config.getInt("breakers.tier4.durability"));
        put(5,config.getInt("breakers.tier5.durability"));
    }};

    public HashMap<Integer, ItemStack> breakerItemHashMap = new HashMap<Integer, ItemStack>() {{
        put(1,new ItemStack(Material.getMaterial(config.getString("breakers.tier1.item")), 1));
        put(2,new ItemStack(Material.getMaterial(config.getString("breakers.tier2.item")), 1));
        put(3,new ItemStack(Material.getMaterial(config.getString("breakers.tier3.item")),1));
        put(4,new ItemStack(Material.getMaterial(config.getString("breakers.tier4.item")), 1));
        put(5,new ItemStack(Material.getMaterial(config.getString("breakers.tier5.item")),1));
    }};

}
