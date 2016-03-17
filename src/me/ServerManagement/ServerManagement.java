package me.ServerManagement;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerManagement extends JavaPlugin {
	public static ServerManagement plugin;
	/*
	 * 
	 * Enabling/Disabling System
	 */
	@Override
	public void onEnable() {
		/*
		 * When Starting display this message:
		 * 
		 * [Server thread/INFO]: [ServerManagement] Enabling ServerManagement v5.05
		 * [Server thread/INFO]: - Starting ServerManagement 5.05 by falceso.
		 * [Server thread/INFO]: - Orginally made for the CosmicNetworks server; owned by falceso
		 */
		
		Bukkit.getLogger().info(" - Starting ServerManagement " + getDescription().getVersion()+ " by " + getDescription().getAuthors());
		Bukkit.getLogger().info(" - Orginally made for the CosmicNetworks server; owned by falceso");
	}

	@Override
	public void onDisable() {
		Bukkit.getLogger().info("ALERT: Server has stopped responding! HELP!");
		Bukkit.getLogger().info(" - Disabling ServerManagement "+ getDescription().getVersion() + " by " + getDescription().getAuthors());
	}
}
