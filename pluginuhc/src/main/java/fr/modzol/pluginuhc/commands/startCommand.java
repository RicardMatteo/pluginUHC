package fr.modzol.pluginuhc.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.modzol.pluginuhc.Plugin;
import fr.modzol.pluginuhc.Tasks.StartTask;
import javafx.concurrent.Task;
import javafx.scene.paint.Color;

public class startCommand implements CommandExecutor{

    private Plugin main;

    public startCommand(Plugin plugin)
    {
        this.main = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player)sender;

            if(command.getName().equalsIgnoreCase("start")){

                player.sendMessage("Vous avez lancé la partie");
                StartTask sTask = new StartTask(main);
                sTask.runTaskTimer(main, 0, 20);
            }
            return true;
        }
        return false;
    }
    
}
