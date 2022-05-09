package ru.s4m1d.notes.app.desktop.client.view.workspace;

import javax.swing.*;
import java.awt.*;

public class TextEditorPane extends JTextPane {
    public void initialize(){
        this.setCaretPosition(0);
        this.setEditable(true);
        this.setForeground(new Color(246, 239, 229));
        this.setBackground(new Color(94, 88, 80));
        this.setCaretColor(new Color(246, 239, 229));
    }
}
