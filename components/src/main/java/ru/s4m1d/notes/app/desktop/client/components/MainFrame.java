package ru.s4m1d.notes.app.desktop.client.components;

import javax.swing.*;

public class MainFrame extends JFrame {
    public void initialize(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void display() {
        this.pack();
        this.setVisible(true);
    }
}
