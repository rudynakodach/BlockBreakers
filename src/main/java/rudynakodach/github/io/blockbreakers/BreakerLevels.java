package rudynakodach.github.io.blockbreakers;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class BreakerLevels {

    FileConfiguration config;
    public BreakerLevels(FileConfiguration configuration) {
        config = configuration;

        delayMap.put(1,config.getInt("breakers.block.tier1.delay"));
        delayMap.put(2,config.getInt("breakers.block.tier2.delay"));
        delayMap.put(3,config.getInt("breakers.block.tier3.delay"));
        delayMap.put(4,config.getInt("breakers.block.tier4.delay"));
        delayMap.put(5,config.getInt("breakers.block.tier5.delay"));

        durabilityMap.put(1,config.getInt("breakers.block.tier1.durability"));
        durabilityMap.put(2,config.getInt("breakers.block.tier2.durability"));
        durabilityMap.put(3,config.getInt("breakers.block.tier3.durability"));
        durabilityMap.put(4,config.getInt("breakers.block.tier4.durability"));
        durabilityMap.put(5,config.getInt("breakers.block.tier5.durability"));

        breakerItemHashMap.put(1,new ItemStack(Material.getMaterial(config.getString("breakers.block.tier1.item")), 1));
        breakerItemHashMap.put(2,new ItemStack(Material.getMaterial(config.getString("breakers.block.tier2.item")), 1));
        breakerItemHashMap.put(3,new ItemStack(Material.getMaterial(config.getString("breakers.block.tier3.item")),1));
        breakerItemHashMap.put(4,new ItemStack(Material.getMaterial(config.getString("breakers.block.tier4.item")), 1));
        breakerItemHashMap.put(5,new ItemStack(Material.getMaterial(config.getString("breakers.block.tier5.item")),1));

        areaBreakerDelayMap.put(1,config.getInt("breakers.area.tier1.delay"));
        areaBreakerDelayMap.put(2,config.getInt("breakers.area.tier2.delay"));
        areaBreakerDelayMap.put(3,config.getInt("breakers.area.tier3.delay"));
        areaBreakerDelayMap.put(4,config.getInt("breakers.area.tier4.delay"));
        areaBreakerDelayMap.put(5,config.getInt("breakers.area.tier5.delay"));

        areaBreakerDurabilityMap.put(1,config.getInt("breakers.area.tier1.durability"));
        areaBreakerDurabilityMap.put(2,config.getInt("breakers.area.tier2.durability"));
        areaBreakerDurabilityMap.put(3,config.getInt("breakers.area.tier3.durability"));
        areaBreakerDurabilityMap.put(4,config.getInt("breakers.area.tier4.durability"));
        areaBreakerDurabilityMap.put(5,config.getInt("breakers.area.tier5.durability"));

        areaBreakerItemHashMap.put(1,new ItemStack(Material.getMaterial(config.getString("breakers.area.tier1.item")), 1));
        areaBreakerItemHashMap.put(2,new ItemStack(Material.getMaterial(config.getString("breakers.area.tier2.item")), 1));
        areaBreakerItemHashMap.put(3,new ItemStack(Material.getMaterial(config.getString("breakers.area.tier3.item")),1));
        areaBreakerItemHashMap.put(4,new ItemStack(Material.getMaterial(config.getString("breakers.area.tier4.item")), 1));
        areaBreakerItemHashMap.put(5,new ItemStack(Material.getMaterial(config.getString("breakers.area.tier5.item")),1));
    }

    public HashMap<Integer, Integer> delayMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> durabilityMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, ItemStack> breakerItemHashMap = new HashMap<Integer, ItemStack>();
    public HashMap<Integer, Integer> areaBreakerDelayMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, Integer> areaBreakerDurabilityMap = new HashMap<Integer, Integer>();
    public HashMap<Integer, ItemStack> areaBreakerItemHashMap = new HashMap<Integer, ItemStack>();
}
