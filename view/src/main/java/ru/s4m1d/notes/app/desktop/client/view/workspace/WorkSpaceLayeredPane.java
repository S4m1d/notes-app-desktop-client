package ru.s4m1d.notes.app.desktop.client.view.workspace;

import lombok.Getter;
import ru.s4m1d.notes.app.desktop.client.view.layout.CustomLayeredPaneLayout;
import ru.s4m1d.notes.app.desktop.client.view.painting.CustomScrollBarUi;

import javax.swing.*;
import java.awt.*;

public class WorkSpaceLayeredPane extends JPanel {
    @Getter
    private WorkspaceScrollPane workspaceScrollPane;
    private JLayeredPane layeredPane;
    private JScrollBar verticalScrollBar;
    private WorkSpaceSettings workSpaceSettings;

    public WorkSpaceLayeredPane(JComponent component) {
        workSpaceSettings = WorkSpaceSettings.get();
        workspaceScrollPane = new WorkspaceScrollPane((TextEditorPane) component);
        workspaceScrollPane.initialize();
        layeredPane = new JLayeredPane();
        verticalScrollBar = new JScrollBar(Adjustable.VERTICAL);
    }

    public void initialize(){
        layeredPane.setLayout(new CustomLayeredPaneLayout());

        CustomScrollBarUi customScrollBarUi = new CustomScrollBarUi();
        verticalScrollBar.setUI(customScrollBarUi);
        verticalScrollBar.setOpaque(false);
        verticalScrollBar.setPreferredSize(new Dimension(10,200));
        layeredPane.setLayer(verticalScrollBar, JLayeredPane.PALETTE_LAYER);

        layeredPane.add(verticalScrollBar, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(workspaceScrollPane);
        workspaceScrollPane.remove(workspaceScrollPane.getVerticalScrollBar());
        workspaceScrollPane.boundWithVerticalScrollBar(verticalScrollBar);

        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);
        setBackground(workSpaceSettings.getWorkSpaceBackgroundColor());
    }
}
