package ru.s4m1d.notes.app.desktop.client.presenter.workspace;

import lombok.AllArgsConstructor;

import javax.swing.*;

@AllArgsConstructor
public class WorkspaceWorker extends SwingWorker<Void, Void> {
    private WorkspaceServiceImpl workspaceService;

    @Override
    protected Void doInBackground() throws Exception {
        workspaceService.loadContent();
        return null;
    }
}
