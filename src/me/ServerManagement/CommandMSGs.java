package me.ServerManagement;

import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public abstract class CommandMSGs
{

    public static final String NO_PERMS = ChatColor.RED + "You don't have permission to access this command!\nTry again later!";
    public static final String UNKNOWN_P = ChatColor.RED + "That player cannot be found!\nTry again later!";
    public static final String U_R_OP = ChatColor.YELLOW + "You are now op!";
    public static final String U_R_NOOP = ChatColor.YELLOW + "You are no longer op!";
    protected ServerManagement plugin;
    protected Server server;
    private CommandSender commandSender;
    private Class<?> commandClass;

    abstract public boolean run(final CommandSender sender, final Player sender_p, final Command cmd, final String commandLabel, final String[] args, final boolean senderIsConsole);

    public void setup(final ServerManagement plugin, final CommandSender commandSender, final Class<?> commandClass)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
        this.commandSender = commandSender;
        this.commandClass = commandClass;
    }

}
