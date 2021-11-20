package me.else_junsuk.junseclibrary;

import lombok.Getter;
import me.else_junsuk.junseclibrary.commands.CustomItems;
import me.else_junsuk.junseclibrary.inventoryapi.InventoryManager;
import me.else_junsuk.junseclibrary.listeners.PlayerChatListener;
import me.else_junsuk.junseclibrary.listeners.SignChangeListener;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary extends JavaPlugin {

    @Getter
    public static JunSecLibrary main;

    private static InventoryManager invManager;

    @Override
    public void onEnable() {
        main = this;
        F.sendConsole("&2[ JUNSEC LIBRARY ] &f라이브러리를 활성화합니다.");

        invManager = new InventoryManager(this);
        invManager.init();
        F.sendConsole("&2[ JUNSEC LIBRARY ] &f라이브러리의 CustomInventoryAPI를 불러옵니다.");
        F.sendConsole("&2[ JUNSEC LIBRARY ] &f라이브러리의 StringManagerAPI를 불러옵니다.");

        registerEvents();
    }

    private void registerEvents() {
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerChatListener(), this);
        pm.registerEvents(new SignChangeListener(), this);

        new CustomItems(this);

        getServer().getConsoleSender().sendMessage("§2[ JUNSEC LIBRARY ] §f라이브러리의 모든 이벤트와 커맨드를 호출했습니다.");
    }

    @Override
    public void onDisable() {

        getServer().getConsoleSender().sendMessage("§c[ JUNSEC LIBRARY ] §f라이브러리를 종료합니다..");
        getServer().getConsoleSender().sendMessage("§c* 주의하세요! 서버가 불안정해질 수 있습니다.");
    }

    public static InventoryManager manager() { return invManager; }

}
