package ru.s4m1d.notes.app.desktop.client.components.choice.bar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NoteTab extends JButton {
    private NotesBarSettings notesBarSettings;

    public NoteTab(){
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
}
