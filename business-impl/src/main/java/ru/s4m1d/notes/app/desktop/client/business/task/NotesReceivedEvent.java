package ru.s4m1d.notes.app.desktop.client.business.task;

import ru.s4m1d.notes.app.desktop.client.core.Event;

import java.io.File;
import java.util.List;

public class NotesReceivedEvent implements Event {
    public List<File> notes;

    public NotesReceivedEvent(List<File> notes) {
        this.notes = notes;
    }

    public List<File> getNotes(){
        return notes;
    }
}
