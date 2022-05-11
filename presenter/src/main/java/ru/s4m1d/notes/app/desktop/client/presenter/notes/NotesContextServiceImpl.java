package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.model.controller.NotesContextController;

import java.util.List;

@RequiredArgsConstructor
public class NotesContextServiceImpl extends Observable implements NotesContextService {
    private final NotesContextController notesContextController;

    @Override
    public void addNotes(List<Note> notes) {
        notesContextController.addNotes(notes);
        NotesContextUpdateEvent notesContextUpdateEvent = new NotesContextUpdateEvent();
        notesContextUpdateEvent.setNotesToAdd(notes);
        notesContextUpdateEvent.setMode(NotesContextUpdateEvent.Mode.ADD);
        fireEvent(notesContextUpdateEvent);
    }

    @Override
    public void addNote(Note note) {
        notesContextController.addNote(note);
        NotesContextUpdateEvent notesContextUpdateEvent = new NotesContextUpdateEvent();
        notesContextUpdateEvent.setNotesToAdd(List.of(note));
        notesContextUpdateEvent.setMode(NotesContextUpdateEvent.Mode.ADD);
        fireEvent(notesContextUpdateEvent);
    }

    @Override
    public List<Note> getNotes() {
        return notesContextController.getNotes();
    }
}
