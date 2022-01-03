package me.flour.discordwl.commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

import me.clip.placeholderapi.PlaceholderAPI;

public class Stats extends SimpleCommand {

    public Stats(String label) {
        super(label);
        
    }

    @Override
    public void onCommand() {
        Player player = getPlayer();

        String statText = "Your death count is %plan_player_death_count%";



        OfflinePlayer player2 = Bukkit.getOfflinePlayer(player.getUniqueId());
        
       

        Bukkit.getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("DiscordWL"), () -> {

        
            PlaceholderAPI.setPlaceholders(player2, statText);

        }, 0);


        player.sendMessage(statText);

        
    }
    
}
