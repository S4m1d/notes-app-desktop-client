package ru.s4m1d.notes.app.desktop.client.app.configuration;

import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ViewApiAccess;
import ru.s4m1d.notes.app.desktop.client.view.components.MainFrame;
import ru.s4m1d.notes.app.desktop.client.view.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesBarLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.RedactorLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.TextEditorPane;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarController;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarControllerImpl;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorController;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorControllerImpl;

import java.awt.*;

public class ViewConfiguration {
    public static ViewApiAccess createView () {
        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();

        TextEditorPane textEditorPane = new TextEditorPane();
        textEditorPane.initialize();

        RedactorLayeredPane redactorLayeredPane = new RedactorLayeredPane(textEditorPane);
        redactorLayeredPane.initialize();

        NotesPane notesPane = new NotesPane();
        notesPane.initialize();

        NotesBarLayeredPane notesBarLayeredPane = new NotesBarLayeredPane(notesPane);
        notesBarLayeredPane.initialize();

        NotesBarController notesBarController = new NotesBarControllerImpl(notesPane);
        RedactorController redactorController = new RedactorControllerImpl(redactorLayeredPane);

        MenuBar menuBar = new MenuBar();
        menuBar.initialize();

        mainFrame.setJMenuBar(menuBar);
        mainFrame.getContentPane().add(notesBarLayeredPane, BorderLayout.WEST);
        mainFrame.getContentPane().add(redactorLayeredPane);

        mainFrame.display();
        mainFrame.pack();

        return ViewApiAccess.builder()
                .notesBarController(notesBarController)
                .redactorController(redactorController)
                .build();
    }
}
