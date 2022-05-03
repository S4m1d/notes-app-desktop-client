package ru.s4m1d.notes.app.desktop.client.controller.context;

import lombok.Getter;
import ru.s4m1d.notes.app.desktop.client.controller.datamodel.note.Note;
import ru.s4m1d.notes.app.desktop.client.controller.task.workspace.WorkspaceEvent;
import ru.s4m1d.notes.app.desktop.client.core.Observable;

@Getter
public class WorkspaceContext extends Observable {
    private Note currentNote;

    public void setCurrentNote(Note note){
        currentNote = note;
        fireEvent(new WorkspaceEvent());
    }
}
