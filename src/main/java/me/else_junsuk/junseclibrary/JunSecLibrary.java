package me.else_junsuk.junseclibrary;

import fr.minuskube.inv.InventoryManager;
import me.else_junsuk.junseclibrary.commands.CustomItems;
import me.else_junsuk.junseclibrary.listeners.PlayerChatListener;
import me.else_junsuk.junseclibrary.listeners.SignChangeListener;
import me.else_junsuk.junseclibrary.localelib.LocaleManager;
import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary {

    private final JavaPlugin plugin;
    private final InventoryManager inventoryManager;
    private final LocaleManager localeManager;

    public JunSecLibrary(JavaPlugin plugin) {
        this.plugin = plugin;
        this.inventoryManager = new InventoryManager(plugin);
        inventoryManager.init();
        this.localeManager = new LocaleManager();
        new PlayerChatListener(plugin);
        new SignChangeListener(plugin);
        new CustomItems(this);
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public InventoryManager getInventoryManager() { return inventoryManager; }

    public LocaleManager getLocaleManager() { return localeManager; }

}
