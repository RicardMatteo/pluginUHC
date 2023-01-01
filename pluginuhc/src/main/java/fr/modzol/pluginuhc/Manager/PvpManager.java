package fr.modzol.pluginuhc.Manager;

import fr.modzol.pluginuhc.Plugin;
import fr.modzol.pluginuhc.Enums.GState;

public class PvpManager 
{
    private Plugin main;
    
    public PvpManager(Plugin plugin)
    {
        this.main = plugin;
    }

    public boolean canPVP()
    {
        return main.isState(GState.FIGHTING);
    }


}
