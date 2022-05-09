package ru.s4m1d.notes.app.desktop.client.view.workspace;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter
public class WorkSpaceSettings {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static WorkSpaceSettings settings;
    private Color workSpaceBackgroundColor = new Color(94, 88, 80);
    private Color workSpaceForegroundColor = new Color(246, 239, 229);

    private WorkSpaceSettings(){}

    public static WorkSpaceSettings get(){
        if (settings == null) {
            settings = new WorkSpaceSettings();
        }
        return settings;
    }
}
