package ru.s4m1d.notes.app.desktop.client.app.runner;

import ru.s4m1d.notes.app.desktop.client.business.task.MainFrameStateService;
import ru.s4m1d.notes.app.desktop.client.business.task.NotesMonitoringServiceImpl;
import ru.s4m1d.notes.app.desktop.client.business.task.NotesBarUpdateServiceImpl;
import ru.s4m1d.notes.app.desktop.client.components.*;
import ru.s4m1d.notes.app.desktop.client.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesBarLayeredPane;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesBarScrollPane;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.TextEditorPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.WorkspaceScrollPane;

import javax.swing.*;
import java.awt.*;

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

//        NotesBarScrollPane notesBarScrollPane = new NotesBarScrollPane(notesPane);
//        notesBarScrollPane.initialize();
        NotesBarLayeredPane notesBarLayeredPane = new NotesBarLayeredPane(notesPane);
        notesBarLayeredPane.initialize();

        MenuBar menuBar = new MenuBar();
        menuBar.initialize();

        mainFrame.setJMenuBar(menuBar);
//        mainFrame.getContentPane().add(notesBarScrollPane, BorderLayout.WEST);
        mainFrame.getContentPane().add(notesBarLayeredPane, BorderLayout.WEST);
        mainFrame.getContentPane().add(workspaceScrollPane);

        mainFrame.display();
        mainFrame.pack();

        NotesMonitoringServiceImpl notesMonitoringService = new NotesMonitoringServiceImpl();
        NotesBarUpdateServiceImpl notesPaneUpdateService = new NotesBarUpdateServiceImpl(notesPane);
        MainFrameStateService mainFrameStateService = new MainFrameStateService(mainFrame);
        notesPaneUpdateService.addObserver(mainFrameStateService);
        notesMonitoringService.addObserver(notesPaneUpdateService);
        notesMonitoringService.execute();
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
