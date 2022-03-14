package ru.s4m1d.notes.app.desktop.client.business.task;

import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NoteTab;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesBarScrollPane;
import ru.s4m1d.notes.app.desktop.client.components.choice.bar.NotesPane;
import ru.s4m1d.notes.app.desktop.client.core.Observer;

import java.io.File;
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
        List<File> noteFiles = notesReceivedEvent.getNotes();
        for (File noteFile:noteFiles){
            NoteTab noteTab = new NoteTab();
            noteTab.setNotesName(noteFile.getName());
            notesPane.add(noteTab);
            noteTab.initialize();
        }
        notesBarUpdateServiceObservable.fireEvent(new NewComponentEvent());
    }

    public void addObserver(Observer<NewComponentEvent> observer){
        notesBarUpdateServiceObservable.addObserver(observer);
    }
}
