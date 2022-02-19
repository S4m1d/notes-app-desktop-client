package ru.s4m1d.notes.app.desktop.client.components;

import javax.swing.*;
import java.awt.*;

public class WorkspaceLabel extends JLabel {
    public void initialize() {
        this.setOpaque(true);
        this.setBackground(new Color(133, 120, 82));
        this.setPreferredSize(new Dimension(200, 180));
    }
}
