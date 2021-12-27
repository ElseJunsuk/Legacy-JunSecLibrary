package me.else_junsuk.junseclibrary.inventoryapi.opener;

import me.else_junsuk.junseclibrary.inventoryapi.ClickableItem;
import me.else_junsuk.junseclibrary.inventoryapi.SmartInventory;
import me.else_junsuk.junseclibrary.inventoryapi.content.InventoryContents;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * 개발자 MinusKube님의 SmartInvAPI 입니다.
 */
public interface InventoryOpener {

    Inventory open(SmartInventory inv, Player player);
    boolean supports(InventoryType type);

    default void fill(Inventory handle, InventoryContents contents) {
        ClickableItem[][] items = contents.all();

        for(int row = 0; row < items.length; row++) {
            for(int column = 0; column < items[row].length; column++) {
                if(items[row][column] != null)
                    handle.setItem(9 * row + column, items[row][column].getItem());
            }
        }
    }
}
