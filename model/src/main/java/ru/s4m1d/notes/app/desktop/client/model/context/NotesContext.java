package ru.s4m1d.notes.app.desktop.client.model.context;

import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class NotesContext {
    List<Note> notes;

    public NotesContext(){
        notes = new ArrayList<>();
    }
}
