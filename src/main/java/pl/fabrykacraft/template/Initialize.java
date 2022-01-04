package pl.fabrykacraft.template;


import org.mineacademy.fo.Common;
import org.mineacademy.fo.plugin.SimplePlugin;


public class Initialize extends SimplePlugin {




    @Override
    protected void onPluginStart() {



        Common.logFramed("&aArchetype loaded. ");
    }

    @Override
    protected void onPluginStop() {
        
    }
}
