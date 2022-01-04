package pl.fabrykacraft.voteday.commands;

import org.bukkit.entity.Player;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import pl.fabrykacraft.voteday.cache.Vote;

public class NocCommand extends SimpleCommand {

    public NocCommand(String label) {
        super(label);
        
    }

    @Override
    protected void onCommand() {
        
        Vote vote = Vote.getInstance();
        
        Player player = getPlayer();

        if (vote.getIsOn() && !vote.getPlayersWhoVoted().contains(player)) {

            vote.getPlayersWhoNight().add(player);
            vote.getPlayersWhoVoted().add(player);
        } else if (!vote.getIsOn()) {
            Common.tell(player, "&a&l[G] &bAktualnie nie ma głosowania");
        } else if (vote.getPlayersWhoVoted().contains(player)) {
            Common.tell(player, "&a&l[G] &bJuż zagłosowałeś");
        }
        
    }
    
}
