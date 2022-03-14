package ru.s4m1d.notes.app.desktop.client.system.file;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileScannerImpl implements FileScanner{
    private Path directory;

    public FileScannerImpl() {
        directory = Path.of(System.getProperty("notes.dir"),"notes-app-desktop-client\\system-impl\\src\\main\\resources");
    }

    @Override
    public List<File> scanForFiles() {
        return Stream.of(new File(directory.toString()).listFiles())
                .filter(file -> !file.isDirectory())
                .collect(Collectors.toList());
    }
}
