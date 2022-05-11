package ru.s4m1d.notes.app.desktop.client.presenter.redactor;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.core.observe.Observable;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.model.controller.RedactorContextController;

@RequiredArgsConstructor
public class RedactorContextServiceImpl extends Observable implements RedactorContextService{
    private final RedactorContextController redactorContextController;
    @Override
    public void setCurrentNote(Note note) {
        redactorContextController.setCurrentNote(note);
        fireEvent(new RedactorContextUpdateEvent(note, RedactorContextUpdateEvent.Mode.SET_CURRENT_NOTE));
    }
    @Override
    public Note getCurrentNote() {
        return redactorContextController.getCurrentNote();
    }
}
