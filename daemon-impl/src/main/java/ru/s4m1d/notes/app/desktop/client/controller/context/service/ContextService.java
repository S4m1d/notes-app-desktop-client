package ru.s4m1d.notes.app.desktop.client.controller.context.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.s4m1d.notes.app.desktop.client.model.context.SwingApplicationContext;

@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContextService {
    private SwingApplicationContext swingApplicationContext;
}
