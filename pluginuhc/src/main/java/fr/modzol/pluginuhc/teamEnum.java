package fr.modzol.pluginuhc;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum teamEnum {

    BLACK("team noir", ChatColor.BLACK, DyeColor.BLACK, (byte) 15),
    DARK_BLUE("team bleu foncé", ChatColor.DARK_BLUE, DyeColor.BLUE, (byte) 11),
    DARK_GREEN("team vert foncé", ChatColor.DARK_GREEN, DyeColor.GREEN, (byte) 13),
    DARK_AQUA("team cyan foncé", ChatColor.DARK_AQUA, DyeColor.CYAN, (byte) 9),
    DARK_RED("team rouge foncé", ChatColor.DARK_RED, DyeColor.RED, (byte) 14),
    DARK_PURPLE("team violet", ChatColor.DARK_PURPLE, DyeColor.PURPLE,(byte)12),
    ROUGE("team rouge", ChatColor.RED, DyeColor.RED, (byte) 14),
    BLEU("team bleu", ChatColor.BLUE, DyeColor.BLUE, (byte) 11),
    VERT("team vert", ChatColor.GREEN, DyeColor.GREEN, (byte) 13),
    JAUNE("team jaune", ChatColor.YELLOW, DyeColor.YELLOW, (byte) 4),
    
    WHITE("team blanc", ChatColor.WHITE, DyeColor.WHITE, (byte) 0),
    ORANGE("team orange", ChatColor.GOLD, DyeColor.ORANGE, (byte) 1),
    MAGENTA("team magenta", ChatColor.LIGHT_PURPLE, DyeColor.MAGENTA, (byte) 2),
    LIGHT_BLUE("team bleu clair", ChatColor.BLUE, DyeColor.LIGHT_BLUE, (byte) 3),
    YELLOW("team jaune", ChatColor.YELLOW, DyeColor.YELLOW, (byte) 4),
    LIME("team vert lime", ChatColor.GREEN, DyeColor.LIME, (byte) 5);

    private final String nom;
    private final ChatColor couleurChat;
    private final DyeColor couleurDye;
    private final byte couleurByte;
    private int nombreJoueurs;

    private teamEnum(String nom, ChatColor couleurChat, DyeColor couleurDye, byte couleurByte) {
        this.nom = nom;
        this.couleurChat = couleurChat;
        this.couleurDye = couleurDye;
        this.couleurByte = couleurByte;
    }

    public String getName() {
        return nom;
    }

    public ChatColor getColorChat() {
        return couleurChat;
    }

    public DyeColor getColorDye() {
        return couleurDye;
    }

    public byte getColorByte() {
        return couleurByte;
    }
}
