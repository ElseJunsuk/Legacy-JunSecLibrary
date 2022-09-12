package me.else_junsuk.junseclibrary.playerapi;

import me.else_junsuk.junseclibrary.stringsapi.Format;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;

public class Player {

    /**
     * 정의된 책을 플레이어에게 펼쳐줍니다.
     * @param player 타겟
     */
    public static void openBook(Player player, ItemStack book) {
        openBook(player, book);
    }

    /**
     * 플레이어에게 현재 동결 틱을 설정합니다.
     * (엔티티가 눈 파우더 속에 있었던 틱의 양)
     * @param player 타겟
     * @param ticks 20틱은 1초와 비례합니다.
     */
    public static void setFreeze(org.bukkit.entity.Player player, int ticks) {
        for (int i = 1; i < ticks; i++) {
            player.setFreezeTicks(i);
        }
    }

    /**
     * 플레이어를 특정 위치로 이동 시킨 후 메시지를 출력합니다.
     * @param player 타겟
     * @param location 위치
     * @param message 프라이빗 출력 메시지
     */
    public static void teleport(org.bukkit.entity.Player player, Location location, String message) {
        player.teleport(location.clone().add(0, 0.3, 0));
        Format.send(player, message);
    }

    /**
     * 플레이어를 특정 위치로 이동 시키는데,
     * Location클래스속 clone메소드를 사용해
     * 플레이어가 타겟을 중심으로 어느 X,Y,Z좌표를
     * 추가하여 이동시킬지 설정할 수 있습니다.
     * @param player 타겟
     * @param location 위치
     * @param clonex 형태의 위치를 중심으로 추가된 X좌표
     * @param cloney 위치를 중심으로 추가된 Y좌표
     * @param clonez 위치를 중심으로 추가된 Z좌표
     */
    public static void teleport(org.bukkit.entity.Player player, Location location, double clonex, double cloney, double clonez) {
        player.teleport(location.clone().add(clonex, cloney, clonez));
    }

}
