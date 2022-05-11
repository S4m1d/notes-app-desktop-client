package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observer;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.NotesBarController;

import java.util.List;

public class NotesBarServiceImpl implements Observer<NotesContextUpdateEvent>, NotesBarService {
    private final NotesBarController notesBarController;

    public NotesBarServiceImpl(NotesBarController notesBarController){
        this.notesBarController = notesBarController;
    }

    @Override
    public void addNotes(List<Note> notes) {
        notesBarController.addNotes(notes);
    }

    @Override
    public void addNote(Note note) {
        notesBarController.addNote(note);
    }

    @Override
    public void processEvent(NotesContextUpdateEvent event) {
        List<Note> notes = event.getNotesToAdd();
        switch (event.getMode()) {
            case ADD:
                notesBarController.addNotes(notes);
                break;
            default:
                break;
        }
    }
}
