package me.ServerManagement.listener;
/*
 * Commented to remove errors with imports :P
import me.ServerManagement.AsyncPlayerChatEvent;
import me.ServerManagement.CommandSender;
import me.ServerManagement.EventHandler;
import me.ServerManagement.Player;
import me.ServerManagement.PlayerJoinEvent;
import me.ServerManagement.PlayerQuitEvent;
import me.ServerManagement.ServerListPingEvent;
*/
import me.ServerManagement.ServerManagement;





import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
//import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerListener extends JavaPlugin implements Listener {
     ServerManagement plugin;
     public PlayerListener (ServerManagement passedPlugin)
     {
     	this.plugin = passedPlugin;
     	plugin.getServer().getPluginManager().registerEvents(this, plugin);
     }
	
     @EventHandler
     public void joinAndOther(PlayerJoinEvent event)
     {
       Player player = event.getPlayer();
       if (getConfig().getStringList("owners").contains(player.getName())) 
       {
         event.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GRAY + " is the " + ChatColor.RED + "Owner" + ChatColor.GRAY + " of the server" + ChatColor.DARK_GRAY + "!");
         player.setOp(true);
         player.setPlayerListName(ChatColor.RED + "Owner" + ChatColor.WHITE + player.getName());
       }
       if (getConfig().getStringList("coowners").contains(player.getName())) {
         event.setJoinMessage(ChatColor.AQUA + player.getName() + ChatColor.GRAY + " is the " + ChatColor.DARK_AQUA + "Co Owner" + ChatColor.GRAY + " of the server" + ChatColor.DARK_GRAY + "!");
         player.setOp(true);
         player.setPlayerListName(ChatColor.DARK_AQUA + "CoOwner" + ChatColor.WHITE + player.getName());       	
       }
     }
     
    }
