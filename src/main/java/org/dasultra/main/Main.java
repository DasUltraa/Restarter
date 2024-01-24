package org.dasultra.main;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.dasultra.file.FileManager;
import org.dasultra.listener.RestartListener;

import java.util.List;

public final class Main extends JavaPlugin {

    public static Main plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {

        FileManager manager = new FileManager("plugins/Restarter/config.yml");
        manager.add("Message", "&cDer Server wird in %time% Sekunden neu gestartet!");
        manager.add("NoPerm", "&cDu hast keine Rechte diesen Befehl auszuführen!");

        plugin = this;
        System.out.print("Restarter by DasUltra [Enabled]");

        getServer().getPluginManager().registerEvents(new RestartListener(), this);

    }

    @Override
    public void onDisable() {
        System.out.print("Restarter by DasUltra [Disabled]");
    }
}
