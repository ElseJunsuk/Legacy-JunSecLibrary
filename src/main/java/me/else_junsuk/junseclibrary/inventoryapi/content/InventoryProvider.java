package me.else_junsuk.junseclibrary.inventoryapi.content;

import org.bukkit.entity.Player;

/**
 * 개발자 MinusKube님의 SmartInvAPI 입니다.
 */
public interface InventoryProvider {

    void init(Player player, InventoryContents contents);
    default void update(Player player, InventoryContents contents) {}

}
