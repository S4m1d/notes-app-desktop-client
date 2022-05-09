package ru.s4m1d.notes.app.desktop.client.view.components.layout.strategy;

import java.awt.*;

public interface LayeredPaneLayoutStrategy <T extends Component> {
    void layoutComponent(T component);
}
