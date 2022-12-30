package fr.modzol.pluginuhc.listeners;


import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.ItemSpawnEvent;


public class CutCleanListener implements Listener {
    
    
    @EventHandler
    public void OnBlockBreak(BlockBreakEvent event)
    {

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
            case ROTTEN_FLESH:
                event.getEntity().getItemStack().setType(Material.COOKED_BEEF);        
            default:
                break;
        }
    }
}
