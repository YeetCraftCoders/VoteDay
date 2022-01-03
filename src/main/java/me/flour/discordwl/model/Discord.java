package me.flour.discordwl.model;

import github.scarsz.discordsrv.api.ListenerPriority;
import github.scarsz.discordsrv.api.Subscribe;
import github.scarsz.discordsrv.api.events.DiscordGuildMessageReceivedEvent;
import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.Plugin;

public class Discord {


    private final Plugin plugin;

    public Discord(Plugin plugin) {
        this.plugin = plugin;

    }




    @Subscribe(priority = ListenerPriority.MONITOR)
    public void discordMessageReceived(DiscordGuildMessageReceivedEvent event) {

        if (event.getChannel().getId().equalsIgnoreCase("927027919665115146")) {
            ConsoleCommandSender sender = Bukkit.getServer().getConsoleSender();
            Bukkit.getScheduler().callSyncMethod(plugin, () -> Bukkit.getServer().dispatchCommand(sender, "easywl add " + event.getMessage().getContentRaw()));
            event.getRawEvent().getMessage().addReaction("\uD83D\uDE0E").queue();
            event.getRawEvent().getMessage().reply("Dodano gracza o nazwie " + event.getMessage().getContentRaw() + " do whitelisty serwera!").queue();




        }


    }


}
