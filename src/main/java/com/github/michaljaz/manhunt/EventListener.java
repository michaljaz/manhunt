package com.github.michaljaz.manhunt;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Arrays;
import org.bukkit.plugin.Plugin;
import com.github.michaljaz.manhunt.Main;
import org.bukkit.configuration.file.FileConfiguration;
import net.md_5.bungee.api.ChatColor;

public class EventListener implements Listener {

    private Plugin plugin = Main.getPlugin(Main.class);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        FileConfiguration config = plugin.getConfig();
        Action a = event.getAction();
        ItemStack is = event.getItem();
        Player player = (Player) event.getPlayer();
        ItemStack itemstack = new ItemStack(Material.COMPASS);
        ItemMeta meta = itemstack.getItemMeta();
        meta.setDisplayName("Hunter compass");
        meta.setLore(Arrays.asList("This compass is pointing to runner."));
        meta.addEnchant(Enchantment.DURABILITY, 0, true);
        meta.addItemFlags(new ItemFlag[] {
            ItemFlag.HIDE_ENCHANTS
        });
        itemstack.setItemMeta(meta);

        if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR) {
            return;
        }
        if (player.getInventory().getItemInHand().equals(itemstack)){
            String runner=config.getString("runnerNick");
            
            if(plugin.getServer().getPlayer(runner) != null){
                player.sendMessage("Compass is pointing to "+ChatColor.GREEN+runner);
                player.setCompassTarget(plugin.getServer().getPlayer(runner).getLocation());
            }else{
                player.sendMessage(ChatColor.RED+"No runners found");
            }
            
        }
    }
}