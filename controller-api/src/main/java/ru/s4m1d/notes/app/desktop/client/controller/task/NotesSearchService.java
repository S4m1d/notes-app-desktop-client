package ru.s4m1d.notes.app.desktop.client.controller.task;

import ru.s4m1d.notes.app.desktop.client.controller.datamodel.note.Note;

import java.util.List;

public interface NotesSearchService {
    public List<Note> searchForNotes();
}
