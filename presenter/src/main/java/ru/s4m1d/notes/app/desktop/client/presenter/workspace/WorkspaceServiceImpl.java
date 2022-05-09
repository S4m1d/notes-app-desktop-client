package ru.s4m1d.notes.app.desktop.client.presenter.workspace;

import lombok.AllArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.model.context.WorkspaceContext;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.WorkSpaceLayeredPane;

import javax.swing.text.DefaultStyledDocument;
import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private WorkSpaceLayeredPane workSpaceLayeredPane;
    private WorkspaceContext workspaceContext;

    public void loadContent() {
        try {
            workSpaceLayeredPane.getWorkspaceScrollPane().getTextEditorPane().read(
                    (InputStream) workspaceContext.getCurrentNote().getContent().get(),
                    new DefaultStyledDocument()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
