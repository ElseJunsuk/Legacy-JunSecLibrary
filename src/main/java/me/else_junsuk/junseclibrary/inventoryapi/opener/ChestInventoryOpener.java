package me.else_junsuk.junseclibrary.inventoryapi.opener;

import com.google.common.base.Preconditions;
import me.else_junsuk.junseclibrary.inventoryapi.InventoryManager;
import me.else_junsuk.junseclibrary.inventoryapi.SmartInventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

/**
 * 개발자 MinusKube님의 SmartInvAPI 입니다.
 */
public class ChestInventoryOpener implements InventoryOpener {

    @Override
    public Inventory open(SmartInventory inv, Player player) {
        Preconditions.checkArgument(inv.getColumns() == 9,
                "상자GUI의 열(Column) 수는 9개여야 합니다. 발견된 열 오류: %s.", inv.getColumns());
        Preconditions.checkArgument(inv.getRows() >= 1 && inv.getRows() <= 6,
                "상자GUi의 행(Row) 수는 1에서6 사이여야 합니다. 발견된 행 오류: %s", inv.getRows());

        InventoryManager manager = inv.getManager();
        Inventory handle = Bukkit.createInventory(player, inv.getRows() * inv.getColumns(), inv.getTitle());

        fill(handle, manager.getContents(player).get());

        player.openInventory(handle);
        return handle;
    }

    @Override
    public boolean supports(InventoryType type) {
        return type == InventoryType.CHEST || type == InventoryType.ENDER_CHEST;
    }

}
