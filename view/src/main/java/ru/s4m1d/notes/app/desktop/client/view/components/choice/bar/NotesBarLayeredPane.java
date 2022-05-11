package ru.s4m1d.notes.app.desktop.client.view.components.choice.bar;

import ru.s4m1d.notes.app.desktop.client.view.components.layout.CustomLayeredPaneLayout;
import ru.s4m1d.notes.app.desktop.client.view.components.painting.CustomScrollBarUi;

import javax.swing.*;
import java.awt.*;

public class NotesBarLayeredPane extends JPanel {
    private NotesBarSettings notesBarSettings;

    private NotesBarScrollPane notesBarScrollPane;
    private JLayeredPane layeredPane;
    private JScrollBar verticalScrollbar;

    public NotesBarLayeredPane(JComponent component) {
        notesBarSettings = new NotesBarSettings();
        notesBarScrollPane = new NotesBarScrollPane(component);
        notesBarScrollPane.initialize();
        layeredPane = new JLayeredPane();
        verticalScrollbar = new JScrollBar(Adjustable.VERTICAL);
    }

    public void initialize(){
        CustomScrollBarUi customScrollBarUi = new CustomScrollBarUi();
        verticalScrollbar.setUI(customScrollBarUi);
        verticalScrollbar.setOpaque(false);
        verticalScrollbar.setPreferredSize(new Dimension(10,200));
        layeredPane.setLayer(verticalScrollbar, JLayeredPane.PALETTE_LAYER);

        layeredPane.add(verticalScrollbar, JLayeredPane.PALETTE_LAYER);
        setPreferredSize(new Dimension(notesBarSettings.getNotesBarPreferredWidth(), notesBarSettings.getNotesBarPreferredHeight()));
        layeredPane.setLayout(new CustomLayeredPaneLayout());
        layeredPane.add(notesBarScrollPane);

        notesBarScrollPane.setVisible(true);
        notesBarScrollPane.remove(notesBarScrollPane.getVerticalScrollBar());
        notesBarScrollPane.boundWithVerticalScrollBar(verticalScrollbar);

        setLayout(new BorderLayout());
        add(layeredPane, BorderLayout.CENTER);
        setBackground(notesBarSettings.getNotesBarBackgroundColor());
    }
}
