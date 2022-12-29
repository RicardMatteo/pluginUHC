package fr.modzol.pluginuhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHandler implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if(command.getName().equalsIgnoreCase("bc")){
                if(args.length == 0){
                    player.sendMessage("La commande est /bc <message>");
                } else {
                    StringBuilder bc = new StringBuilder();
                    for(String part : args){
                        bc.append(part + " ");
                    }
                    Bukkit.broadcastMessage(bc.toString());
                }
            }
            return true;
        }
        return false;
    }
    
}
