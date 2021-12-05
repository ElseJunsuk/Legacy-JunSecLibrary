package me.else_junsuk.junseclibrary.listeners;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import me.else_junsuk.junseclibrary.stringsapi.F;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    public PlayerChatListener(JunSecLibrary main) {
        JunSecLibrary.getMain().getServer().getPluginManager().registerEvents(this, main);
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
