package ru.s4m1d.notes.app.desktop.client.view.components;

import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesBarLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.RedactorLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorController;

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
