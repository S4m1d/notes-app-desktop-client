package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.model.note.Note;

import java.util.List;

public interface NotesSearchService {
    public List<Note> searchForNotes();
}
