package ru.s4m1d.notes.app.desktop.client.presenter.redactor;

import lombok.AllArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.view.controller.redactor.RedactorController;

import javax.swing.text.DefaultStyledDocument;
import java.io.IOException;
import java.io.InputStream;

@AllArgsConstructor
public class RedactorServiceImpl implements RedactorService {
    private RedactorController redactorController;

    public void loadCurrentNote(Note note) {
        redactorController.setCurrentNote((InputStream) note.getContent().get());
    }

    @Override
    public void processEvent(RedactorContextUpdateEvent event) {
        switch (event.getMode()){
            case SET_CURRENT_NOTE:
                loadCurrentNote(event.getCurrentNote());
                break;
            default:
                break;
        }
    }
}
