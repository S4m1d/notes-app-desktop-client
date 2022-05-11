package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.core.observe.Observer;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.List;

public interface NotesContextService {
    public void addNotes (List<Note> notes);
    public void addNote (Note note);
    public List<Note> getNotes ();
//    public void addObserver(Observer observer);
}
