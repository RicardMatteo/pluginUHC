package fr.modzol.pluginuhc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.modzol.pluginuhc.Enums.teamEnum;
import net.md_5.bungee.api.ChatColor;


public class TeamManager{
    
    //private int NB_Team = 0;
    private int sizeTeam = 3;
    //private teamEnum teams;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    private List<Team> TeamsList = new ArrayList<>();
    private Map<Team, teamEnum> TeamLink = new HashMap<>();

    private Inventory inv = Bukkit.createInventory(null, 27, "§bChoisi ton équipe");
    private Plugin main;

    public TeamManager(Plugin plugin)
    {
        this.main = plugin;
    }
    public void init(){
        

        for (teamEnum teamEn : teamEnum.values()) {
            //NB_Team++;
            if (scoreboard.getTeam(teamEn.getName()) != null)
            {
                scoreboard.getTeam(teamEn.getName()).unregister();
            }
            Team team = scoreboard.registerNewTeam(teamEn.getName());
            team.setPrefix(teamEn.getColorChat() + "");
            TeamLink.put(team, teamEn);
            TeamsList.add(team);
        }

        initInv();

    }

    public ItemStack getWool(Team team){
        teamEnum _teamEnum = TeamLink.get(team);
        ItemStack Wool = new ItemStack(Material.WOOL, 1, _teamEnum.getColorByte());
        ItemMeta customM = Wool.getItemMeta();
        Set<OfflinePlayer> OffPlayers = team.getPlayers();
        List<String> names = new ArrayList<>();
        names.add("");
        for(OfflinePlayer OffPlayer : OffPlayers )
        {
            names.add("| " + OffPlayer.getName());
        }
        for(int j = names.size() - 1; j < sizeTeam; j++)
        {
            names.add(ChatColor.GRAY + "| Place libre");
        }
        customM.setDisplayName(_teamEnum.getColorChat() 
                                + _teamEnum.getName() 
                                + " (" + OffPlayers.size() 
                                + "/"
                                + sizeTeam
                                + ")");
        customM.setLore(names);
        Wool.setItemMeta(customM);
        return Wool;
    }

    private void initInv()
    {
        int index = 0;
        for(Team team : TeamsList)
        {
            this.inv.setItem(index, getWool(team));
            index++;
        }
    }

    public Inventory getInventory()
    {
        return this.inv;
    }

    public void RemovePlayerFromHisTeam(Player player)
    {
        for (Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getName())) {
                team.removeEntry(player.getName());
                initInv();
            }   
        }
    }

    public boolean JoinTeamItem(ItemStack item, Player player)
    {
        for(Team team : TeamsList)
        {
            if(item.equals(getWool(team)))
            {
                return(JoinTeamCheck(team, player));
            }
        }
        player.sendMessage("Team non trouvé :(");
        return false; 
    }

    
    public boolean JoinTeamCheck(Team team, Player player)
    {
        if (team.hasEntry(player.getName()))
        {
            player.sendMessage("§6Vous êtes déjà dans cette équipe");
            return true;
        }
        if (team.getSize() >= sizeTeam)
        {
            player.sendMessage("§6La team est full :(");
            return false;
        }
        team.addEntry(player.getName());
        initInv();
        player.sendMessage(TeamLink.get(team).getColorChat() + "Vous avez rejoint l'équipe " + team.getName()); 
        return true;
    }



    public boolean hasTeam(Player player)
    {
        for (Team team : scoreboard.getTeams()) {
            if (team.hasEntry(player.getName())) {
                return true;
            }   
        }
        return false;
    }

    public void defaultJoinTeam(List<Player> players)
    {
         for (Player player : players)
         {
            if (!hasTeam(player))
            {
                Team team = findTeam();
                Boolean isGameFull = !JoinTeamCheck(team, player);
                if(isGameFull)
                {
                    player.sendMessage("§6La partie est full.");
                    main.getSpectators().add(player);
                }
            }
         }
    }

    public Team findTeam()
    {
        for(Team team : TeamsList)
        {
            if (team.getSize() < sizeTeam)
                {
                        return team;
                } 
        }
        //Bukkit.broadcast("Plus aucune team n'est libre risque de surchage d'équipe", null);
        return TeamsList.get(0);
    }

    public byte getColorData(Team team)
    {
        teamEnum _teamEnum = TeamLink.get(team);
        return ((byte) 3);
        //return _teamEnum.getColorByte();
    }

}