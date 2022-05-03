package ru.s4m1d.notes.app.desktop.client.business.notes;

import ru.s4m1d.notes.app.desktop.client.business.task.NotesSearchService;
import ru.s4m1d.notes.app.desktop.client.business.datamodel.note.Note;
import ru.s4m1d.notes.app.desktop.client.business.notes.mapper.FilesToNotesMapper;
import ru.s4m1d.notes.app.desktop.client.system.file.FileScanner;
import ru.s4m1d.notes.app.desktop.client.system.file.FileScannerImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class NotesSearchServiceImpl implements NotesSearchService {
    private FileScanner fileScanner;

    public NotesSearchServiceImpl(){
        fileScanner = new FileScannerImpl();
    }

    @Override
    public List<Note> searchForNotes() {
        List<Note> notes = new ArrayList<>();
        List<File> files = fileScanner.scanForFiles();
        FilesToNotesMapper filesToNotesMapper = new FilesToNotesMapper();
        notes.addAll(filesToNotesMapper.map(files));
        return notes;
    }
}
