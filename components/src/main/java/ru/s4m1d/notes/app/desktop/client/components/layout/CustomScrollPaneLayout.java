package ru.s4m1d.notes.app.desktop.client.components.layout;

import javax.swing.*;
import java.awt.*;

public class CustomScrollPaneLayout extends ScrollPaneLayout {
    private static final int SB_SIZE = 10;

    @Override
    public void layoutContainer(Container parent) {
        Rectangle availR = ((JScrollPane) parent).getBounds();
        ((JScrollPane)parent).getViewport().setBounds(availR);
    }
    private boolean isVerticalScrollBarfNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getHeight() > viewRect.getHeight();
    }

    private boolean isHorizontalScrollBarNecessary() {
        Rectangle viewRect = viewport.getViewRect();
        Dimension viewSize = viewport.getViewSize();
        return viewSize.getWidth() > viewRect.getWidth();
    }
}
