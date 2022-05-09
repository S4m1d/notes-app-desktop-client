package ru.s4m1d.notes.app.desktop.client.view.layout;

import ru.s4m1d.notes.app.desktop.client.view.layout.strategy.HorizontalScrollBarLayoutStrategy;
import ru.s4m1d.notes.app.desktop.client.view.layout.strategy.LayeredPaneLayoutStrategy;
import ru.s4m1d.notes.app.desktop.client.view.layout.strategy.ScrollPaneLayoutStrategy;
import ru.s4m1d.notes.app.desktop.client.view.layout.strategy.VerticalScrollBarLayoutStrategy;

import javax.swing.*;
import java.awt.*;

public class LayoutStrategyFactory {
    private LayoutStrategyFactory(){}
    public static LayoutStrategyFactory createFactory(){
        return new LayoutStrategyFactory();
    }
    public LayeredPaneLayoutStrategy getStrategy(Component component) throws StrategyNotFoundException {
        LayeredPaneLayoutStrategy layeredPaneLayoutStrategy;
        if(component instanceof JScrollPane) {
            layeredPaneLayoutStrategy = new ScrollPaneLayoutStrategy();
        } else if(component instanceof JScrollBar){
            layeredPaneLayoutStrategy = getStrategyForJScrollBar((JScrollBar)component);
        } else {
            throw new StrategyNotFoundException();
        }
        return layeredPaneLayoutStrategy;
    }

    private LayeredPaneLayoutStrategy getStrategyForJScrollBar(JScrollBar jScrollBar) throws StrategyNotFoundException {
        LayeredPaneLayoutStrategy layeredPaneLayoutStrategy;
        int orientation = jScrollBar.getOrientation();
        if (orientation == JScrollBar.VERTICAL){
            layeredPaneLayoutStrategy = new VerticalScrollBarLayoutStrategy();
        } else if (orientation == JScrollBar.HORIZONTAL) {
            layeredPaneLayoutStrategy = new HorizontalScrollBarLayoutStrategy();
        } else {
            throw new StrategyNotFoundException();
        }
        return layeredPaneLayoutStrategy;
    }
}
