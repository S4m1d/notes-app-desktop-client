package ru.s4m1d.notes.app.desktop.client.business.context;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.business.datamodel.note.Note;
import ru.s4m1d.notes.app.desktop.client.business.task.workspace.WorkspaceEvent;
import ru.s4m1d.notes.app.desktop.client.core.Observable;

@Getter
public class WorkspaceContext extends Observable {
    private Note currentNote;

    public void setCurrentNote(Note note){
        currentNote = note;
        fireEvent(new WorkspaceEvent());
    }
}
