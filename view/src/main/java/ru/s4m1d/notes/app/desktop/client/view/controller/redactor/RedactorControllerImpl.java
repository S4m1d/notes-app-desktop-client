package ru.s4m1d.notes.app.desktop.client.view.controller.redactor;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.view.components.workspace.RedactorLayeredPane;

import javax.swing.text.DefaultStyledDocument;
import java.io.IOException;
import java.io.InputStream;

@RequiredArgsConstructor
public class RedactorControllerImpl implements RedactorController{
    private final RedactorLayeredPane redactorLayeredPane;

    @Override
    public void setCurrentNote(InputStream inputStream) {
        try {
            redactorLayeredPane.getRedactorScrollPane().getTextEditorPane().read(inputStream, new DefaultStyledDocument());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
