package me.else_junsuk.junseclibrary.commands;

import me.else_junsuk.junseclibrary.JunSecLibrary;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

public abstract class Command implements CommandExecutor {

    protected JunSecLibrary main;
    protected String name;

    public Command(JunSecLibrary main, String name) {
        this.main = main;
        PluginCommand pc = main.getCommand(name);
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
