package ru.s4m1d.notes.app.desktop.client.view.components;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class MenuBar extends JMenuBar {
    public void initialize(){
        this.setOpaque(true);
        this.setBackground(new Color(55, 56, 55));
        this.setPreferredSize(new Dimension(200, 20));
        setBorder(new LineBorder(new Color(0,0,0)));
    }
}
