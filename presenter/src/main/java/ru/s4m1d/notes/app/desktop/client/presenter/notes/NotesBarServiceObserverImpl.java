package ru.s4m1d.notes.app.desktop.client.presenter.notes;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observer;

@RequiredArgsConstructor
public class NotesBarServiceObserverImpl implements Observer<NotesContextUpdateEvent>,NotesBarServiceObserver {
    private final NotesBarService notesBarService;

    @Override
    public void processEvent(NotesContextUpdateEvent notesContextUpdateEvent) {
        notesBarService.addNotes(notesContextUpdateEvent.getNotesToAdd());
    }
}
