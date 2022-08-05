package me.else_junsuk.junseclibrary;

import fr.minuskube.inv.InventoryManager;
import me.else_junsuk.junseclibrary.datasapi.FolderApi;
import me.else_junsuk.junseclibrary.itemutilapi.CustomItem;
import me.else_junsuk.junseclibrary.localelib.LocaleManager;
import me.else_junsuk.junseclibrary.playerapi.Player;
import me.else_junsuk.junseclibrary.stringsapi.Format;
import me.else_junsuk.junseclibrary.stringsapi.Number;
import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary {

    private final JavaPlugin plugin;
    private final InventoryManager inventoryManager;
    private final LocaleManager localeManager;
    private final Player playerApi;
    private final Format format;
    private final FolderApi folderApi;
    private final Number numberApi;
    private final CustomItem customItem;

    public JunSecLibrary(JavaPlugin plugin) {
        this.plugin = plugin;
        this.inventoryManager = new InventoryManager(plugin);
        inventoryManager.init();
        this.localeManager = new LocaleManager();
        this.playerApi = new Player(plugin);
        this.format = new Format(plugin);
        this.folderApi = new FolderApi(plugin);
        this.numberApi = new Number(plugin);
        this.customItem = new CustomItem(plugin);
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }

    public InventoryManager getInventoryManager() { return inventoryManager; }

    public LocaleManager getLocaleManager() { return localeManager; }

    public Player getPlayerApi() { return playerApi; }

    public Format getFormat() { return format; }

    public FolderApi getFolderApi() { return folderApi; }

    public Number getNumberApi() { return numberApi; }

    public CustomItem getCustomItem() { return customItem; }

}
