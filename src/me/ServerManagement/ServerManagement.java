package me.ServerManagement;

import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerManagement extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        new SM_PlayerListener(this);
        
        /*
		 * When enabling display this message:
		 * 
		 * [Server thread/INFO]: [ServerManagement] Enabling ServerManagement v1.2.5
		 * [Server thread/INFO]: - Starting ServerManagement 1.2.5 by falceso, and Aspectful.
		 * [Server thread/INFO]: - Orginally made for the CosmicNetworks server; owned by falceso
		 */
		
		Bukkit.getLogger().info(" - Starting ServerManagement " + getDescription().getVersion()+ " by " + getDescription().getAuthors());
		Bukkit.getLogger().info(" - Orginally made for the CosmicNetworks server; owned by falceso");
    }

    @Override
    public void onDisable()
    {
    	/*
		 * When disabling display this message:
		 * 
		 * [Server thread/INFO]: [ServerManagement] Enabling ServerManagement v1.2.5
		 * [Server thread/INFO]: - Starting ServerManagement 1.2.5 by falceso, and Aspectful.
		 * [Server thread/INFO]: - Orginally made for the CosmicNetworks server; owned by falceso
		 */
		 
		Bukkit.getLogger().info("ALERT: Server has stopped responding! HELP!");
		Bukkit.getLogger().info(" - Disabling ServerManagement "+ getDescription().getVersion() + " by " + getDescription().getAuthors());
		
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("cmc"))
        {

            for (int i = 0; i <= 150; i++)
            {
                sender.sendMessage("");
            }
            sender.sendMessage(ChatColor.GRAY + "You ran '/cmc', your chat has now been " + ChatColor.GREEN + "cleared" + ChatColor.GRAY + "!");
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("cc"))
        {
            for (int i = 0; i <= 150; i++)
            {
                Bukkit.broadcastMessage("");
            }
            Bukkit.broadcastMessage(ChatColor.DARK_GRAY + "[" + ChatColor.GREEN + "ServerManagement" + ChatColor.DARK_GRAY + "] " + ChatColor.AQUA + sender.getName() + ChatColor.BLUE + " has cleared the Global Chat" + ChatColor.GRAY + "!");
            return false;
        }
        if (cmd.getName().equalsIgnoreCase("sm"))
        {

            if (args.length == 1)
            {
                if (!args[0].equals("reload"))
                {
                    return false;
                }
                if (!SM_PlayerUtil.FOUNDER.contains(sender.getName()) && (!SM_PlayerUtil.SMDEVELOPERS.contains(sender.getName()) && (!SM_PlayerUtil.COOWNER.contains(sender.getName()))))
                {
                    player.sendMessage(ChatColor.RED + "You don't have permission to access this command!");
                    return false;
                }

                final String message = String.format(ChatColor.RED + "ServerManagement plugin has been reloaded" + ChatColor.GRAY + "!");
            }
            player.sendMessage(ChatColor.GRAY + " - " + ChatColor.GREEN + "Server" + ChatColor.DARK_RED + "Mangement");
            player.sendMessage(ChatColor.BLUE + "Orginally created by" + ChatColor.GRAY + ": " + ChatColor.DARK_PURPLE + "falceso, and the ServerMangement Development Team");
            player.sendMessage(ChatColor.AQUA + "Plugin Version" + ChatColor.GOLD + getDescription().getVersion());
            player.sendMessage(ChatColor.YELLOW + "Do you like this plugin? Do /ilikesm");

        }
        if (cmd.getName().equalsIgnoreCase("ilikesm"))
        {

            player.sendMessage(ChatColor.GREEN + "Like ServerManagement?" + ChatColor.GRAY + "?");
            player.sendMessage(ChatColor.GRAY + "Why not " + ChatColor.LIGHT_PURPLE + "Join" + ChatColor.GRAY + "Our discord and thank us!");
            player.sendMessage(ChatColor.BLUE + "https://discord.gg/0w6a1hiwjLKpnXvF");
        }
		return false;
        }
            public static final List<ChatColor> BACKUPCOLORS = Arrays.asList(
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

    public static void bcastMsg(String message, ChatColor color)
    {
        SM_Log.info(message, true);

        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        ServerManagement.bcastMsg(message, null);
    }

}
