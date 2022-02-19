package ru.s4m1d.notes.app.desktop.client.app.runner;

import ru.s4m1d.notes.app.desktop.client.components.MainFrame;
import ru.s4m1d.notes.app.desktop.client.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.components.WorkspaceLabel;

import javax.swing.*;

public class AppRunner {
    public static void createGui(){
        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();

        MenuBar menuBar = new MenuBar();
        menuBar.initialize();
        mainFrame.setJMenuBar(menuBar);

        WorkspaceLabel workspaceLabel = new WorkspaceLabel();
        workspaceLabel.initialize();
        mainFrame.getContentPane().add(workspaceLabel);

        mainFrame.display();
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGui();
            }
        });
    }
}
