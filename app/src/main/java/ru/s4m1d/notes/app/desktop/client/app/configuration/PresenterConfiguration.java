package ru.s4m1d.notes.app.desktop.client.app.configuration;

import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ModelApiAccess;
import ru.s4m1d.notes.app.desktop.client.app.configuration.access.PresenterApiAccess;
import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ViewApiAccess;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesBarServiceImpl;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesContextService;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesContextServiceImpl;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorContextService;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorContextServiceImpl;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorService;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorServiceImpl;

public class PresenterConfiguration {
    public static PresenterApiAccess createPresenter(ViewApiAccess viewApiAccess, ModelApiAccess modelApiAccess) {

        NotesContextService notesContextService = new NotesContextServiceImpl(modelApiAccess.getNotesContextController());
        RedactorContextService redactorContextService = new RedactorContextServiceImpl(modelApiAccess.getRedactorContextController());

        NotesBarServiceImpl notesBarService = new NotesBarServiceImpl(viewApiAccess.getNotesBarController());
        RedactorService redactorService = new RedactorServiceImpl(viewApiAccess.getRedactorController());

        ((Observable) notesContextService).addObserver(notesBarService);
        ((Observable) redactorContextService).addObserver(redactorService);

        return PresenterApiAccess.builder()
                .notesContextService(notesContextService)
                .redactorContextService(redactorContextService)
                .build();
    }
}
