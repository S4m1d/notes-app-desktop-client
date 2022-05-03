package ru.s4m1d.notes.app.desktop.client.business.task.workspace;

import lombok.AllArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.Event;
import ru.s4m1d.notes.app.desktop.client.core.Observer;

@AllArgsConstructor
public class WorkspaceObserver extends Observer {
    private WorkspaceWorker workspaceWorker;

    @Override
    public void processEvent(Event event) {
        workspaceWorker.execute();
    }
}
