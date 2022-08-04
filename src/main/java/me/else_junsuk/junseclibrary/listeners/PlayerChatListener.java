package me.else_junsuk.junseclibrary.listeners;

import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerChatListener implements Listener {

    private JavaPlugin plugin;

    public PlayerChatListener(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();

        if (p.isOp()) {
            e.setMessage(F.format(m));
            e.setFormat(F.format(e.getFormat()));
        }
    }
}
