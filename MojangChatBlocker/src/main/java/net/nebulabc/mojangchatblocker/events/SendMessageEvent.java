package net.nebulabc.mojangchatblocker.events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class SendMessageEvent implements Listener {
    @EventHandler
    public void onPlayerJoin(AsyncPlayerChatEvent e) {
        e.getPlayer().sendMessage(ChatColor.RED + "Please send your message through the Discord! Mojang monitors game chat.");
        e.setCancelled(true);
    }
}
