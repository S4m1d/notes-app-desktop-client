package ru.s4m1d.notes.app.desktop.client.model.content;

import lombok.AllArgsConstructor;

import java.io.*;

@AllArgsConstructor
public class FileContent implements Content<InputStream>{
    private File file;

    @Override
    public InputStream get() {
        FileInputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return (InputStream) fileOutputStream;
    }
}
