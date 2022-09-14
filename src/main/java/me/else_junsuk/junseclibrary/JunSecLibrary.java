package me.else_junsuk.junseclibrary;

import me.else_junsuk.junseclibrary.localelib.LocaleManager;
import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary {

    private final JavaPlugin plugin;
    private final LocaleManager localeManager;

    public JunSecLibrary(JavaPlugin plugin) {
        this.plugin = plugin;
        this.localeManager = new LocaleManager();
    }

    public JavaPlugin getJunSecLibrary() {
        return plugin;
    }

    public LocaleManager getLocaleManager() { return localeManager; }

}
