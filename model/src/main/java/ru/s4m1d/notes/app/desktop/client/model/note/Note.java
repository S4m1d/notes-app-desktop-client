package ru.s4m1d.notes.app.desktop.client.model.note;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.model.content.Content;

@Getter
@Setter
@Builder
public class Note {
    public String name;
    public String preview;
    public Content content;
}
