package com.github.michaljaz.manhunt;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Team implements CommandExecutor {

    private Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        FileConfiguration config = plugin.getConfig();
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("runner")) {
                    plugin.getServer().broadcastMessage(player.getName()+" joined team "+ChatColor.GREEN+"RUNNER");
                    config.set("runnerNick",player.getName());
                    config.options().copyDefaults(true);
                    plugin.saveConfig();
                } else if (args[0].equalsIgnoreCase("hunter")) {
                    plugin.getServer().broadcastMessage(player.getName()+" joined team "+ChatColor.RED+"HUNTER");
                } else if (args[0].equalsIgnoreCase("spectator")) {
                    plugin.getServer().broadcastMessage(player.getName()+" joined team "+ChatColor.BLUE+"SPECTATOR");
                } else {
                    player.sendMessage("Error!");
                }
            }
        } else {
            sender.sendMessage("You must be a player!");
        }
        return true;
    }
}