package ru.s4m1d.notes.app.desktop.client.view.components.choice.bar;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NotesPane extends JPanel {
    private NotesBarSettings notesBarSettings;
    public NotesPane(){
        super();
        notesBarSettings = new NotesBarSettings();
    }
    public void initialize(){
        setPreferredSize(new Dimension(notesBarSettings.getNotesBarPreferredWidth(), notesBarSettings.getNotesBarPreferredHeight()));
        setBackground(notesBarSettings.getNotesBarBackgroundColor());
        setBorder(new LineBorder(new Color(0,0,0)));
        getInsets().set(0,0,0,0);
        setLayout(new FlowLayout());
    }
}
