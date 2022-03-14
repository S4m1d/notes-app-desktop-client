package ru.s4m1d.notes.app.desktop.client.system.file;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class FileScannerImplTest {
    private FileScanner fileScanner;

    @BeforeClass
    public void setUp(){
        fileScanner = new FileScannerImpl();
    }

    @Test
    public void scanForFiles_positive_test(){
        List<File> fileList = fileScanner.scanForFiles();
        Assert.assertFalse(fileList.isEmpty());
    }
}
