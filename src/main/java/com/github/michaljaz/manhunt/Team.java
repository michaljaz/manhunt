package com.github.michaljaz.manhunt;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Team implements CommandExecutor {

    private final Plugin plugin = Main.getPlugin(Main.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        FileConfiguration config = plugin.getConfig();
        String language=config.getString("language");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("runner")) {
                    String message=config.getString("lang."+language+".join_runner");
                    plugin.getServer().broadcastMessage(message.replace("[player]",player.getName()));
                    config.set("runnerNick",player.getName());
                    config.options().copyDefaults(true);
                    plugin.saveConfig();
                    player.setGameMode(GameMode.SURVIVAL);
                } else if (args[0].equalsIgnoreCase("hunter")) {
                    String message=config.getString("lang."+language+".join_hunter");
                    plugin.getServer().broadcastMessage(message.replace("[player]",player.getName()));
                    player.setGameMode(GameMode.SURVIVAL);
                } else if (args[0].equalsIgnoreCase("spectator")) {
                    String message=config.getString("lang."+language+".join_spectator");
                    plugin.getServer().broadcastMessage(message.replace("[player]",player.getName()));
                    player.setGameMode(GameMode.SPECTATOR);
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