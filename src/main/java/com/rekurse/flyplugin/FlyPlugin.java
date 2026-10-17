package com.rekurse.flyplugin; // made by Rekurse (github: github.com/rekurse-dev)

import org.bukkit.plugin.java.JavaPlugin;
import com.rekurse.flyplugin.managers.PluginManager;
import com.rekurse.flyplugin.listeners.PlayerListener;
import com.rekurse.flyplugin.commands.flyCommand;

public class FlyPlugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        
        // Initialize managers
        PluginManager.getInstance().initialize();
        
        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        
        // Register commands
        this.getCommand("fly").setExecutor(new flyCommand());
        
        getLogger().info(getPluginMeta().getName() + " has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info(getPluginMeta().getName() + " has been disabled!");
    }
    
}
