package com.github.michaljaz.manhunt;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import net.md_5.bungee.api.ChatColor;

public class Compass implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            ItemStack itemstack = new ItemStack(Material.COMPASS, 1);
            inventory.addItem(itemstack);
            player.sendMessage("You got compass!");
        } else {
            sender.sendMessage("You must be a player!");
        }
        return true;
    }
}