package me.else_junsuk.junseclibrary.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PlayerChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String m = e.getMessage();
//        if (e.getMessage().contains("#아이템")) {
//            ItemStack handItem = p.getInventory().getItemInMainHand();
//            Gson gson = new Gson();
//
//            Bukkit.broadcastMessage(F.format("&e섹스출발~" + gson.toJson(handItem)));
//        }

        if (m.contains("#스테이터스") || m.contains("#스텟") || m.contains("#스탯") || m.contains("#stat")) {

        }
    }
}
