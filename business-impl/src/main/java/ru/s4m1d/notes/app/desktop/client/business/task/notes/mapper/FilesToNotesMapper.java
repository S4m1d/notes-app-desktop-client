package ru.s4m1d.notes.app.desktop.client.business.task.notes.mapper;

import ru.s4m1d.notes.app.desktop.client.business.task.datamodel.Note;
import ru.s4m1d.notes.app.desktop.client.util.StringUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FilesToNotesMapper {
    public List<Note> map(List<File> files) {
        List<Note> result = new ArrayList<>();
        for (File file: files) {
            Note note = Note.builder()
                    .name(StringUtil.cutExtension(file.getName()))
                    .build();
            result.add(note);
        }
        return result;
    }
}
