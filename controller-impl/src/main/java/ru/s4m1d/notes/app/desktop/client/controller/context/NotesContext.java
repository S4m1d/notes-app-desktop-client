package ru.s4m1d.notes.app.desktop.client.controller.context;

import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.controller.datamodel.note.Note;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class NotesContext {
    List<Note> notes;

    public NotesContext(){
        notes = new ArrayList<>();
    }

    public void addNote(Note note) {
        notes.add(note);
    }

    public void addNotes(Collection<Note> notes) {
        this.notes.addAll(notes);
    }
}
