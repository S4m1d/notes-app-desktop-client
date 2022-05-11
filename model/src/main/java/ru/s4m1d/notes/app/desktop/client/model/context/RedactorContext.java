package ru.s4m1d.notes.app.desktop.client.model.context;

import lombok.Getter;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.model.event.WorkspaceEvent;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;

@Getter
public class RedactorContext extends Observable {
    private Note currentNote;

    public void setCurrentNote(Note note){
        currentNote = note;
        fireEvent(new WorkspaceEvent());
    }
}
