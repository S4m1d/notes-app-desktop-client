package ru.s4m1d.notes.app.desktop.client.components.choice.bar;

import ru.s4m1d.notes.app.desktop.client.components.layout.CustomScrollPaneLayout;
import ru.s4m1d.notes.app.desktop.client.components.painting.CustomScrollPaneUi;

import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRelation;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class NotesBarScrollPane extends JScrollPane {
    private NotesBarSettings notesBarSettings;

    public NotesBarScrollPane(Component notesPane){
        super(notesPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        notesBarSettings = new NotesBarSettings();
    }
    public void initialize(){
        setPreferredSize(new Dimension(notesBarSettings.getNotesBarPreferredWidth(), notesBarSettings.getNotesBarPreferredHeight()));
        setBackground(notesBarSettings.getNotesBarBackgroundColor());
        setLayout(new CustomScrollPaneLayout());
        setUI(new CustomScrollPaneUi());
    }

    public void boundWithVerticalScrollBar(JScrollBar verticalScrollBar) {
        this.verticalScrollBar = verticalScrollBar;
        setScrollBarRelations(verticalScrollBar);

        ChangeListener vsbChangeListener = ((CustomScrollPaneUi)getUI()).getVsbChangeListener();
        verticalScrollBar.getModel().addChangeListener(vsbChangeListener);

        revalidate();
        repaint();
    }

    public void setScrollBarRelations(JScrollBar scrollBar) {
        /*
         * The JScrollBar is a CONTROLLER_FOR the JScrollPane.
         * The JScrollPane is CONTROLLED_BY the JScrollBar.
         */
        AccessibleRelation controlledBy =
                new AccessibleRelation(AccessibleRelation.CONTROLLED_BY,
                        scrollBar);
        AccessibleRelation controllerFor =
                new AccessibleRelation(AccessibleRelation.CONTROLLER_FOR,
                        NotesBarScrollPane.this);

        // set the relation set for the scroll bar
        AccessibleContext ac = scrollBar.getAccessibleContext();
        ac.getAccessibleRelationSet().add(controllerFor);

        // set the relation set for the scroll pane
        ac.getAccessibleRelationSet().add(controlledBy);
    }
}
