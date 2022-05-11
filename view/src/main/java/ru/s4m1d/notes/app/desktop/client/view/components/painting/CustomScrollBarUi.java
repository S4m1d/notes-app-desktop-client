package ru.s4m1d.notes.app.desktop.client.view.components.painting;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollBarUi extends BasicScrollBarUI {
    private final Dimension dimension = new Dimension();

    @Override protected JButton createDecreaseButton(int orientation) {
        return new JButton() {
            @Override public Dimension getPreferredSize() {
                return dimension;
            }
        };
    }
    @Override protected JButton createIncreaseButton(int orientation) {
        return new JButton() {
            @Override public Dimension getPreferredSize() {
                return dimension;
            }
        };
    }

    //commented code has a bug
    @Override
    protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
//        Graphics2D graphics2D = (Graphics2D)g.create();
//        Color color = null;
//        if(isDragging) {
//            color = new Color(84, 86, 88, 50);
//        } else if(isThumbRollover()) {
//            color = new Color(84, 86, 88, 50);
//        } else {
//            color = new Color(84, 86, 88, 0);
//        }
//        graphics2D.setPaint(color);
//        graphics2D.fillRect(r.x,r.y,r.width,r.height);
//        graphics2D.drawRect(r.x,r.y,r.width,r.height);
//        graphics2D.dispose();
    }

    @Override
    protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
        Graphics2D g2 = (Graphics2D)g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        Color color = null;
        JScrollBar sb = (JScrollBar)c;
        if(!sb.isEnabled() || r.width>r.height) {
            return;
        } else if(isDragging) {
            color = new Color(84, 86, 88, 150);
        } else if(isThumbRollover()) {
            color = new Color(84, 86, 88, 150);
        } else {
            color = new Color(84, 86, 88, 90);
        }
        g2.setPaint(color);
        g2.fillRect(r.x,r.y,r.width,r.height);
        g2.dispose();
    }

    @Override
    protected void setThumbBounds(int x, int y, int width, int height) {
        super.setThumbBounds(x, y, width, height);
        scrollbar.repaint();
    }
}
