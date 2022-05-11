package ru.s4m1d.notes.app.desktop.client.view.components.layout.strategy;

import javax.swing.*;
import java.awt.*;

public class ScrollPaneLayoutStrategy implements LayeredPaneLayoutStrategy<JScrollPane>{
    @Override
    public void layoutComponent(JScrollPane component) {
        Rectangle availableRectangle = component.getParent().getBounds();
        component.setBounds(availableRectangle);
    }
}
