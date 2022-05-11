package ru.s4m1d.notes.app.desktop.client.core.notes;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.List;

public interface NotesSearchService {
    public List<Note> searchForNotes();
}
