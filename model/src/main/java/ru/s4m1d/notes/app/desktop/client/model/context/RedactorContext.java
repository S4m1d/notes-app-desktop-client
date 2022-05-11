package ru.s4m1d.notes.app.desktop.client.model.context;

import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

@Getter
@Setter
public class RedactorContext {
    private Note currentNote;
}
