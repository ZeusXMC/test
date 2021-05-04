package me.zeusxhd.code;

import me.zeusxhd.code.listener.TestListener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Plugin extends JavaPlugin {

    public static HashMap<String, ItemStack[]> vaultInfo = new HashMap<>();

    @Override
    public void onEnable() {
        getLogger().info("onEnable is called!");
        initializeListeners();
    }
    @Override
    public void onDisable() {
        getLogger().info("onDisable is called!");
    }

    public void saveInvs() {
        if(!vaultInfo.isEmpty()) {
            this.saveInvs();
        }
    }

    public void restoreInvs() {

    }

    public void resetInvs() {

    }

    public void initializeListeners() {
        getServer().getPluginManager().registerEvents(new TestListener(), this);
    }


}
