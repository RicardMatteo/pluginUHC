package fr.modzol.pluginuhc.Tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import fr.modzol.pluginuhc.Plugin;
import fr.modzol.pluginuhc.Enums.GState;


public class StartTask extends BukkitRunnable{

    private int timer = 5;
    private Plugin main;

    public StartTask(Plugin plugin) {
        this.main = plugin;
    }

    @Override
    public void run() {
        
        if(timer == 0) {
            Bukkit.broadcastMessage("Lancement de la partie");
            main.setState(GState.CAVING);
            cancel();
            
        }
        
    }

}