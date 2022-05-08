package ru.s4m1d.notes.app.desktop.client.daemon.task;

import ru.s4m1d.notes.app.desktop.client.components.MainFrame;
import ru.s4m1d.notes.app.desktop.client.core.Observer;

public class MainFrameStateService extends Observer<NewComponentEvent> {
    private MainFrame mainFrame;

    public MainFrameStateService(MainFrame mainFrame){
        this.mainFrame = mainFrame;
    }

    @Override
    public void processEvent(NewComponentEvent event) {
        mainFrame.pack();
    }
}
