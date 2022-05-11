package ru.s4m1d.notes.app.desktop.client.presenter.redactor;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

public interface RedactorContextService {
    public void setCurrentNote(Note note);
    public Note getCurrentNote();
}
