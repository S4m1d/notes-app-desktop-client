package ru.s4m1d.notes.app.desktop.client.business.task.datamodel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Note {
    public String name;
    public String preview;
}
