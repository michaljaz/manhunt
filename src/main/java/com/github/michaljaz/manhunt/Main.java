package com.github.michaljaz.manhunt;

import com.github.michaljaz.manhunt.Compass;
import com.github.michaljaz.manhunt.Team;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.addDefault("runnerNick", "Dream");
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info(ChatColor.RED+config.getString("runnerNick"));
        // Copy the config.yml in the plugin configuration folder if it doesn't exists.
        getLogger().info(ChatColor.GREEN+"ENABLED MANHUNT PLUGIN!");
        // TODO : Do something if your plugin needs it (registering commands / listeners)
        this.getCommand("compass").setExecutor(new Compass());
        this.getCommand("team").setExecutor(new Team());
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED+"DISABLED MANHUNT PLUGIN");
        // TODO : Do something if your plugin needs it (saving custom configs, clearing cache, closing connections...)
    }

}