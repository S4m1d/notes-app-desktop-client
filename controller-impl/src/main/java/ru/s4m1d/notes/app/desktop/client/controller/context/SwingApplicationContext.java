package ru.s4m1d.notes.app.desktop.client.controller.context;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SwingApplicationContext {
    private WorkspaceContext workspaceContext;
    private NotesContext notesContext;
}
