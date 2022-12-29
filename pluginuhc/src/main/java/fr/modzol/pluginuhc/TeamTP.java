package fr.modzol.pluginuhc;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;


public class TeamTP {

    private static final double RAYON = 10; // Définissez ici le rayon du cercle
    private static final double CENTRE_X = 0; // Définissez ici les coordonnées X du centre du cercle
    private static final double CENTRE_Z = 0; // Définissez ici les coordonnées Z du centre du cercle
    private static final double Y = 180; // Définissez ici les coordonnées Y de la position des joueurs sur le cercle

    public static void TeamTP() {
        
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        int nombreDEquipes = scoreboard.getTeams().size();
        World world = Bukkit.getWorld("world");
        int numeroEquipe = 0;
        for (Team equipe : scoreboard.getTeams()) {
            /*String prefix = equipe.getPrefix();

            // Extraction du code de couleur du préfixe
            char couleur = prefix.charAt(1);

            // Conversion du code de couleur en donnée de bloc
            byte couleurBloc = DyeColor.getByChar(couleur).getData();
            //byte couleurBloc = equipe.getColor().getData();*/
            //int numeroEquipe = equipe.getName().charAt(equipe.getName().length() - 1) - '0';
            
            numeroEquipe++;
            double angle = (360.0 / nombreDEquipes) * (numeroEquipe - 1);
            double x = CENTRE_X + RAYON * Math.cos(Math.toRadians(angle));
            double z = CENTRE_Z + RAYON * Math.sin(Math.toRadians(angle));
            Location location = new Location(Bukkit.getWorld("world"), x, Y+2, z);
            
            for (int i = (int) x - 2; i <= (int) x + 2; i++) {
                for (int j = (int) z - 2; j <= (int) z + 2; j++) {
                    Block block = world.getBlockAt(i, (int) Y, j);
                    block.setType(Material.GLASS);
                    //block.setData();
                }
            }

            for (OfflinePlayer offjoueur : equipe.getPlayers()) {
                Player joueur = offjoueur.getPlayer();
                joueur.teleport(location);
            }
        }
    }

    /*private byte getByteColor(char couleur) {
        DyeColor couleurDyeColor;
        switch (couleur) {
            case '0':
                couleurDyeColor = DyeColor.valueOf("BLACK");
                break;
            case '1':
                couleurDyeColor = DyeColor.valueOf("DARK_BLUE");
                break;
            case '2':
                couleurDyeColor = DyeColor.valueOf("DARK_GREEN");
                break;
            case '3':
                couleurDyeColor = DyeColor.valueOf("DARK_AQUA");
                break;
            case '4':
                couleurDyeColor = DyeColor.valueOf("DARK_RED");
                break;
            case '5':
                couleurDyeColor = DyeColor.valueOf("DARK_PURPLE");
                break;
            case '6':
                couleurDyeColor = DyeColor.valueOf("GOLD");
                break;
            case '7':
                couleurDyeColor = DyeColor.valueOf("GRAY");
                break;
            case '8':
                couleurDyeColor = DyeColor.valueOf("DARK_GRAY");
                break;
            case '9':
                couleurDyeColor = DyeColor.valueOf("BLUE");
                break;
            case 'a':
                couleurDyeColor = DyeColor.valueOf("GREEN");
                break;
            case 'b':
                couleurDyeColor = DyeColor.valueOf("AQUA");
                break;
            case 'c':
                couleurDyeColor = DyeColor.valueOf("RED");
                break;
            case 'd':
                couleurDyeColor = DyeColor.valueOf("LIGHT_PURPLE");
                break;
            case 'e':
                couleurDyeColor = DyeColor.valueOf("YELLOW");
                break;
            case 'f':
                couleurDyeColor = DyeColor.valueOf("WHITE");
                break;
            default:
                couleurDyeColor = DyeColor.valueOf("WHITE");
                break;
                
            }
        byte couleurBloc = Material.WOOL.getWoolData(couleurDyeColor);
    }*/

    
}
