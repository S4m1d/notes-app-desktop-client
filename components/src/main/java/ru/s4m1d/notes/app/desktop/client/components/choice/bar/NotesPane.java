package ru.s4m1d.notes.app.desktop.client.components.choice.bar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NotesPane extends JPanel {
    public void initialize(){
        setPreferredSize(new Dimension(200,1080));
        setBackground(new Color(47, 46, 46));
        setBorder(new LineBorder(new Color(0,0,0)));
    }
}
