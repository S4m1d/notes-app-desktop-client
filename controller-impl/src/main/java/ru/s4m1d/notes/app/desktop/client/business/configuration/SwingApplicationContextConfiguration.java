package ru.s4m1d.notes.app.desktop.client.business.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.s4m1d.notes.app.desktop.client.business.context.NotesContext;
import ru.s4m1d.notes.app.desktop.client.business.context.SwingApplicationContext;
import ru.s4m1d.notes.app.desktop.client.business.context.WorkspaceContext;

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
