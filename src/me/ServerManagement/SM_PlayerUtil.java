package me.ServerManagement;

import java.util.List;
import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SM_PlayerUtil
{
    // Do not remove these listed names - you can change the rank name tho
    public static final List<String> SMDEVELOPERS = Arrays.asList("falceso");
    public static final List<String> FOUNDER = Arrays.asList("");
    public static final List<String> COOWNER = Arrays.asList("");
    public static final List<String> DEVELOPER = Arrays.asList("");
    public static final List<String> ADMIN = Arrays.asList("");
    public static final List<String> MODERATOR = Arrays.asList("");
    public static final List<String> TRIALMOD = Arrays.asList("");
    // Copy the following..
    //public static final List<String> CUSTOMRANK = Arrays.asList("SanikIsFast");
    

    public static final List<ChatColor> otherColors = Arrays.asList(
            ChatColor.DARK_BLUE,
            ChatColor.DARK_GREEN,
            ChatColor.DARK_AQUA,
            ChatColor.DARK_RED,
            ChatColor.DARK_PURPLE,
            ChatColor.GOLD,
            ChatColor.BLUE,
            ChatColor.GREEN,
            ChatColor.AQUA,
            ChatColor.RED,
            ChatColor.LIGHT_PURPLE,
            ChatColor.YELLOW
    );

    public static void bcMsg(String message, ChatColor color)
    {
        SM_Log.info(message, true);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcMsg(String message)
    {
        SM_PlayerUtil.bcMsg(message, null);
    }

}
