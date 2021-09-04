package com.github.michaljaz.manhunt;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {

        FileConfiguration config = this.getConfig();
        config.addDefault("runnerNick", "Dream");
        config.addDefault("language", "en");
        config.addDefault("lang.en.join_runner", "[player] joined team "+ChatColor.GREEN+"RUNNER");
        config.addDefault("lang.en.join_hunter", "[player] joined team "+ChatColor.RED+"HUNTER");
        config.addDefault("lang.en.join_spectator", "[player] joined team "+ChatColor.BLUE+"SPECTATOR");
        config.addDefault("lang.en.runner_won", "[runner_nick] won the game!");
        config.addDefault("lang.en.hunter_won", "Hunters team won the game!");

        config.options().copyDefaults(true);
        saveConfig();

        getLogger().info(ChatColor.RED + config.getString("runnerNick") + " is runner");
        getLogger().info(ChatColor.GREEN + "ENABLED MANHUNT PLUGIN!");

        this.getCommand("compass").setExecutor(new Compass());
        this.getCommand("team").setExecutor(new Team());
        this.getCommand("team").setTabCompleter(new Completer());
        this.getCommand("start").setExecutor(new Start());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "DISABLED MANHUNT PLUGIN");
    }
}