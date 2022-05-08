package ru.s4m1d.notes.app.desktop.client.controller.task.workspace;

import lombok.AllArgsConstructor;

import javax.swing.*;

@AllArgsConstructor
public class WorkspaceWorker extends SwingWorker<Void, Void> {
    private WorkspaceService workspaceService;

    @Override
    protected Void doInBackground() throws Exception {
        workspaceService.loadContent();
        return null;
    }
}
