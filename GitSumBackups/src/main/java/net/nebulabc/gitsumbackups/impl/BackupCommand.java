package net.nebulabc.gitsumbackups.impl;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class BackupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Objects.requireNonNull(sender.getServer().getWorld("world")).setAutoSave(false);
        // Git stuff here
        Objects.requireNonNull(sender.getServer().getWorld("world")).setAutoSave(true);
        return true;
    }
}
