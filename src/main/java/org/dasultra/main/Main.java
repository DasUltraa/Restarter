package org.dasultra.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.dasultra.listener.RestartListener;

public final class Main extends JavaPlugin {

    public static Main plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        System.out.print("Restarter by DasUltra [Enabled]");

        getServer().getPluginManager().registerEvents(new RestartListener(), this);

    }

    @Override
    public void onDisable() {
        System.out.print("Restarter by DasUltra [Disabled]");
    }
}
