package pl.fabrykacraft.voteday.Runnables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.model.Countdown;

import pl.fabrykacraft.voteday.cache.Vote;


public class NightTimeRunnable extends BukkitRunnable {

    @Override
    public void run() {


        if (Bukkit.getServer().getOnlinePlayers().size() > 0) {

            long time = Bukkit.getServer().getWorld("world").getTime();


        Vote vote = Vote.getInstance();
        if ((time > 12300)) {

            if (!vote.getIsOn() && !vote.getWasVoted()) {


                Countdown countdown = new Countdown(30) {

                    @Override
                    protected void onStart() {
                        vote.setIsOn(true);
                        
                        Common.broadcast("&a&l[GŁOSOWANIE] &bWłaśnie rozpoczęło się głosowanie na dzień");
                        Common.broadcast("&bJeśli chcesz pozostawić noc użyj /noc, a jeśli chcesz dzień użyj /dzien");
                        
                    }
    
                    @Override
                    protected void onTick() {
                      
                        
                    }
    
                    @Override
                    protected void onEnd() {
                     
                        if (vote.getPlayersWhoDay().size() > 0) {
    
    
                            if (vote.getPlayersWhoDay().size() >= vote.getPlayersWhoNight().size()) {
                                Bukkit.getServer().getWorld("world").setTime(1000);
                                Common.broadcast("&a&l[GŁOSOWANIE] &bNadszedł dzień");
                                Common.broadcast("&a&l[G] &dGłosy na dzień: " + vote.getPlayersWhoDay().size());
                                Common.broadcast("&a&l[G] &dGłosy na noc: " + vote.getPlayersWhoNight().size());
                            } else if (vote.getPlayersWhoNight().size() > vote.getPlayersWhoDay().size()) {
                                Common.broadcast("&a&l[GŁOSOWANIE] &bPozostaje noc");
                                Common.broadcast("&a&l[G] &dGłosy na dzień: " + vote.getPlayersWhoDay().size());
                                Common.broadcast("&a&l[G] &dGłosy na noc: " + vote.getPlayersWhoNight().size());
                            } 
                        } else {
                            Common.broadcast("&a&l[G] &bBrak głosów, noc pozostaje.");
                        }
                        
    
                        vote.setIsOn(false);
                        vote.setWasVoted(true);
                        vote.clearPlayer();
    
                        
                    }
                    
                };
    
                countdown.launch();


            }


            


        
            

        } else if (vote.getWasVoted()) {
            vote.setWasVoted(false);
        }
        
        

        } 
        

    
    }
}

    



    
