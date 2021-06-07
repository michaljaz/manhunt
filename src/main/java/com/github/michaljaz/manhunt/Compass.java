package com.github.michaljaz.manhunt;

import java.util.Arrays;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;

public class Compass implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerInventory inventory = player.getInventory();
            ItemStack itemstack = new ItemStack(Material.COMPASS, 1);
            ItemMeta meta = itemstack.getItemMeta();
            meta.setDisplayName("Hunter compass");
            meta.setLore(Arrays.asList("This compass is pointing to runner."));
            meta.addEnchant(Enchantment.DURABILITY, 0, true);
            meta.addItemFlags(new ItemFlag[] {
                    ItemFlag.HIDE_ENCHANTS
            });
            itemstack.setItemMeta(meta);
            inventory.addItem(itemstack);
            player.sendMessage("You got compass!");
        } else {
            sender.sendMessage("You must be a player!");
        }
        return true;
    }
}