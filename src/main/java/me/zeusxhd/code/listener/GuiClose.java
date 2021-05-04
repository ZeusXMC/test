package me.zeusxhd.code.listener;

import me.zeusxhd.code.Plugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GuiClose implements Listener {

    Plugin plugin;

    public GuiClose(Plugin plugin) {
        this.plugin = plugin;
    }

    String inventoryName;

    @EventHandler
    public void onGuiClose(InventoryCloseEvent e) {

        inventoryName = e.getPlayer().getName() + "'s Extra Inventory Vault";

        if(e.getInventory().getType().name().contains(inventoryName)) {
            plugin.vaultInfo.put(
                    e.getPlayer().getUniqueId().toString(),
                    e.getInventory().getContents()
            );
        }
    }
}
