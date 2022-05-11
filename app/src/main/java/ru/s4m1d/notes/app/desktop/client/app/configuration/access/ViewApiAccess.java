package ru.s4m1d.notes.app.desktop.client.app.configuration.access;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarController;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorController;

@Builder
@Getter
public class ViewApiAccess {
    NotesBarController notesBarController;
    RedactorController redactorController;
}
