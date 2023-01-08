package fr.modzol.pluginuhc.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.inventory.BrewerInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

public class PotionListener implements Listener {
    
    @EventHandler
    public void onPotion(BrewEvent event)
    {
        BrewerInventory items = event.getContents();
        ItemStack StrengthPotion = new ItemStack(Material.POTION, 8201);
        if(items.getIngredient().getType() == Material.GLOWSTONE_DUST)
        {
            event.setCancelled(true);
            
            for (ItemStack potion : items) {
                if(potion.isSimilar(StrengthPotion) && potion.getData().getItemTypeId() ==  8201)
                {
                }
            }
        }
    }
}
