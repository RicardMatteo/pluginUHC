package fr.modzol.pluginuhc;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Heal {

    private Plugin main;

    public Heal(Plugin plugin)
    {
        this.main = plugin;
    }
    
    public  void HealPlayer(Player player)
    {
        player.setHealth(player.getMaxHealth());
    }

    public  void HealAll()
    {
        List<Player> players = main.getPlayers();
        for(Player player : players)
        {
            HealPlayer(player);
        }
    }

    public void FinalHeal()
    {
        Bukkit.broadcastMessage("FinalHeal !");
        HealAll();
    }

    public void Feed(Player player)
    {
        player.setFoodLevel(20);
    }
}
