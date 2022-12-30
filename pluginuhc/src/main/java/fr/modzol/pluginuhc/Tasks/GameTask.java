package fr.modzol.pluginuhc.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.modzol.pluginuhc.Heal;
import fr.modzol.pluginuhc.Plugin;
import fr.modzol.pluginuhc.Enums.GState;


public class GameTask extends BukkitRunnable {
    private int timer = 0;
    private final int TimePVP = 20 * 20 * 60;
    private final int FIVE_MINUTES =  20 * 5 * 60;
    private Plugin main;

    public GameTask(Plugin plugin) {
        this.main = plugin;
    }

    @Override
    public void run() {
        switch (timer)
        {
            case (TimePVP - FIVE_MINUTES):
                Bukkit.broadcastMessage("Activation du pvp dans 5 minutes");
            case TimePVP:
                main.getHeal().FinalHeal();
                Bukkit.broadcastMessage("Activation du pvp");
                main.setState(GState.FIGHTING);

            }
      
        if(timer == TimePVP) {
            
            
        }
    }
}
