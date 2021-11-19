package me.else_junsuk.junseclibrary.stringsapi;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Arrays;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Else_JunSuk
 *
 * 아래의 클래스(F)는 Format의 약자로,
 * 소속한 플러그인에 대하여 모든 문자열
 * 을 케어합니다.
 */
public class F {

    /**
     * 버킷에 info, warning로그를 분류하여 출력합니다.
     */
    public static final Logger log = Logger.getLogger("Minecraft");

    /**
     * 콘솔에 메시지를 출력.
     * @warning 본 메서드는 메인 클래스의 메인 인스턴스를 불러오지 못하면 치명적인 오류가 발생할 수 있습니다.
     * @param message
     */
    public static void sendConsole(String msg) {
        JunSecLibrary.getMain().getServer().getConsoleSender().sendMessage(format(msg));
    }

    /**
     * HEX 코드를 사용하기 위해 필요한 패턴 구조.
     */
    public static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * 문자열에 포함된 HEX 코드를 색으로 트렌싱.
     * @param message
     * @return String
     */
    public static String format(String msg) {
        if (Bukkit.getVersion().contains("1.17.1")) {
            Matcher match = pattern.matcher(msg);
            while (match.find()) {
                String color = msg.substring(match.start(), match.end());
                msg = msg.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(msg);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    /**
     * 플레이어의 머리를 ItemStack형식으로 불러옴.
     * @param player
     * @return ItemStack
     */
    public static ItemStack getPlayerSkull(String p) {
        boolean isNetVersion = Arrays.stream(Material.values())
                .map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");

        Material type = Material.matchMaterial(isNetVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
        ItemStack item = new ItemStack(type, 1);

        if (!isNetVersion)
            item.setDurability((short) 3);

        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setOwner(p);

        item.setItemMeta(meta);

        return item;
    }

}