package me.flour.discordwl;

//import github.scarsz.discordsrv.DiscordSRV;
import me.flour.discordwl.commands.Stats;
//import me.flour.discordwl.model.Discord;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

public class Initialize extends SimplePlugin {

    //private Discord discord = new Discord(this);



    @Override
    protected void onPluginStart() {

        registerCommand(new Stats("statystyki"));

        //DiscordSRV.api.subscribe(discord);

        registerCommand(new Whitelist("dodaj"));

        Common.logFramed("&aZaładowano wtyczkę whitelistową. ");
    }

    @Override
    protected void onPluginStop() {
        //DiscordSRV.api.unsubscribe(discord);
    }
}
