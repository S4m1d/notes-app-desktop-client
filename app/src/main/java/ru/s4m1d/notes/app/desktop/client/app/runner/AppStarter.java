package ru.s4m1d.notes.app.desktop.client.app.runner;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;
import ru.s4m1d.notes.app.desktop.client.initialization.tasks.ContextInitTask;
import ru.s4m1d.notes.app.desktop.client.model.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.model.context.NotesContext;
import ru.s4m1d.notes.app.desktop.client.model.context.RedactorContext;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextController;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextControllerImpl;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextController;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextControllerImpl;
import ru.s4m1d.notes.app.desktop.client.presenter.mainframe.MainFrameStateService;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.*;
import ru.s4m1d.notes.app.desktop.client.core.notes.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.core.notes.NotesSearchServiceImpl;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.*;
import ru.s4m1d.notes.app.desktop.client.view.components.MainFrame;
import ru.s4m1d.notes.app.desktop.client.view.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesBarLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.TextEditorPane;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.RedactorLayeredPane;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarController;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarControllerImpl;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorController;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorControllerImpl;

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan("ru.s4m1d")
public class AppStarter {

    public static void createGui(){

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
        SwingApplicationContext swingApplicationContext = new SwingApplicationContext(new RedactorContext(), new NotesContext());

        NotesContextController notesContextController = new NotesContextControllerImpl(swingApplicationContext.getNotesContext());
        RedactorContextController redactorContextController = new RedactorContextControllerImpl(swingApplicationContext.getRedactorContext());


        NotesContextService notesContextService = new NotesContextServiceImpl(notesContextController);
        RedactorContextService redactorContextService = new RedactorContextServiceImpl(redactorContextController);

        NotesSearchService notesSearchService = new NotesSearchServiceImpl();
        ContextInitTask contextInitTask = new ContextInitTask(notesSearchService, notesContextService, redactorContextService);

        NotesBarServiceImpl notesBarService = new NotesBarServiceImpl(notesBarController);
        RedactorService redactorService = new RedactorServiceImpl(redactorController);

        ((Observable) notesContextService).addObserver(notesBarService);
        ((Observable) redactorContextService).addObserver(redactorService);

        contextInitTask.execute();

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
