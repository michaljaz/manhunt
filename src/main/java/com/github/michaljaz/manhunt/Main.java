package com.github.michaljaz.manhunt;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("runnerNick", "Dream");
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info(ChatColor.RED + config.getString("runnerNick"));
        // Copy the config.yml in the plugin configuration folder if it doesn't exists.
        getLogger().info(ChatColor.GREEN + "ENABLED MANHUNT PLUGIN!");
        // TODO : Do something if your plugin needs it (registering commands / listeners)
        this.getCommand("compass").setExecutor(new Compass());
        this.getCommand("team").setExecutor(new Team());
        this.getCommand("team").setTabCompleter(new Completer());
        this.getCommand("start").setExecutor(new Start());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "DISABLED MANHUNT PLUGIN");
        // TODO : Do something if your plugin needs it (saving custom configs, clearing cache, closing connections...)
    }
}