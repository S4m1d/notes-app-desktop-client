package ru.s4m1d.notes.app.desktop.client.app.configuration;

import ru.s4m1d.notes.app.desktop.client.app.configuration.access.PresenterApiAccess;
import ru.s4m1d.notes.app.desktop.client.core.notes.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.core.notes.NotesSearchServiceImpl;
import ru.s4m1d.notes.app.desktop.client.initialization.tasks.ContextInitTask;

public class InitialTasksConfiguration {
    public static void configureAndExecute(PresenterApiAccess presenterApiAccess) {
        NotesSearchService notesSearchService = new NotesSearchServiceImpl();
        ContextInitTask contextInitTask =
                new ContextInitTask
                        (
                                notesSearchService,
                                presenterApiAccess.getNotesContextService(),
                                presenterApiAccess.getRedactorContextService()
                        );

        contextInitTask.execute();
    }
}
