package ru.s4m1d.notes.app.desktop.client.app.runner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.s4m1d.notes.app.desktop.client.controller.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.controller.context.NotesContext;
import ru.s4m1d.notes.app.desktop.client.controller.context.WorkspaceContext;
import ru.s4m1d.notes.app.desktop.client.controller.task.MainFrameStateService;
import ru.s4m1d.notes.app.desktop.client.controller.task.context.ContextInitializationTask;
import ru.s4m1d.notes.app.desktop.client.controller.notes.NotesMonitoringServiceImpl;
import ru.s4m1d.notes.app.desktop.client.controller.notes.NotesBarUpdateServiceImpl;
import ru.s4m1d.notes.app.desktop.client.controller.task.workspace.WorkspaceObserver;
import ru.s4m1d.notes.app.desktop.client.controller.task.workspace.WorkspaceService;
import ru.s4m1d.notes.app.desktop.client.controller.task.workspace.WorkspaceWorker;
import ru.s4m1d.notes.app.desktop.client.components.*;
import ru.s4m1d.notes.app.desktop.client.components.MenuBar;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesBarLayeredPane;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.TextEditorPane;
import ru.s4m1d.notes.app.desktop.client.components.workspace.WorkSpaceLayeredPane;

import javax.swing.*;
import java.awt.*;

@Configuration
@ComponentScan("ru.s4m1d")
public class AppStarter {

    public static void createGui(ApplicationContext applicationContext){

        MainFrame mainFrame = new MainFrame();
        mainFrame.initialize();

        TextEditorPane textEditorPane = new TextEditorPane();
        textEditorPane.initialize();

        WorkSpaceLayeredPane workspaceScrollPane = new WorkSpaceLayeredPane(textEditorPane);
        workspaceScrollPane.initialize();

        NotesPane notesPane = new NotesPane();
        notesPane.initialize();

        NotesBarLayeredPane notesBarLayeredPane = new NotesBarLayeredPane(notesPane);
        notesBarLayeredPane.initialize();

        MenuBar menuBar = new MenuBar();
        menuBar.initialize();

        mainFrame.setJMenuBar(menuBar);
        mainFrame.getContentPane().add(notesBarLayeredPane, BorderLayout.WEST);
        mainFrame.getContentPane().add(workspaceScrollPane);

        mainFrame.display();
        mainFrame.pack();
        SwingApplicationContext swingApplicationContext = new SwingApplicationContext(new WorkspaceContext(), new NotesContext());

        WorkspaceObserver workspaceObserver = new WorkspaceObserver(
                new WorkspaceWorker(
                        new WorkspaceService(workspaceScrollPane, swingApplicationContext.getWorkspaceContext())
                )
        );
        swingApplicationContext.getWorkspaceContext().addObserver(workspaceObserver);


        ContextInitializationTask contextInitializationTask = new ContextInitializationTask(swingApplicationContext);
        contextInitializationTask.execute();

        NotesMonitoringServiceImpl notesMonitoringService = new NotesMonitoringServiceImpl();
        NotesBarUpdateServiceImpl notesPaneUpdateService = new NotesBarUpdateServiceImpl(notesPane);
        MainFrameStateService mainFrameStateService = new MainFrameStateService(mainFrame);
        notesPaneUpdateService.addObserver(mainFrameStateService);
        notesMonitoringService.addObserver(notesPaneUpdateService);
        notesMonitoringService.execute();
    }

    public static void main(String args[]) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppStarter.class);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createGui(applicationContext);
            }
        });
    }
}
