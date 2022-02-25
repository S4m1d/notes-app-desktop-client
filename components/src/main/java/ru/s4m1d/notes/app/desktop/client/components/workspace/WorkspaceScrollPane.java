package ru.s4m1d.notes.app.desktop.client.components.workspace;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class WorkspaceScrollPane extends JScrollPane {
    public WorkspaceScrollPane(TextEditorPane textEditorPane){
        super(textEditorPane);
    }
    public void initialize(){
        setPreferredSize(new Dimension(1720,1080));
        setBorder(new LineBorder(new Color(0,0,0)));
    }
}
