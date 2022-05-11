package ru.s4m1d.notes.app.desktop.client.model.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SwingApplicationContext {
    private RedactorContext redactorContext;
    private NotesContext notesContext;
}
