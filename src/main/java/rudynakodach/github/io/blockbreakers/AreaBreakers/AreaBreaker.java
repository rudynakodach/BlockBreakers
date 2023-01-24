package rudynakodach.github.io.blockbreakers.AreaBreakers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import rudynakodach.github.io.blockbreakers.BreakerNamespaceKeys;

public class AreaBreaker {

    public int delay;
    public int durability;
    public ItemStack BLOCK_BREAKER_POWER;
    int tier;

    public Material BLOCK_BREAKER_MATERIAL = Material.OBSERVER;
    public String BLOCK_BREAKER_TAG = "is_area_breaker";
    public NamespacedKey BLOCK_BREAKER_KEY = BreakerNamespaceKeys.areaBreakerTag;


    public AreaBreaker(int _delay, int _tier, int _durability, ItemStack _item) {
        delay = _delay;
        tier = _tier;
        durability = _durability;
        BLOCK_BREAKER_POWER = _item;
    }

    public ItemStack createAreaBreakerItem() {

        ItemStack blockBreaker = new ItemStack(BLOCK_BREAKER_MATERIAL);
        ItemMeta meta = blockBreaker.getItemMeta();

        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&aArea&eBreaker &7MK" + tier));
        meta.setCustomModelData(tier);

        PersistentDataContainer data = meta.getPersistentDataContainer();
        data.set(BLOCK_BREAKER_KEY, PersistentDataType.STRING, "true");

        blockBreaker.setItemMeta(meta);
        blockBreaker.setAmount(1);

        return blockBreaker;
    }
}
