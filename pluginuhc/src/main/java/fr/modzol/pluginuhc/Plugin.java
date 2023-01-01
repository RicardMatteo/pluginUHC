package fr.modzol.pluginuhc;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.modzol.pluginuhc.Enums.GState;
import fr.modzol.pluginuhc.Manager.PvpManager;
import fr.modzol.pluginuhc.Manager.TeamManager;
import fr.modzol.pluginuhc.Manager.TeamTP;
import fr.modzol.pluginuhc.commands.CommandHandler;
import fr.modzol.pluginuhc.commands.feedCommand;
import fr.modzol.pluginuhc.commands.healCommand;
import fr.modzol.pluginuhc.commands.startCommand;
import fr.modzol.pluginuhc.listeners.CutCleanListener;
import fr.modzol.pluginuhc.listeners.PluginListeners;

/*
 * pluginuhc java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("pluginuhc");

  private GState state;
  private List<Player> players = new ArrayList<>();
  private List<List<Player>> Teams = new ArrayList<>();
  private TeamManager tm = new TeamManager(this);
  private Heal heal = new Heal(this);
  private List<Player> Spectators = new ArrayList<>();
  private TeamTP tpt = new TeamTP(this);
  private PvpManager pvpManager = new PvpManager(this);

  private int Nb_Player = Bukkit.getOnlinePlayers().size();
  private int NbMax_Player = 10;

  public void onEnable()
  {
    LOGGER.info("pluginuhc enabled");
    setState(GState.WAITING);
    tm.init();
    // Get all the commands
    getCommand("bc").setExecutor(new CommandHandler(this));
    getCommand("feed").setExecutor(new feedCommand(this));
    getCommand("fh").setExecutor(new CommandHandler(this));
    getCommand("heal").setExecutor(new healCommand(this));
    getCommand("start").setExecutor(new startCommand(this));

    // Get all the listeners
    getServer().getPluginManager().registerEvents(new PluginListeners(this), this);
    getServer().getPluginManager().registerEvents(new CutCleanListener(), this);
    
  }

  public int GetNb_Player(){
    return this.Nb_Player;
  }

  public int GetNbMax_Player(){
    return this.NbMax_Player;
  }
  public void AddPlayerCount() {
    this.Nb_Player++;
  }

  public void RemovePlayerCount() {
    this.Nb_Player--;
  }

  public void setState(GState state) {
    this.state = state; 
  }

  public boolean isState(GState state){
    return this.state == state;
  }

  public void onDisable()
  {
    LOGGER.info("pluginuhc disabled");
  }

  public List<Player> getPlayers() {
    return this.players;
  }

  public TeamManager getTeamManager(){
    return this.tm;
  }

  public Heal getHeal()
  {
    return this.heal;
  }

  public List<Player> getSpectators() {
    return this.Spectators;
  }

  public TeamTP getTPTeam()
  {
    return this.tpt;
  }

  public PvpManager getPvpManager()
  {
    return this.pvpManager;
  }
  //public List<List<Player>>;

}
