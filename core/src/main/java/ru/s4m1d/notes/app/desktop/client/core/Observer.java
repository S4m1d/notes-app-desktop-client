package ru.s4m1d.notes.app.desktop.client.core;

public abstract class Observer<T extends Event> {
    public void receive(T event){
        processEvent(event);
    }
    public abstract void processEvent(T event);
}
