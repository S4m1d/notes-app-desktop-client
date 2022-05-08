package ru.s4m1d.notes.app.desktop.client.controller.notes;

import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.core.Event;

import java.util.List;

public class NotesReceivedEvent implements Event {
    public List<Note> notes;

    public NotesReceivedEvent(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> getNotes(){
        return notes;
    }
}
