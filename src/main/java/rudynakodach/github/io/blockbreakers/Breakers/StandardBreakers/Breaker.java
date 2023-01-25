package rudynakodach.github.io.blockbreakers.Breakers.StandardBreakers;

import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;

import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import rudynakodach.github.io.blockbreakers.BreakerNamespaceKeys;

import java.util.Objects;

public class Breaker {

    public int delay;
    public int durability;
    public ItemStack BLOCK_BREAKER_POWER;
    int tier;

    public Material BLOCK_BREAKER_MATERIAL = Material.DISPENSER;
    public String BLOCK_BREAKER_TAG = "is_block_breaker";
    public NamespacedKey BLOCK_BREAKER_KEY = BreakerNamespaceKeys.blockBreakerTag;


    public Breaker(int _tier, FileConfiguration config) {
        tier = _tier;
        delay = config.getInt("breakers.block.tier" + tier + ".delay");
        durability = config.getInt("breakers.block.tier" + tier + ".durability");
        BLOCK_BREAKER_POWER = new ItemStack(Objects.requireNonNull(Material.getMaterial(Objects.requireNonNull(config.getString("breakers.block.tier" + tier + "item")))), 1);
    }

    public ItemStack createBlockBreaker() {

        ItemStack blockBreaker = new ItemStack(BLOCK_BREAKER_MATERIAL);
        ItemMeta meta = blockBreaker.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&fBlock&eBreaker &7MK" + tier));
        meta.setCustomModelData(tier);

        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(BLOCK_BREAKER_KEY, PersistentDataType.STRING, "true");

        blockBreaker.setItemMeta(meta);
        blockBreaker.setAmount(1);

        return blockBreaker;
    }
}
