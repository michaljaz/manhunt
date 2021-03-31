package com.github.michaljaz.manhunt;

import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.plugin.java.JavaPlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

import com.github.michaljaz.manhunt.Compass;
import com.github.michaljaz.manhunt.Completer;
import com.github.michaljaz.manhunt.Team;
import com.github.michaljaz.manhunt.EventListener;

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
        this.getCommand("team").setTabCompleter(new Completer());
        getServer().getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED+"DISABLED MANHUNT PLUGIN");
        // TODO : Do something if your plugin needs it (saving custom configs, clearing cache, closing connections...)
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        getLogger().info(ChatColor.RED+"AC");
        List<String> list = new ArrayList<>();
        if (args.length == 2) {

            if (args[0].equalsIgnoreCase("team")) {
                List<String> factions = new ArrayList<String>();
                factions.add("hunter");
                factions.add("runner");
                for (String faction : factions) {
                    if (!faction.toLowerCase().startsWith(args[1].toLowerCase())) continue;
                    list.add(faction);
                }
            }
        }
        return list;
    }

}