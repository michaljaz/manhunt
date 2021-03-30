package com.github.michaljaz.manhunt;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import net.md_5.bungee.api.ChatColor;

public class Team implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length > 0){
                if(args[0].equalsIgnoreCase("runner")){
                    player.sendMessage("You are runner!");
                }else if(args[0].equalsIgnoreCase("hunter")){
                    player.sendMessage("You are hunter!");
                }else if(args[0].equalsIgnoreCase("spectator")){
                    player.sendMessage("You are spectator!");
                }else{
                    player.sendMessage("Error!");
                }
            }
        } else {
            sender.sendMessage("You must be a player!");
        }
        return true;
    }
}