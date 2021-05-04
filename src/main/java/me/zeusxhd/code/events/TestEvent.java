package me.zeusxhd.code.events;

import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class TestEvent extends Event implements Cancellable {

    private final String message;
    private boolean isCancelled;

    public TestEvent(String message) {
        this.message = message;
        this.isCancelled = false;
    }

    private static final HandlerList HANDLERS = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return HANDLERS;
    }

    public static HandlerList getHanderList() {
        return HANDLERS;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public boolean isCancelled() {
        return this.isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }



}
