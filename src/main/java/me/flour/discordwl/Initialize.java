package me.flour.discordwl;

import github.scarsz.discordsrv.DiscordSRV;
import me.flour.discordwl.model.Discord;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;
import me.flour.discordwl.commands.Whitelist;

public class Initialize extends SimplePlugin {

    private Discord discord = new Discord(this);



    @Override
    protected void onPluginStart() {


        DiscordSRV.api.subscribe(discord);

        registerCommand(new Whitelist("dodaj"));

        Common.logFramed("&aZaładowano wtyczkę whitelistową. ");
    }

    @Override
    protected void onPluginStop() {
        DiscordSRV.api.unsubscribe(discord);
    }
}
