package ru.s4m1d.notes.app.desktop.client.business.task.context;

import ru.s4m1d.notes.app.desktop.client.business.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.business.datamodel.note.Note;
import ru.s4m1d.notes.app.desktop.client.business.task.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.business.notes.NotesSearchServiceImpl;

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
