package ru.s4m1d.notes.app.desktop.client.view.controller.notes;

import lombok.RequiredArgsConstructor;
import ru.s4m1d.notes.app.desktop.client.dto.note.Note;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NoteTab;
import ru.s4m1d.notes.app.desktop.client.view.components.choice.bar.NotesPane;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class NotesBarControllerImpl implements NotesBarController {
    private final NotesPane notesPane;

    @Override
    public void addNote(Note note) {
        NoteTab noteTab = new NoteTab();
        noteTab.setNotesName(note.getName());
        notesPane.add(noteTab);
        noteTab.initialize();
    }

    @Override
    public void addNotes(List<Note> notes) {
        for (Note note: notes) {
            addNote(note);
        }
    }

    @Override
    public void clearNotes() {
        notesPane.removeAll();
    }

    @Override
    public void resetNotes(List<Note> notes) {
        clearNotes();
        addNotes(notes);
    }
}
