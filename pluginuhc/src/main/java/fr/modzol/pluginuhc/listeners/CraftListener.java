package fr.modzol.pluginuhc.listeners;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class CraftListener implements Listener {
    
    @EventHandler
    public void OnCraftEvent(CraftItemEvent event)
    {
        ItemStack item = event.getCursor();
        HumanEntity human = event.getWhoClicked();
        
        ItemStack notchApple = new ItemStack(Material.GOLDEN_APPLE);
        notchApple.addUnsafeEnchantment(Enchantment.DURABILITY, 1);
        
        if(notchApple.isSimilar(item))
        {
            
            event.setCancelled(true);
            human.sendMessage("Vous ne pouvez pas crafter ça.");
        }
    }
}
