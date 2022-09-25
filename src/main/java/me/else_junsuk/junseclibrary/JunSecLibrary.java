package me.else_junsuk.junseclibrary;

import org.bukkit.plugin.java.JavaPlugin;

public class JunSecLibrary {

    private final JavaPlugin plugin;

    public JunSecLibrary(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public boolean isEnable() {
        return this != null;
    }

    public JavaPlugin getJunSecLibrary() {
        return plugin;
    }

}
