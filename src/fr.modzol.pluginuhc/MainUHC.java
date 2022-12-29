package fr.modzol.pluginuhc;

import org.bukkit.plugin.java.JavaPlugin;

public class MainUHC extends JavaPlugin {

    @override
    public void onEnable(){
        System.out.println("Plugin UHC on");
        getCommand("host").setExecutor(new HostCommand());
    }

    @override
    public void onEnable(){
        System.out.println("Plugin UHC off");
        getCommand().
    }
}