package ru.s4m1d.notes.app.desktop.client.presenter.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.s4m1d.notes.app.desktop.client.model.context.NotesContext;
import ru.s4m1d.notes.app.desktop.client.model.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.model.context.WorkspaceContext;

@Configuration
public class SwingApplicationContextConfiguration {
    @Bean
    public SwingApplicationContext swingApplicationContext(WorkspaceContext workspaceContext, NotesContext notesContext) {
        return new SwingApplicationContext(workspaceContext, notesContext);
    }

    @Bean
    public WorkspaceContext workspaceContext(){
        return new WorkspaceContext();
    }

    @Bean
    public NotesContext notesContext(){
        return new NotesContext();
    }
}
