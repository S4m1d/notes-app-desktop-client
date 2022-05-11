package ru.s4m1d.notes.app.desktop.client.initialization.tasks;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.notes.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.presenter.notes.NotesContextService;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorContextService;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RequiredArgsConstructor
public class ContextInitTask extends SwingWorker<List<Note>, Void> {
    private final NotesSearchService notesSearchService;
    private final NotesContextService notesContextService;
    private final RedactorContextService redactorContextService;
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * <p>
     * Note that this method is executed only once.
     *
     * <p>
     * Note: this method is executed in a background thread.
     *
     * @return the computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    protected List<Note> doInBackground() throws Exception {
        return notesSearchService.searchForNotes();
    }
    @Override
    protected void done() {
        try {
            notesContextService.addNotes(get());
            redactorContextService.setCurrentNote(notesContextService.getNotes().get(0));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
