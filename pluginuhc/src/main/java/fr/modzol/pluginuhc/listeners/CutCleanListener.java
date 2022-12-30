package fr.modzol.pluginuhc.listeners;


import java.util.Collection;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

import javafx.event.Event;
import javafx.scene.input.DragEvent;


public class CutCleanListener implements Listener {
    
    
    @EventHandler
    public void OnBlockBreak(BlockBreakEvent event)
    {
        ItemStack tool = event.getPlayer().getInventory().getItemInHand();
        Collection<ItemStack> drops = event.getBlock().getDrops(tool);

        switch (event.getBlock().getType())
        {
            case IRON_ORE:
            case GOLD_ORE:
                event.setExpToDrop(1);
                   
            default:
                break;
        }
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event)
    {
        switch (event.getEntity().getItemStack().getType())
        {
            case IRON_ORE:
                event.getEntity().getItemStack().setType(Material.IRON_INGOT);
                break;
            case GOLD_ORE:
                event.getEntity().getItemStack().setType(Material.GOLD_INGOT);
                break;
            case RAW_BEEF:
            case RAW_CHICKEN:
            case PORK:
            case RAW_FISH:
            case MUTTON:
            case RABBIT:
                event.getEntity().getItemStack().setType(Material.COOKED_BEEF);
                
            default:
                break;
        }
    }
}
