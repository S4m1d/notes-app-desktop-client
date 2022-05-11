package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.core.observe.Event;

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
