package pl.fabrykacraft.voteday.cache;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import lombok.Getter;
import lombok.Setter;

public class Vote {


    private static Vote vote;

    @Getter @Setter Boolean isOn;
    @Getter @Setter Boolean wasVoted;

    @Getter @Setter List<Player> playersWhoVoted = new ArrayList<Player>();
    @Getter @Setter List<Player> playersWhoNight = new ArrayList<Player>();
    @Getter @Setter List<Player> playersWhoDay = new ArrayList<Player>();
    

    private Vote() {
        
        
        setIsOn(false);
        playersWhoVoted.clear();
        playersWhoDay.clear();
        playersWhoNight.clear();;
        setWasVoted(false);

    }

    public void clearPlayer() {
        vote.playersWhoDay.clear();
        vote.playersWhoNight.clear();
        vote.playersWhoVoted.clear();
    }

    public static Vote getInstance() {
        if (vote == null) {
            vote = new Vote();

        }
        return vote;
    }

    
    
}
