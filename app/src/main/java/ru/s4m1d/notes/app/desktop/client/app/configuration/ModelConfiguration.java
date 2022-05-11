package ru.s4m1d.notes.app.desktop.client.app.configuration;

import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ModelApiAccess;
import ru.s4m1d.notes.app.desktop.client.model.context.NotesContext;
import ru.s4m1d.notes.app.desktop.client.model.context.RedactorContext;
import ru.s4m1d.notes.app.desktop.client.model.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextController;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextControllerImpl;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextController;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextControllerImpl;

public class ModelConfiguration {
    public static ModelApiAccess createModel() {
        SwingApplicationContext swingApplicationContext = new SwingApplicationContext(new RedactorContext(), new NotesContext());

        NotesContextController notesContextController = new NotesContextControllerImpl(swingApplicationContext.getNotesContext());
        RedactorContextController redactorContextController = new RedactorContextControllerImpl(swingApplicationContext.getRedactorContext());

        return ModelApiAccess.builder()
                .notesContextController(notesContextController)
                .redactorContextController(redactorContextController)
                .build();
    }
}
