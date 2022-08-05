package me.else_junsuk.junseclibrary.playerapi;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import me.else_junsuk.junseclibrary.itemutilapi.CustomItem;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Player {

    private JavaPlugin plugin;

    public Player(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * 아래 메서드에서 책 ItemStack을 정의 후,
     * 바로 플레이어에게 펼쳐줍니다.
     * @since 1.2.1
     * @param player 타겟
     * @param title 책의 제목.
     * @param author 책의 저자.
     * @param content 책의 내용. ','사용 시 페이지 변경.
     */
    public void openCreateBook(org.bukkit.entity.Player player, String title, String author, String... content) {
        ItemStack book = CustomItem.createBook(title, author, content);
        player.openBook(book);
    }

    /**
     * 책을 플레이어에게 펼쳐줍니다.
     * @since 1.2.1
     * @param player 타겟
     */
    public void openBook(org.bukkit.entity.Player player, ItemStack book) {
        player.openBook(book);
    }

    /**
     * 플레이어에게 현재 동결 틱을 설정합니다.
     * (엔티티가 눈 파우더 속에 있었던 틱의 양)
     * @param player 타겟
     * @param ticks 20틱은 1초와 비례합니다.
     */
    public void setFreeze(org.bukkit.entity.Player player, int ticks) {
        for (int i = 1; i < ticks; i++) {
            player.setFreezeTicks(i);
        }
    }

    /**
     * 플레이어에게 사운드를 들려줍니다.
     * @param player 타겟
     * @param location 위치
     * @param sound 사운드 타입 {@link Sound}
     * @param volume double 형태의 볼륨
     * @param pitch double 형태의 피치
     */
    public void playSound(org.bukkit.entity.Player player, Location location, Sound sound, float volume, float pitch) {
        player.playSound(location, sound, volume, pitch);
    }

    /**
     * 플레이어를 특정 위치로 이동 시킨 후 메시지를 출력합니다.
     * @param player 타겟
     * @param location 위치
     * @param message 프라이빗 출력 메시지
     */
    public void teleport(org.bukkit.entity.Player player, Location location, String message) {
        player.teleport(location.clone().add(0, 0.3, 0));
        new JunSecLibrary(plugin).getFormat().send(player, message);
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
    public void teleport(org.bukkit.entity.Player player, Location location, double clonex, double cloney, double clonez) {
        player.teleport(location.clone().add(clonex, cloney, clonez));
    }

}
