package pl.fabrykacraft.voteday;


import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;

import pl.fabrykacraft.voteday.Runnables.NightTimeRunnable;
import pl.fabrykacraft.voteday.commands.*;


public class Initialize extends SimplePlugin {



    private NightTimeRunnable task;

    @Override
    protected void onPluginStart() {



        task = new NightTimeRunnable();

        

        task.runTaskTimer(this, 0, 1200);

        registerCommand(new NocCommand("noc"));
        registerCommand(new DzienCommand("dzien"));

        Common.logFramed("&aZaładowano głosowanie na dzień.");
    }

    @Override
    protected void onPluginStop() {
        
    }
}
