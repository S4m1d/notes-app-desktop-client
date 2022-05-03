package ru.s4m1d.notes.app.desktop.client.controller.datamodel.note;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.controller.datamodel.content.Content;

@Getter
@Setter
@Builder
public class Note {
    public String name;
    public String preview;
    public Content content;
}
