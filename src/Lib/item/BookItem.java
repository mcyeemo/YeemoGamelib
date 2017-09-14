package Lib.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Arrays;
import java.util.List;

public class BookItem extends Item {

    private BookMeta meta;

    public BookItem(ItemStack book) {
        super(book);
        meta = (BookMeta) getItemMeta();
    }

    public BookItem(Material material, int amount, int durability) {
        super(material, amount, durability);
        meta = (BookMeta) getItemMeta();
    }

    public BookItem(Material material, int amount) {
        super(material, amount);
        meta = (BookMeta) getItemMeta();
    }

    public BookItem(Material material) {
        super(material);
        meta = (BookMeta) getItemMeta();
    }

    public void setTitle(String title) {
        meta.setTitle(title);
    }

    public void setAuthor(String author) {
        meta.setAuthor(author);
    }

    public void setPage(int page, String text) {
        meta.setPage(page, text);
    }

    public void setPages(String... pages) {
        setPages(Arrays.asList(pages));
    }

    public void setPages(List<String> pages) {
        meta.setPages(pages);
    }

    public void addPages(String... pages) {
        meta.addPage(pages);
    }

    public int getPageCount() {
        return meta.getPageCount();
    }

    public String getPage(int page) {
        return meta.getPage(page);
    }

    public String getAuthor() {
        return meta.getAuthor();
    }

    public String getTitle() {
        return meta.getTitle();
    }

    public List<String> getPages() {
        return meta.getPages();
    }

    public boolean hasTitle() {
        return meta.hasTitle();
    }

    public boolean hasAuthor() {
        return meta.hasAuthor();
    }

    public boolean hasPages() {
        return meta.hasPages();
    }
}
