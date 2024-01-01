package org.dasultra.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.dasultra.main.Main;

public class RestartListener implements Listener {

    int restartTime = 10;

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().equalsIgnoreCase("/restart") || event
                .getMessage().equalsIgnoreCase("/stop") || event
                .getMessage().equalsIgnoreCase("/reload") || event
                .getMessage().equalsIgnoreCase("/minecraft:restart") || event
                .getMessage().equalsIgnoreCase("/minecraft:stop") || event
                .getMessage().equalsIgnoreCase("/minecraft:reload") || event
                .getMessage().equalsIgnoreCase("/minecraft:rl") || event
                .getMessage().equalsIgnoreCase("/rl")) {
            if (event.getPlayer().hasPermission("restarter.use")) {
                event.setCancelled(true);
                Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.plugin, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.broadcastMessage("§cDer Server wird in " + restartTime + " Sekunden neugestartet!");
                        if (restartTime < 6) {
                            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                                onlinePlayer.sendTitle("§cDer Server wird in " + restartTime + " Sekunden neugestartet!", "");
                            }
                        }



                        if (restartTime < 4) {
                            playSoundToAllPlayers(Sound.BLOCK_NOTE_BLOCK_HARP);
                        }

                        restartTime--;




                        if (restartTime < 0) {
                            Bukkit.shutdown();
                        }
                    }
                }, 0, 20L);
            } else {
                event.getPlayer().sendMessage("§cDu hast keine Rechte diesen Befehl ausführen!");
            }
        }

    }

    private void playSoundToAllPlayers (Sound sound){
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            onlinePlayer.playSound(onlinePlayer.getLocation(), sound, 1.0f, 1.0f);
        }
    }

}
