package me.else_junsuk.junseclibrary.commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Command implements CommandExecutor {

    protected JavaPlugin plugin;
    protected String name;

    public Command(JavaPlugin plugin, String name) {
        this.plugin = plugin;
        PluginCommand pc = plugin.getCommand(name);
        pc.setExecutor(this);
    }

    public abstract void execute(Player p, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            execute((Player) sender, args);
        }
        return true;
    }

}
