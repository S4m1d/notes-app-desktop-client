package ru.s4m1d.notes.app.desktop.client.view.components.choice.bar;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class NotesBarSettings {
    private int notesBarPreferredHeight = 1080;
    private int notesBarPreferredWidth = 200;
    private Color notesBarBackgroundColor = new Color(47, 46, 46);
    private Color notesTabBackgroundColor = new Color(40, 43, 72);
    private Color notesTabForegroundColor = new Color(246, 239, 229);
}
