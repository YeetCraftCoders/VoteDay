package me.flour.discordwl.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.mineacademy.fo.command.SimpleCommand;

public class Whitelist extends SimpleCommand {
    public Whitelist(String label) {
        super(label);
        setPermission("wl.dodaj");
        setMinArguments(1);

    }

    @Override
    protected void onCommand() {
        if (args.length > 0) {

            final StringBuilder builder = new StringBuilder();
            for (final String arg : args) {
                builder.append(arg).append(" ");
            }
            final String name = builder.toString().trim();

            ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();
            Bukkit.getServer().dispatchCommand(sender, "easywl add " + name);


            
        }


    }
}
