package ru.s4m1d.notes.app.desktop.client.view.controller.notes;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.List;

public interface NotesBarController {
    public void addNote(Note note);
    public void addNotes(List<Note> notes);
    public void clearNotes();
    public void resetNotes(List<Note> notes);
}
