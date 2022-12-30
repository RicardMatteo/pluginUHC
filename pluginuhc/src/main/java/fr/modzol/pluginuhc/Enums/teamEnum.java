package fr.modzol.pluginuhc.Enums;

import org.bukkit.ChatColor;
import org.bukkit.DyeColor;

public enum teamEnum {

    ROUGE("Rouge", ChatColor.RED, DyeColor.RED, (byte) 14),
    ORANGE("Orange", ChatColor.GOLD, DyeColor.ORANGE, (byte) 1),
    YELLOW("Jaune", ChatColor.YELLOW, DyeColor.YELLOW, (byte) 4),
    LIME("Lime", ChatColor.GREEN, DyeColor.LIME, (byte) 5),
    VERT("Vert", ChatColor.GREEN, DyeColor.GREEN, (byte) 13),
    AQUA("Cyan", ChatColor.AQUA, DyeColor.CYAN, (byte) 9),
    LIGHT_BLUE("Bleu clair", ChatColor.BLUE, DyeColor.LIGHT_BLUE, (byte) 3),
    MAGENTA("Magenta", ChatColor.LIGHT_PURPLE, DyeColor.MAGENTA, (byte) 2),
    PINK("Rose", ChatColor.LIGHT_PURPLE, DyeColor.PINK, (byte) 6),
    BLACK("Noir", ChatColor.BLACK, DyeColor.BLACK, (byte) 15),
    DARK_GREEN("Vert foncé", ChatColor.DARK_GREEN, DyeColor.GREEN, (byte) 13),
    DARK_AQUA("Cyan foncé", ChatColor.DARK_AQUA, DyeColor.CYAN, (byte) 9),
    DARK_BLUE("Bleu foncé", ChatColor.DARK_BLUE, DyeColor.BLUE, (byte) 11),
    BLEU("Bleu", ChatColor.BLUE, DyeColor.BLUE, (byte) 11),
    JAUNE("Jaune", ChatColor.YELLOW, DyeColor.YELLOW, (byte) 4),
    
    DARK_PURPLE("Violet foncé", ChatColor.DARK_PURPLE, DyeColor.PURPLE,(byte)12),
    WHITE("Blanc", ChatColor.WHITE, DyeColor.WHITE, (byte) 0),
    DARK_RED("Rouge foncé", ChatColor.DARK_RED, DyeColor.RED, (byte) 14);

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
