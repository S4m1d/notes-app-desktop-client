package ru.s4m1d.notes.app.desktop.client.components;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void initialize(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1920,1080));
    }
    public void display() {
        this.pack();
        this.setVisible(true);
    }
}
