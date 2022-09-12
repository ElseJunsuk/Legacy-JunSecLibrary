package me.else_junsuk.junseclibrary.stringsapi;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Else_JunSuk
 * <p>
 * 아래 클래스는 소속한 플러그인에 대한 모든 문자열
 * 을 케어합니다.
 */
public class Format {

    /**
     * 콘솔에 메시지를 출력.
     *
     * @param msg
     * @warning 본 메서드는 메인 클래스의 메인 인스턴스를 불러오지 못하면 치명적인 오류가 발생할 수 있습니다.
     */
    public static void sendConsole(Plugin main, String msg) {
        main.getServer().getConsoleSender().sendMessage(format(msg));
    }

    /**
     * HEX 코드를 사용하기 위해 필요한 패턴 구조.
     */
    public static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    /**
     * 문자열에 포함된 HEX 코드를 색으로 트렌싱.
     *
     * @param msg
     * @return String
     */
    public static String format(String msg) {
        if (Bukkit.getVersion().contains("1.19")) {
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
     * 문자 배열에 포함된 HEX 코드를 색으로 트렌싱.
     *
     * @param list
     * @return List<String>
     */
    public static List<String> format(List<String> list) {
        if (Bukkit.getVersion().contains("1.19")) {
            for (String string : list) {
                Matcher match = pattern.matcher(string);
                while (match.find()) {
                    String color = string.substring(match.start(), match.end());
                    string = string.replace(color, ChatColor.of(color) + "");
                    match = pattern.matcher(string);
                }
                ChatColor.translateAlternateColorCodes('&', string);
            }
        }
        return list;
    }

    /**
     * 스 문자열 안에 있는 모든 색생을 제거합니다.
     *
     * @param msg
     * @return String
     */
    public static String deColor(String msg) {
        return org.bukkit.ChatColor.stripColor(msg);
    }

    /**
     * 한 플레이어에게만 전달합니다.
     *
     * @param player - 플레이어에게 채팅을 출력합니다.
     * @param msg
     */
    public static void send(Player player, String msg) {
        player.sendMessage(format(msg));
    }

    /**
     * 커맨드를 사용한 플레이어에게 전달합니다.
     *
     * @param sender - 커맨드 입력 플레이어
     * @param msg
     */
    public static void send(CommandSender sender, String msg) {
        sender.sendMessage(format(msg));
    }

    /**
     * 한 플레이어에게만 전달합니다.
     *
     * @param player    플레이어에게 타이틀을 출력합니다.
     * @param title
     * @param subtitle
     * @param in
     * @param stay
     * @param out
     */
    public static void send(Player player, String title, String subtitle, int in, int stay, int out) {
        player.sendTitle(format(title), format(subtitle), in, stay, out);
    }

    /**
     * 그 플레이어에게 List<String>형삭 메시지를 전달합니다.
     *
     * @param player
     * @param message
     */
    public static void send(Player player, List<String> message) {
        for (String msg : message)
            send(player, msg);
    }


    /**
     * 플레이어에게 액션 바를 출력됩니다.
     *
     * @param player
     * @param msg
     */
    public static void sendActionBar(Player player, String msg) {
        player.spigot().sendMessage(
                ChatMessageType.ACTION_BAR,
                new TextComponent(format(msg)));
    }

    /**
     * 모든 플레이어에게 메시지를 전달합니다.
     *
     * @param msg
     */
    public static void sendAll(String msg) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendMessage(format(msg));
        }
    }

    /**
     * 모든 플레이어에게 타이틀(Title)을 전달합니다.
     *
     * @param title
     * @param subtitle
     * @param in
     * @param stay
     * @param out
     */
    public static void sendAll(String title, String subtitle, int in, int stay, int out) {
        for (Player all : Bukkit.getOnlinePlayers()) {
            all.sendTitle(format(title), format(subtitle), in, stay, out);
        }
    }

    /**
     * 파라미터에 입력된 문자열이 정수인지 확인합니다.
     *
     * @param string
     * @return
     */
    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
