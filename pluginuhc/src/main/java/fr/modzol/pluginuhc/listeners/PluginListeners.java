package fr.modzol.pluginuhc.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;

import java.util.Arrays;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.Wool;

import fr.modzol.pluginuhc.Plugin;
import fr.modzol.pluginuhc.Enums.GState;

public class PluginListeners implements Listener {
    private ItemMeta customM;
    private Plugin main;


    public PluginListeners(Plugin plugin) {
        this.main = plugin;
    }

 
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        org.bukkit.Location Spawn = new org.bukkit.Location(Bukkit.getWorld("world"), 0, 181.5, 0);
        main.AddPlayerCount();
        Player player = event.getPlayer();
        event.setJoinMessage(player.getName() 
                             + " a rejoint la partie ! (" 
                             + String.valueOf(main.GetNb_Player()) 
                             +"/" 
                             + String.valueOf(main.GetNbMax_Player())
                             + ")"
                             ) ;
 
    
        player.teleport(Spawn);

        player.getInventory().clear();
        
        //ItemStack customCompass = new ItemStack(Material.WOOL, 1, (byte)14);
        ItemStack customCompass = new ItemStack(Material.WOOL, 1);
        customM = customCompass.getItemMeta();
        customM.setLore(Arrays.asList("Permet de choisir ton équipe"));
        customCompass.setItemMeta(customM);
        player.getInventory().setItem(0, customCompass);
        //player.getInventory().addItem(new ItemStack(Material.BLUE_WOOL));
        player.updateInventory();
    }


    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack it  = event.getItem();

        if(it == null) return;

        if(!((action == Action.RIGHT_CLICK_AIR) || (action == Action.RIGHT_CLICK_BLOCK))) return;
        
        if(it.getType() == Material.WOOL && it.hasItemMeta() && it.getItemMeta().equals(customM)){
            if(action == Action.RIGHT_CLICK_BLOCK) {
                event.setCancelled(true);
            }
            //player.sendMessage("click");

            Inventory inv = main.getTeamManager().getInventory();
            player.openInventory(inv);   
        }
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        main.RemovePlayerCount();
        if(main.isState(GState.WAITING)) 
        {
            Player player = event.getPlayer();
            main.getTeamManager().RemovePlayerFromHisTeam(player);
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        ItemStack item = event.getCurrentItem();
        //Inventory inv = event.getInventory();
        Player player = (Player) event.getWhoClicked();
        if (item.getType() == Material.WOOL)
        {
            Boolean cancel= main.getTeamManager().JoinTeamCheck(item, player);           
            player.closeInventory();
            event.setCancelled(cancel);

        }

    }
    
}
