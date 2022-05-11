package ru.s4m1d.notes.app.desktop.client.view.components.painting;

import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.beans.PropertyChangeListener;

public class CustomScrollPaneUi extends BasicScrollPaneUI {
    public ChangeListener getVsbChangeListener(){
        return vsbChangeListener;
    }
    public PropertyChangeListener getVsbPropertyChangeListener(){
        return createPropertyChangeListener();
    }
    public ChangeListener getHsbChangeListener(){
        return hsbChangeListener;
    }
    public PropertyChangeListener getHsbPropertyChangeListener(){
        return createPropertyChangeListener();
    }
}
