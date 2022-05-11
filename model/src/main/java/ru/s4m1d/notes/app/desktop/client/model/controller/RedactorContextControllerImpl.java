package ru.s4m1d.notes.app.desktop.client.model.controller;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.model.context.RedactorContext;
import ru.s4m1d.notes.app.desktop.client.presenter.redactor.RedactorContextUpdateEvent;

@RequiredArgsConstructor
public class RedactorContextControllerImpl extends Observable implements RedactorContextController {
    private final RedactorContext redactorContext;

    @Override
    public Note getCurrentNote() {
        return redactorContext.getCurrentNote();
    }

    @Override
    public void setCurrentNote(Note note) {
        redactorContext.setCurrentNote(note);
    }
}
