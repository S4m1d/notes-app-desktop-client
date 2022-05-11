package ru.s4m1d.notes.app.desktop.client.view.components.workspace;

import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.view.components.layout.CustomScrollPaneLayout;
import ru.s4m1d.notes.app.desktop.client.view.components.painting.CustomScrollPaneUi;

import javax.accessibility.AccessibleContext;
import javax.accessibility.AccessibleRelation;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class RedactorScrollPane extends JScrollPane {
    @Getter
    @Setter
    private TextEditorPane textEditorPane;

    public RedactorScrollPane() {
        this(new TextEditorPane());
    }

    public RedactorScrollPane(TextEditorPane textEditorPane){
        super(textEditorPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.textEditorPane = textEditorPane;
    }
    public void initialize(){
        setPreferredSize(new Dimension(1720,1080));
        setBorder(new LineBorder(new Color(0,0,0)));
        getVerticalScrollBar().setOpaque(false);
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
                        RedactorScrollPane.this);

        // set the relation set for the scroll bar
        AccessibleContext ac = scrollBar.getAccessibleContext();
        ac.getAccessibleRelationSet().add(controllerFor);

        // set the relation set for the scroll pane
        ac.getAccessibleRelationSet().add(controlledBy);
    }
}
