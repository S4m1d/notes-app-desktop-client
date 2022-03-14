package ru.s4m1d.notes.app.desktop.client.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilTest {
    public static String FILE_NAME = "some_name";
    public static String EXTENSION = ".json";
    @Test
    public void cutExtension_positive_test(){
        String fileNameWithExtension = FILE_NAME + EXTENSION;
        String result = StringUtil.cutExtension(fileNameWithExtension);
        Assert.assertEquals(result, FILE_NAME);
    }
}
