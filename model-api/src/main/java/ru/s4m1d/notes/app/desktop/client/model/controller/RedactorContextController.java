package ru.s4m1d.notes.app.desktop.client.model.controller;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

public interface RedactorContextController {
    public Note getCurrentNote();
    public void setCurrentNote(Note note);
}
