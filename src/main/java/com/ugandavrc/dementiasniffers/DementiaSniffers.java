package com.ugandavrc.dementiasniffers;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Item;
import org.bukkit.entity.Sniffer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDropItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class DementiaSniffers extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getLogger().info("[DementiaSniffers] Loading DementiaSniffers");
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getLogger().info("[DementiaSniffers] Loaded Dementia Sniffers. Where is my icecream at :).");
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("[DementiaSniffers] Disabled Dementia Sniffers. Where tf am I :).");
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onSnifferDiscoveredItem(EntityDropItemEvent e) {
        if (e.getEntity() instanceof Sniffer sniffer) {

            // Location location = sniffer.getLocation();
            // Chunk chunk = location.getChunk();
            // Item item = e.getItemDrop();

            // Debug
            // Bukkit.getLogger().info("Sniffer " + sniffer.getEntityId() + " found " + item.getName() + " at location x: " + location.getBlockX() + ", y: " + location.getBlockY() + ", z: " + location.getBlockZ() + " at chunk x: " + chunk.getX() + ", z: " + chunk.getZ() + ".");

            // Thanks choco for making this simple :)
            sniffer.getExploredLocations().forEach(sniffer::removeExploredLocation); // Should Purge them. Thanks Choco from Spigot community

            sniffer.findPossibleDigLocation(); // Totally not trying to overwork them ;D

        }
    }
}
