package ru.s4m1d.notes.app.desktop.client.view.components.layout.strategy;

import javax.swing.*;
import java.awt.*;

public class HorizontalScrollBarLayoutStrategy implements LayeredPaneLayoutStrategy<JScrollBar>{
    @Override
    public void layoutComponent(JScrollBar component) {
        Rectangle availableRectangle = component.getParent().getBounds();
        Dimension prefSize = component.getPreferredSize();
        int height;
        int width;
        if (availableRectangle.height < prefSize.height){
            height = availableRectangle.height;
        } else {
            height = prefSize.height;
        }
        width = availableRectangle.width;
        int x = availableRectangle.x;
        int y = availableRectangle.y + availableRectangle.height - height;
        component.setBounds( x, y, width, height);
    }
}
