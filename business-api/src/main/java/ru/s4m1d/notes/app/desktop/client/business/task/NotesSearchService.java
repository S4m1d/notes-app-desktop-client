package ru.s4m1d.notes.app.desktop.client.business.task;

import ru.s4m1d.notes.app.desktop.client.business.task.datamodel.Note;

import java.util.List;

public interface NotesSearchService {
    public List<Note> searchForNotes();
}
