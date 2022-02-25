package ru.s4m1d.notes.app.desktop.client.app.runner;

import ru.s4m1d.notes.app.desktop.client.components.*;
import ru.s4m1d.notes.app.desktop.client.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.TextEditorPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.WorkspaceScrollPane;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.util.Map;

public class AppRunner {
    public static void createGui(){
        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();

        TextEditorPane textEditorPane = new TextEditorPane();
        textEditorPane.initialize();

        WorkspaceScrollPane workspaceScrollPane = new WorkspaceScrollPane(textEditorPane);
        workspaceScrollPane.initialize();

        NotesPane notesPane = new NotesPane();
        notesPane.initialize();

        MenuBar menuBar = new MenuBar();
        menuBar.initialize();

//        JMenu jMenu = new JMenu("edit");
//        jMenu.setForeground(new Color(245, 241, 230));
//
//        Map<Object, Action> actions = ComponentAnalizerUtil.getActionsFrom(textEditorPane);
//        jMenu.add(actions.get(DefaultEditorKit.pasteAction));

//        menuBar.add(jMenu);

        mainFrame.setJMenuBar(menuBar);
        mainFrame.getContentPane().add(notesPane, BorderLayout.WEST);
        mainFrame.getContentPane().add(workspaceScrollPane);

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
