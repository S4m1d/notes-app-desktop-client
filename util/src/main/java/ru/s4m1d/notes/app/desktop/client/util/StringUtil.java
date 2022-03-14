package ru.s4m1d.notes.app.desktop.client.util;

public class StringUtil {
    public static String cutExtension(String fileName){
        String result = new String(fileName);
        boolean isExtensionPresent = false;
        int length = fileName.length();
        int dotPosition = 0;
        for (int i = 0; i<length; i++) {
            if (fileName.charAt(i) == '.') {
                dotPosition = i;
                isExtensionPresent = true;
            }
        }
        if (isExtensionPresent) {
            result = fileName.substring(0,dotPosition);
        }
        return result;
    }
}
