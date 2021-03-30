package com.github.michaljaz.manhunt;

import com.github.michaljaz.manhunt.MyCommand;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("PlayerUsername", true);
        config.options().copyDefaults(true);
        saveConfig();
        // Copy the config.yml in the plugin configuration folder if it doesn't exists.
        getLogger().info(ChatColor.GREEN+"ENABLED MANHUNT PLUGIN!");
        // TODO : Do something if your plugin needs it (registering commands / listeners)
        this.getCommand("compass").setExecutor(new MyCommand());
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED+"DISABLED MANHUNT PLUGIN");
        // TODO : Do something if your plugin needs it (saving custom configs, clearing cache, closing connections...)
    }

}