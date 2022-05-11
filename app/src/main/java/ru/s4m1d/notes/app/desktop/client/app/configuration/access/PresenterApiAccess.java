package ru.s4m1d.notes.app.desktop.client.app.configuration.access;

import lombok.Builder;
import lombok.Getter;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesContextService;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorContextService;

@Builder
@Getter
public class PresenterApiAccess {
    private NotesContextService notesContextService;
    private RedactorContextService redactorContextService;
}
