package ru.s4m1d.notes.app.desktop.client.business.task.notes;

import ru.s4m1d.notes.app.desktop.client.business.task.datamodel.Note;
import ru.s4m1d.notes.app.desktop.client.core.Event;

import java.io.File;
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
