package ru.s4m1d.notes.app.desktop.client.business.task;

import ru.s4m1d.notes.app.desktop.client.core.Observable;
import ru.s4m1d.notes.app.desktop.client.core.Observer;
import ru.s4m1d.notes.app.desktop.client.system.file.FileScanner;
import ru.s4m1d.notes.app.desktop.client.system.file.FileScannerImpl;

import javax.swing.*;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class NotesMonitoringServiceImpl extends SwingWorker<List<File>, Void> {
    private FileScanner fileScanner;
    private NotesMonitoringServiceObservable notesMonitoringServiceObservable;

    public NotesMonitoringServiceImpl(){
        fileScanner = new FileScannerImpl();
        notesMonitoringServiceObservable = new NotesMonitoringServiceObservable();
    }

    @Override
    protected List<File> doInBackground() throws Exception {
        List<File> noteFiles = fileScanner.scanForFiles();
        return noteFiles;
    }

    @Override
    protected void done(){
        try {
            NotesReceivedEvent notesReceivedEvent = new NotesReceivedEvent(get());
            notesMonitoringServiceObservable.fireEvent(notesReceivedEvent);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void addObserver(Observer observer) {
        notesMonitoringServiceObservable.addObserver(observer);
    }
}
