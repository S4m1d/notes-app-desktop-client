package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.core.observe.Event;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.List;

@Getter
@Setter
public class NotesContextUpdateEvent implements Event {
    private Mode mode;
    private List<Note> notesToAdd;

    public enum Mode {
        ADD
    }
}
