package ru.s4m1d.notes.app.desktop.client.model.controller;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.List;

public interface NotesContextController {
    public void addNote(Note note);
    public void addNotes(List<Note> notes);
    public List<Note> getNotes();
}
