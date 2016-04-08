package me.ServerManagement;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import static me.ServerManagement.SM_PlayerUtil.COOWNER;

public class SM_PlayerListener implements Listener
{

    public SM_PlayerListener(ServerManagement plugin)
    {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e)
    {
        Player player = e.getPlayer();
        if (player.getName().equalsIgnoreCase("falceso"))
        {
            player.setPlayerListName(ChatColor.DARK_PURPLE + "Falceso");
            player.setDisplayName("Falceso");
            Bukkit.broadcastMessage(ChatColor.DARK_PURPLE + "Falceso" + ChatColor.GRAY + "," + ChatColor.GRAY + " is a " + ChatColor.DARK_PURPLE + "Founder - First Developer" + ChatColor.GRAY + "of" + ChatColor.DARK_PURPLE + " ServerManagement Development Team");
        }
        if (COOWNER.contains(player.getName()))
        {
            player.setPlayerListName(ChatColor.YELLOW + player.getName());
            Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.GRAY + ", is a " + ChatColor.YELLOW + "Eh-Development Team Member");
            Bukkit.broadcastMessage(ChatColor.YELLOW + player.getName() + ChatColor.GRAY + ", is " + ChatColor.GREEN + "Code Training" + ChatColor.GRAY + "!");
        }

        //If an old player (who already logged into the server) will enter with this login-msg:
        if (player.hasPlayedBefore() == true)
        {
            e.setJoinMessage(ChatColor.GREEN + "Welcome back" + ChatColor.GRAY + ", " + ChatColor.AQUA + player.getName() + ChatColor.GRAY + " to the" + ChatColor.LIGHT_PURPLE + " Server");
        }
        //If a new player log-ins into the server, this well be announced:
        if (player.hasPlayedBefore() == false)
        {
            e.setJoinMessage(ChatColor.GREEN + "Welcome" + ChatColor.GRAY + ", " + ChatColor.AQUA + player.getName() + ChatColor.GRAY + ", to the " + ChatColor.LIGHT_PURPLE + "Server!");
        }
    }
}
