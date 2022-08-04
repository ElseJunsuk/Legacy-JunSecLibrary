package me.else_junsuk.junseclibrary.listeners;

import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SignChangeListener implements Listener {

    private final JavaPlugin plugin;

    public SignChangeListener(JavaPlugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void onSignChange(SignChangeEvent e) {
        Player p = e.getPlayer();
        if(p.isOp()) {
            for(int i = 0; i < e.getLines().length; i++) {
                if(e.getLine(i) != null && !e.getLine(i).isEmpty())
                    e.setLine(i, F.format(e.getLine(i)));
            }
        }
    }
}
