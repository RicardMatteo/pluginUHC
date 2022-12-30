package fr.modzol.pluginuhc;

import java.util.ArrayList;
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


public class TeamManager{
    
    //private int NB_Team = 0;
    private int sizeTeam = 3;
    //private teamEnum teams;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    private List<Team> TeamsList = new ArrayList<>();
    private Map<Team, teamEnum> TeamLink = new HashMap<>();

    private Inventory inv = Bukkit.createInventory(null, 27, "§bChoisi ton équipe");

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
        for(OfflinePlayer OffPlayer : OffPlayers )
        {
            names.add("| " + OffPlayer.getName());
        }
        for(int j = names.size(); j < sizeTeam; j++)
        {
            names.add("| Place libre");
        }
        customM.setDisplayName(_teamEnum.getColorChat() + _teamEnum.getName());
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

    public boolean JoinTeamCheck(ItemStack item, Player player)
    {
        for(Team team : TeamsList)
        {
            if(item.equals(getWool(team)))
            {
                RemovePlayerFromHisTeam(player);
                if (team.getSize() >= sizeTeam)
                {
                    player.sendMessage("§6La team est full :(");
                    return false;
                }
                team.addEntry(player.getName());
                initInv();
                /*if(item.getItemMeta().hasLore()){
                    List<String> Lore = item.getItemMeta().getLore();
                    Lore.set(sizeTeam, player.getName()); 
                }*/

                player.sendMessage(TeamLink.get(team).getColorChat() + "Vous avez rejoint l'équipe " + team.getName()); 
                return true;
            }
        }
        player.sendMessage("Team non trouvé :(");
        return false; 
    }

}