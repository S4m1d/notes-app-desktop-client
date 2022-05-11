package ru.s4m1d.notes.app.desktop.client.view.components.workspace;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class RedactorSettings {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static RedactorSettings settings;
    private Color workSpaceBackgroundColor = new Color(94, 88, 80);
    private Color workSpaceForegroundColor = new Color(246, 239, 229);

    private RedactorSettings(){}

    public static RedactorSettings get(){
        if (settings == null) {
            settings = new RedactorSettings();
        }
        return settings;
    }
}
