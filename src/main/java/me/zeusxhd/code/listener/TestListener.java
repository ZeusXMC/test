package me.zeusxhd.code.listener;

import me.zeusxhd.code.events.TestEvent;
import me.zeusxhd.code.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Arrays;

public class TestListener implements Listener {

    String message;
    String playerName;

    private Utils utils = new Utils();

    @EventHandler
    public void onJoin(AsyncPlayerChatEvent e) {

        String originalMessage;
        String newMessage;

        playerName = e.getPlayer().getName();
        originalMessage = message;

        StringBuilder builder = new StringBuilder();
//        Arrays.asList().forEach(message -> builder.append());)


        for(String str : originalMessage) {

        }

        List<String> a = Arrays.asList("").stream().anyMatch()


    }
}
