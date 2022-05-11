package ru.s4m1d.notes.app.desktop.client.core.observe;

public interface Observer<T extends Event> {
    public abstract void processEvent(T event);
}
