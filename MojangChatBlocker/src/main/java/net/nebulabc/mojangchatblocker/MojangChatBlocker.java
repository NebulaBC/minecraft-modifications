package net.nebulabc.mojangchatblocker;

import net.nebulabc.mojangchatblocker.events.SendMessageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class MojangChatBlocker extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SendMessageEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
