package ru.s4m1d.notes.app.desktop.client.components.workspace;

import ru.s4m1d.notes.app.desktop.client.components.layout.CustomScrollPaneLayout;
import ru.s4m1d.notes.app.desktop.client.components.painting.CustomScrollBarUi;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WorkspaceScrollPane extends JScrollPane {
    public WorkspaceScrollPane(TextEditorPane textEditorPane){
        super(textEditorPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }
    public void initialize(){
        setPreferredSize(new Dimension(1720,1080));
        setBorder(new LineBorder(new Color(0,0,0)));
//        setLayout(new CustomScrollPaneLayout());
        getVerticalScrollBar().setOpaque(false);
//        getHorizontalScrollBar().setOpaque(false);
        CustomScrollBarUi customScrollBarUi = new CustomScrollBarUi();
        getVerticalScrollBar().setUI(customScrollBarUi);
    }
}
