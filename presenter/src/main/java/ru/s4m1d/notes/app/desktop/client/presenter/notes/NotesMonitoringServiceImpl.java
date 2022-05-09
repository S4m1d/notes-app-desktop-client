package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.core.Observer;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NotesMonitoringServiceImpl extends SwingWorker<List<Note>, Void> {

    private NotesSearchService notesSearchService;
    private NotesMonitoringServiceObservable notesMonitoringServiceObservable;

    public NotesMonitoringServiceImpl(){
        notesSearchService = new NotesSearchServiceImpl();
        notesMonitoringServiceObservable = new NotesMonitoringServiceObservable();
    }

    @Override
    protected List<Note> doInBackground() throws Exception {
        List<Note> notes = notesSearchService.searchForNotes();
        return notes;
    }

    @Override
    protected void done(){
        try {
            NotesReceivedEvent notesReceivedEvent = new NotesReceivedEvent(get());
            notesMonitoringServiceObservable.fireEvent(notesReceivedEvent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void addObserver(Observer observer) {
        notesMonitoringServiceObservable.addObserver(observer);
    }
}
