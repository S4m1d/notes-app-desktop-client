package ru.s4m1d.notes.app.desktop.client.view.controller.notes.action;

import java.awt.event.ActionEvent;

public class NoteTabClickedActionEvent extends ActionEvent {
    /**
     * Constructs an {@code ActionEvent} object.
     * <p>
     * This method throws an
     * {@code IllegalArgumentException} if {@code source}
     * is {@code null}.
     * A {@code null command} string is legal,
     * but not recommended.
     *
     * @param source  The object that originated the event
     * @param id      An integer that identifies the event.
     *                For information on allowable values, see
     *                the class description for {@link ActionEvent}
     * @param command A string that may specify a command (possibly one
     *                of several) associated with the event
     * @throws IllegalArgumentException if {@code source} is null
     * @see #getSource()
     * @see #getID()
     * @see #getActionCommand()
     */
    public NoteTabClickedActionEvent(Object source, int id, String command) {
        super(source, id, command);
    }
}
