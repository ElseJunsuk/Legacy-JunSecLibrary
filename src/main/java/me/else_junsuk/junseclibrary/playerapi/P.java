package me.else_junsuk.junseclibrary.playerapi;

import me.else_junsuk.junseclibrary.itemutilapi.CustomItem;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class P {

    /**
     * 책을 직접 생성하고 생성 후 바로 플레이어에게 보여줍니다.
     * @since 1.2.0
     * @param player
     * @param title
     * @param author
     * @param content
     */
    public static void openCreateBook(Player player, String title, String author, String... content) {
        ItemStack book = CustomItem.createBook(title, author, content);
        player.openBook(book);
    }

}
