package ru.s4m1d.notes.app.desktop.client.business.datamodel.content;

import lombok.AllArgsConstructor;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import java.io.*;
import java.util.stream.Stream;

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
