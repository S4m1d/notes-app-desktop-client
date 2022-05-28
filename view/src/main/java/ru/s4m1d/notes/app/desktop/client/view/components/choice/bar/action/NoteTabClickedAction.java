package ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.action;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.view.controller.notes.action.NoteTabClickedActionObservable;

import javax.swing.*;
import java.awt.event.ActionEvent;

//Observer of note tab
@RequiredArgsConstructor
public class NoteTabClickedAction extends AbstractAction {
    private final NoteTabClickedActionObservable noteTabClickedActionObservable;

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
