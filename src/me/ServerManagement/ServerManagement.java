package me.ServerManagement;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ServerManagement extends JavaPlugin {

    /*
     *
     * Enabling/Disabling System
     *
     */
    @Override
    public void onEnable() {
        getConfig().options().copyDefaults(true);
        saveConfig();
        //Insert version
        Bukkit.getLogger().info(" - Starting ServerManagement by falceso.");
        Bukkit.getLogger().info(" - Orginally made for the CosmicNetworks server; owned by falceso");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("ALERT: Server has stopped responding! THE F***"); //Added THE F*** for no reason XD
        Bukkit.getLogger().info(" - Disabling ServerManagement v1.0 by falceso");
    }
}