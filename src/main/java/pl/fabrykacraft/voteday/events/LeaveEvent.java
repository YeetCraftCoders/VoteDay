package pl.fabrykacraft.voteday.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.fabrykacraft.voteday.cache.Vote;

public class LeaveEvent implements Listener {
    

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        
        Vote vote = Vote.getInstance();

        Player player = event.getPlayer();

        if (vote.getIsOn() && vote.getPlayersWhoVoted().contains(player)) {

            if (vote.getPlayersWhoDay().contains(player)) {
                vote.getPlayersWhoDay().remove(player);
            } else if (vote.getPlayersWhoNight().contains(player)) {
                vote.getPlayersWhoNight().remove(player);
            }
            vote.getPlayersWhoVoted().remove(player);
        }
    }
}
