package ru.s4m1d.notes.app.desktop.client.presenter.redactor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.core.observe.Event;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

@Getter
@Setter
@AllArgsConstructor
public class RedactorContextUpdateEvent implements Event {
    Note currentNote;
    Mode mode;
    public enum Mode {
        SET_CURRENT_NOTE
    }
}
