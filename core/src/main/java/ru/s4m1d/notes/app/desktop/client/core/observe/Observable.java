package ru.s4m1d.notes.app.desktop.client.core.observe;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {
    private List<Observer> observers;
    public Observable(){
        observers = new ArrayList<>();
    }
    public void addObserver(Observer observer) {
        observers.add(observer);
    }
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    public void fireEvent(Event event) {
        for (Observer observer:observers) {
            observer.processEvent(event);
        }
    }
}
