package ru.s4m1d.notes.app.desktop.client.view.components.workspace;

import lombok.Getter;
import ru.s4m1d.notes.app.desktop.client.view.components.layout.CustomLayeredPaneLayout;
import ru.s4m1d.notes.app.desktop.client.view.components.painting.CustomScrollBarUi;

import javax.swing.*;
import java.awt.*;

public class RedactorLayeredPane extends JPanel {
    @Getter
    private RedactorScrollPane redactorScrollPane;
    private JLayeredPane layeredPane;
    private JScrollBar verticalScrollBar;
    private RedactorSettings redactorSettings;

    public RedactorLayeredPane(JComponent component) {
        redactorSettings = RedactorSettings.get();
        redactorScrollPane = new RedactorScrollPane((TextEditorPane) component);
        redactorScrollPane.initialize();
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
        layeredPane.add(redactorScrollPane);
        redactorScrollPane.remove(redactorScrollPane.getVerticalScrollBar());
        redactorScrollPane.boundWithVerticalScrollBar(verticalScrollBar);

        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);
        setBackground(redactorSettings.getWorkSpaceBackgroundColor());
    }
}
