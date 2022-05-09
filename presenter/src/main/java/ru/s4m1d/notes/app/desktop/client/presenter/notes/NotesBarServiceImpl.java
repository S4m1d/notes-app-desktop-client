package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NoteTab;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.core.Observer;
import ru.s4m1d.notes.app.desktop.client.presenter.mainframe.NewComponentEvent;

import java.util.List;

public class NotesBarServiceImpl extends Observer<NotesReceivedEvent> implements NotesBarService {
    private NotesPane notesPane;
    private NotesBarServiceObservable notesBarServiceObservable;

    public NotesBarServiceImpl(NotesPane notesPane){
        this.notesPane = notesPane;
        this.notesBarServiceObservable = new NotesBarServiceObservable();
    }

    @Override
    public void processEvent(NotesReceivedEvent notesReceivedEvent) {
        List<Note> notes = notesReceivedEvent.getNotes();
        addNotes(notes);
        notesBarServiceObservable.fireEvent(new NewComponentEvent());
    }

    public void addObserver(Observer<NewComponentEvent> observer){
        notesBarServiceObservable.addObserver(observer);
    }

    @Override
    public void addNotes(List<Note> notes) {
        for (Note note: notes) {
            addNote(note);
        }
    }

    @Override
    public void addNote(Note note) {
        NoteTab noteTab = new NoteTab();
        noteTab.setNotesName(note.getName());
        notesPane.add(noteTab);
        noteTab.initialize();
    }
}
