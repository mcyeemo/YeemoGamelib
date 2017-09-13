package Lib.item;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Item
 * <p>
 * Item Create API
 *
 * @author WenWen
 * @version 1.0 - (2017-09-13)
 * @since 1.1 - (2017-09-13)
 *
 * @see org.bukkit.inventory.ItemStack
 */
public class Item extends ItemStack {

    private ItemMeta meta;

    /**
     * @param material Item type
     * @param amount Item amount
     * @param durability Item durability
     */
    public Item(Material material, int amount, int durability) {
        setType(material);
        setAmount(amount);
        setDurability((byte) durability);
        meta = getItemMeta();
    }

    /**
     * @param material Item type
     * @param amount Item amount
     */
    public Item(Material material, int amount) {
        this(material, amount, 0);
    }

    /**
     * @param material Item type
     */
    public Item(Material material) {
        this(material, 1, 0);
    }

    /**
     * @param item ItemStack
     */
    public Item(ItemStack item) {
        setType(item.getType());
        setDurability(item.getDurability());
        setData(item.getData());
        setAmount(item.getAmount());
        setItemMeta(item.getItemMeta());
        meta = getItemMeta();
    }

    /**
     * @param displayName set item display name
     */
    public void setDisplayName(String displayName) {
        meta.setDisplayName(displayName);
    }

    /**
     * @param lore set item lore
     */
    public void setLore(String... lore) {
        setLore(Arrays.asList(lore));
    }

    /**
     * @param lore set item lore
     */
    public void setLore(List<String> lore) {
        meta.setLore(lore);
    }

    /**
     * @param enchantment Enchantment
     * @param lvl enchant level
     * @param ignoreLevelRestriction ignore level restriction
     */
    public void addEnchant(Enchantment enchantment, int lvl, boolean ignoreLevelRestriction) {
        meta.addEnchant(enchantment, lvl, ignoreLevelRestriction);
    }

    /**
     * @param itemFlags add Item flag
     */
    public void addFlag(ItemFlag... itemFlags) {
        meta.addItemFlags(itemFlags);
    }

    /**
     * @return get item display name
     */
    public String getDisplayName() {
        return meta.getDisplayName();
    }

    /**
     * @return get item lore
     */
    public List<String> getLore() {
        return meta.getLore();
    }

    /**
     * @return get item flags
     */
    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    /**
     * @return get enchants Map
     */
    public Map<Enchantment, Integer> getEnchants() {
        return meta.getEnchants();
    }

    /**
     * @param enchantment input enchantment
     * @return get enchantment level
     */
    public int getEnchantLevel(Enchantment enchantment) {
        return meta.getEnchantLevel(enchantment);
    }

    /**
     * @return has display name (true)
     */
    public boolean hasDisplayName() {
        return meta.hasDisplayName();
    }

    /**
     * @return has lore name (true)
     */
    public boolean hasLore() {
        return meta.hasLore();
    }

    /**
     * @return has enchants (true)
     */
    public boolean hasEnchants() {
        return meta.hasEnchants();
    }

    /**
     * @param enchantment input enchantment
     * @return has enchantment (true)
     */
    public boolean hasEnchant(Enchantment enchantment) {
        return meta.hasEnchant(enchantment);
    }

    /**
     * @param enchantment ? input enchantment ?
     * @return ? has enchantment (true) ?
     */
    public boolean hasConflictingEnchant(Enchantment enchantment) {
        return meta.hasConflictingEnchant(enchantment);
    }

    /**
     * @param flag input Item flag
     * @return has item flag (true)
     */
    public boolean hasItemFlag(ItemFlag flag) {
        return meta.hasItemFlag(flag);
    }

    /**
     * update Meta before getItemStack
     */
    public void updateMeta() {
        setItemMeta(meta);
        meta = getItemMeta();
    }
}
