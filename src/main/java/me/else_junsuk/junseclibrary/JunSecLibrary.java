package me.else_junsuk.junseclibrary;

import lombok.Getter;
import me.else_junsuk.junseclibrary.commands.CustomItems;
import me.else_junsuk.junseclibrary.inventoryapi.InventoryManager;
import me.else_junsuk.junseclibrary.listeners.PlayerChatListener;
import me.else_junsuk.junseclibrary.listeners.SignChangeListener;
import me.else_junsuk.junseclibrary.localelib.LocaleManager;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary extends JavaPlugin {

    @Getter
    private static JunSecLibrary main;

    private static InventoryManager invManager;
    @Getter
    private LocaleManager localeManager;

    @Override
    public void onEnable() {
        main = this;
        F.sendConsole(this, "&2[ JUNSEC LIBRARY ] &f라이브러리 활성화를 시작합니다.");

        loadManagers();
        registerEvents();
    }

    private void loadManagers() {
        invManager = new InventoryManager(this);
        invManager.init();
        localeManager = new LocaleManager();

        F.sendConsole(this, "&2[ JUNSEC LIBRARY ] &f라이브러리에 포함된 모든 API를 불러옵니다.");
    }

    private void registerEvents() {
        new PlayerChatListener(this);
        new SignChangeListener(this);
        new CustomItems(this);

        getServer().getConsoleSender().sendMessage("§2[ JUNSEC LIBRARY ] §f라이브러리의 모든 이벤트와 커맨드를 호출했습니다.");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§c[ JUNSEC LIBRARY ] §f라이브러리를 종료합니다. 서버가 불안정해질 수 있습니다.");
    }

    public static InventoryManager manager() { return invManager; }

}
