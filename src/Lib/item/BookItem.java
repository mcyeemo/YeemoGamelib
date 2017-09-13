package Lib.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.Arrays;
import java.util.List;

/**
 * BookItem
 * <p>
 * Book Create API
 *
 * @author WenWen
 * @version 1.0 - (2017-09-13)
 * @since 1.1 - (2017-09-13)
 * @see API.item.Item
 *
 */
public class BookItem extends Item {

    private BookMeta meta;

    /**
     * @param book ItemStack
     */
    public BookItem(ItemStack book) {
        super(book);
        meta = (BookMeta) getItemMeta();
    }

    /**
     * @param material Item type
     * @param amount Item amount
     * @param durability Item durability
     */
    public BookItem(Material material, int amount, int durability) {
        super(material, amount, durability);
        meta = (BookMeta) getItemMeta();
    }

    /**
     * @param material Item type
     * @param amount Item amount
     */
    public BookItem(Material material, int amount) {
        super(material, amount);
        meta = (BookMeta) getItemMeta();
    }

    /**
     * @param material Item type
     */
    public BookItem(Material material) {
        super(material);
        meta = (BookMeta) getItemMeta();
    }

    /**
     * @param title Set book title
     */
    public void setTitle(String title) {
        meta.setTitle(title);
    }

    /**
     * @param author Set book author
     */
    public void setAuthor(String author) {
        meta.setAuthor(author);
    }

    /**
     * @param page page number
     * @param text page text (use "\n" to get newLine)
     */
    public void setPage(int page, String text) {
        meta.setPage(page, text);
    }

    /**
     * @param pages add pages (use "\n" to get newLine)
     */
    public void setPages(String... pages) {
        setPages(Arrays.asList(pages));
    }

    /**
     * @param pages add pages (use "\n" to get newLine)
     */
    public void setPages(List<String> pages) {
        meta.setPages(pages);
    }

    /**
     * @param pages add pages (use "\n" to get newLine)
     */
    public void addPages(String... pages) {
        meta.addPage(pages);
    }

    /**
     * @return get book page Count
     */
    public int getPageCount() {
        return meta.getPageCount();
    }

    /**
     * @param page page number
     * @return number page text
     */
    public String getPage(int page) {
        return meta.getPage(page);
    }

    /**
     * @return book author
     */
    public String getAuthor() {
        return meta.getAuthor();
    }

    /**
     * @return book title
     */
    public String getTitle() {
        return meta.getTitle();
    }

    /**
     * @return get all page text
     */
    public List<String> getPages() {
        return meta.getPages();
    }

    /**
     * @return book has title (true)
     */
    public boolean hasTitle() {
        return meta.hasTitle();
    }

    /**
     * @return book has author (true)
     */
    public boolean hasAuthor() {
        return meta.hasAuthor();
    }

    /**
     * @return book has page (true)
     */
    public boolean hasPages() {
        return meta.hasPages();
    }
}
