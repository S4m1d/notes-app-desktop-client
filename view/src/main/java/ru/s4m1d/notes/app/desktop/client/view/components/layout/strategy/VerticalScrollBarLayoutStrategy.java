package ru.s4m1d.notes.app.desktop.client.view.components.layout.strategy;

import javax.swing.*;
import java.awt.*;

public class VerticalScrollBarLayoutStrategy implements LayeredPaneLayoutStrategy<JScrollBar>{
    @Override
    public void layoutComponent(JScrollBar component) {
        Rectangle availableRectangle = component.getParent().getBounds();
        Dimension prefSize = component.getPreferredSize();
        int height;
        int width;
        if (availableRectangle.width < prefSize.width){
            width = availableRectangle.width;
        } else {
            width = prefSize.width;
        }
        height = availableRectangle.height;
        int x = availableRectangle.x + availableRectangle.width - width;
        int y = availableRectangle.y;
        component.setBounds(x,y,width,height);
    }
}
