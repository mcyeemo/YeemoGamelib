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

public class Item extends ItemStack {

    private ItemMeta meta;

    public Item(Material material, int amount, int durability) {
        setType(material);
        setAmount(amount);
        setDurability((byte) durability);
        meta = getItemMeta();
    }

    public Item(Material material, int amount) {
        this(material, amount, 0);
    }

    public Item(Material material) {
        this(material, 1, 0);
    }

    public Item(ItemStack item) {
        setType(item.getType());
        setDurability(item.getDurability());
        setData(item.getData());
        setAmount(item.getAmount());
        setItemMeta(item.getItemMeta());
        meta = getItemMeta();
    }

    public void setDisplayName(String displayName) {
        meta.setDisplayName(displayName);
    }

    public void setLore(String... lore) {
        setLore(Arrays.asList(lore));
    }

    public void setLore(List<String> lore) {
        meta.setLore(lore);
    }

    public void addEnchant(Enchantment enchantment, int lvl, boolean ignoreLevelRestriction) {
        meta.addEnchant(enchantment, lvl, ignoreLevelRestriction);
    }

    public void addFlag(ItemFlag... itemFlags) {
        meta.addItemFlags(itemFlags);
    }

    public String getDisplayName() {
        return meta.getDisplayName();
    }

    public List<String> getLore() {
        return meta.getLore();
    }

    public Set<ItemFlag> getItemFlags() {
        return meta.getItemFlags();
    }

    public Map<Enchantment, Integer> getEnchants() {
        return meta.getEnchants();
    }

    public int getEnchantLevel(Enchantment enchantment) {
        return meta.getEnchantLevel(enchantment);
    }

    public boolean hasDisplayName() {
        return meta.hasDisplayName();
    }

    public boolean hasLore() {
        return meta.hasLore();
    }

    public boolean hasEnchants() {
        return meta.hasEnchants();
    }

    public boolean hasEnchant(Enchantment enchantment) {
        return meta.hasEnchant(enchantment);
    }

    public boolean hasConflictingEnchant(Enchantment enchantment) {
        return meta.hasConflictingEnchant(enchantment);
    }

    public boolean hasItemFlag(ItemFlag flag) {
        return meta.hasItemFlag(flag);
    }

    public void updateMeta() {
        setItemMeta(meta);
        meta = getItemMeta();
    }
}
