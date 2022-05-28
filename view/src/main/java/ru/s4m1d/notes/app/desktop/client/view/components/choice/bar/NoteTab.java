package ru.s4m1d.notes.app.desktop.client.view.components.choice.bar;

import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.action.NoteTabClickedAction;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NoteTab extends JButton {
    private NotesBarSettings notesBarSettings;

    public NoteTab(){
        notesBarSettings = new NotesBarSettings();
    }

    public NoteTab(NoteTabClickedAction noteTabClickedAction) {
        super(noteTabClickedAction);
        notesBarSettings = new NotesBarSettings();
    }

    public void initialize() {
        setOpaque(true);
        setBackground(notesBarSettings.getNotesTabBackgroundColor());
        setForeground(notesBarSettings.getNotesTabForegroundColor());
        setBorder(new LineBorder(new Color(0,0,0)));
        setPreferredSize(new Dimension(notesBarSettings.getNotesBarPreferredWidth(),100));
    }
    public void setNotesName(String name) {
        setText(name);
    }

    @Override
    protected void fireActionPerformed(ActionEvent event) {
        // Guaranteed to return a non-null array
        Object[] listeners = listenerList.getListenerList();
        ActionEvent e = null;
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length-2; i>=0; i-=2) {
            if (listeners[i]== ActionListener.class) {
                // Lazily create the event:
                if (e == null) {
                    String actionCommand = event.getActionCommand();
                    if(actionCommand == null) {
                        actionCommand = getActionCommand();
                    }
                    e = new ActionEvent(NoteTab.this,
                            ActionEvent.ACTION_PERFORMED,
                            actionCommand,
                            event.getWhen(),
                            event.getModifiers());
                }
                ((ActionListener)listeners[i+1]).actionPerformed(e);
            }
        }
    }
}
