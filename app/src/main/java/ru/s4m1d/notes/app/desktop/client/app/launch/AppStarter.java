package ru.s4m1d.notes.app.desktop.client.app.launch;

import ru.s4m1d.notes.app.desktop.client.app.configuration.InitialTasksConfiguration;
import ru.s4m1d.notes.app.desktop.client.app.configuration.ModelConfiguration;
import ru.s4m1d.notes.app.desktop.client.app.configuration.PresenterConfiguration;
import ru.s4m1d.notes.app.desktop.client.app.configuration.ViewConfiguration;
import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ModelApiAccess;
import ru.s4m1d.notes.app.desktop.client.app.configuration.access.PresenterApiAccess;
import ru.s4m1d.notes.app.desktop.client.app.configuration.access.ViewApiAccess;

import javax.swing.*;

public class AppStarter {

    public static void createApp(){
        ViewApiAccess viewApiAccess = ViewConfiguration.createView();
        ModelApiAccess modelApiAccess = ModelConfiguration.createModel();
        PresenterApiAccess presenterApiAccess = PresenterConfiguration.createPresenter(viewApiAccess, modelApiAccess);
        InitialTasksConfiguration.configureAndExecute(presenterApiAccess);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createApp();
            }
        });
    }
}
