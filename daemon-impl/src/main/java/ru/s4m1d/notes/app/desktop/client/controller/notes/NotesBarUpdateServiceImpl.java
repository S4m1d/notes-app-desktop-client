package ru.s4m1d.notes.app.desktop.client.controller.notes;

import ru.s4m1d.notes.app.desktop.client.controller.task.NewComponentEvent;
import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NoteTab;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.core.Observer;

import java.util.List;

public class NotesBarUpdateServiceImpl extends Observer<NotesReceivedEvent> {
    private NotesPane notesPane;
    private NotesBarUpdateServiceObservable notesBarUpdateServiceObservable;

    public NotesBarUpdateServiceImpl(NotesPane notesPane){
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
