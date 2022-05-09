package ru.s4m1d.notes.app.desktop.client.daemon.task.context;

import ru.s4m1d.notes.app.desktop.client.model.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.model.note.Note;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesSearchServiceImpl;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ContextInitializationTask extends SwingWorker<List<Note>, Void> {

    private NotesSearchService notesSearchService;
    private SwingApplicationContext swingApplicationContext;

    public ContextInitializationTask(SwingApplicationContext swingApplicationContext){
        notesSearchService = new NotesSearchServiceImpl();
        this.swingApplicationContext = swingApplicationContext;
    }

    @Override
    protected List<Note> doInBackground() throws Exception {

        List<Note> notes = notesSearchService.searchForNotes();
        return notes;
    }

    @Override
    protected void done(){
        try {
            swingApplicationContext.getNotesContext().addNotes(get());
            swingApplicationContext.getWorkspaceContext().setCurrentNote(get().get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
