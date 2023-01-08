package fr.modzol.pluginuhc.listeners;


import org.bukkit.entity.Entity;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
public class RodListener implements Listener {
    
    @EventHandler
    public void OnPlayerFishingPlayer(EntityDamageByEntityEvent event)
    {
        Entity victim = event.getEntity();
        Entity damager = event.getDamager();

        if(damager instanceof FishHook && victim instanceof Player)
        {
            event.setCancelled(true);
            FishHook Hook = (FishHook) damager;
            Player shooter = (Player) Hook.getShooter();
            shooter.sendMessage("La rod est désactivée en PVP");
            Hook.remove();

        }
        
        if(damager instanceof Snowball && victim instanceof Zombie)
        {
            event.setCancelled(true);
            Snowball ball = (Snowball) damager;
            Player shooter = (Player) ball.getShooter();
            shooter.sendMessage("Les snowballs sont désactivées en PVP");
            ball.remove();

        }
       
    }
}
