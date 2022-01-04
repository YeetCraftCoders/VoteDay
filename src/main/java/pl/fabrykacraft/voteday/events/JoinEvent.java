package pl.fabrykacraft.voteday.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.mineacademy.fo.Common;

import pl.fabrykacraft.voteday.cache.Vote;

public class JoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        
        Vote vote = Vote.getInstance();

        if (vote.getIsOn()) {
            Common.tell(event.getPlayer(), "&a&l[G] &bDołączyłeś podczas głosowania na dzień\n" +
            "&bUżyj /dzien, jeśli chcesz dzień albo /noc, jeśli chcesz noc.");
        }
    }
    
}
