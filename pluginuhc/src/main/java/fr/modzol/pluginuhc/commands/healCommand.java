package fr.modzol.pluginuhc.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.modzol.pluginuhc.Plugin;

public class healCommand implements CommandExecutor{

    Plugin main;

    public healCommand(Plugin Plugin)
    {
        this.main = Plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;
            if(command.getName().equalsIgnoreCase("heal")){
                main.getHeal().HealPlayer(player);
                return true;
            }
        
        }
        return false;
    }
}