package ru.s4m1d.notes.app.desktop.client.app.configuration.access;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextController;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextController;

@Builder
@Getter
public class ModelApiAccess {
    NotesContextController notesContextController;
    RedactorContextController redactorContextController;
}
