package net.nebulabc.gitsumbackups;

import net.nebulabc.gitsumbackups.impl.BackupCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GitSumBackups extends JavaPlugin {

    @Override
    public void onEnable() {
        Objects.requireNonNull(this.getCommand("gitsave")).setExecutor(new BackupCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
