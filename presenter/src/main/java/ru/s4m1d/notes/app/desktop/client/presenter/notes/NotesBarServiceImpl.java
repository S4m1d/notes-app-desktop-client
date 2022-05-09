package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.view.choice.bar.NoteTab;
import ru.s4m1d.notes.app.desktop.client.view.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.core.Observer;
import ru.s4m1d.notes.app.desktop.client.presenter.mainframe.NewComponentEvent;

import java.util.List;

public class NotesBarServiceImpl extends Observer<NotesReceivedEvent> implements NotesBarUpdateService {
    private NotesPane notesPane;
    private NotesBarUpdateServiceObservable notesBarUpdateServiceObservable;

    public NotesBarServiceImpl(NotesPane notesPane){
        this.notesPane = notesPane;
        this.notesBarUpdateServiceObservable = new NotesBarUpdateServiceObservable();
    }

    @Override
    public void processEvent(NotesReceivedEvent notesReceivedEvent) {
        List<Note> notes = notesReceivedEvent.getNotes();
        for (Note note:notes){
            NoteTab noteTab = new NoteTab();
            noteTab.setNotesName(note.getName());
            notesPane.add(noteTab);
            noteTab.initialize();
        }
        notesBarUpdateServiceObservable.fireEvent(new NewComponentEvent());
    }

    public void addObserver(Observer<NewComponentEvent> observer){
        notesBarUpdateServiceObservable.addObserver(observer);
    }
}
