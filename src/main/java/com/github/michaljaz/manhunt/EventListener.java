package com.github.michaljaz.manhunt;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.Material;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Action a = event.getAction();
        ItemStack is = event.getItem();
        if (a == Action.PHYSICAL || is == null || is.getType() == Material.AIR) {
            return;
        }
        Player player = (Player) event.getPlayer();
        player.sendMessage("Interactract");
    }
}