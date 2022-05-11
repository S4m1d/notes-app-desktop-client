package ru.s4m1d.notes.app.desktop.client.model.controller;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.model.context.NotesContext;

import java.util.List;

@RequiredArgsConstructor
public class NotesContextControllerImpl implements NotesContextController{
    private final NotesContext notesContext;

    @Override
    public void addNote(Note note) {
        notesContext.getNotes().add(note);
    }

    @Override
    public void addNotes(List<Note> notes) {
        notesContext.getNotes().addAll(notes);
    }

    @Override
    public List<Note> getNotes() {
        return notesContext.getNotes();
    }
}
