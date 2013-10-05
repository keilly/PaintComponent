package com.keilly.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Component which renders itself by calling out to a series of painters. Each
 * painter renders itself one on top of another into the component.
 */
public class JPainted extends JComponent {

    private MultiPainter multiPainter = new MultiPainter();

    public void addPaint(Painter painter, Point location) {
        multiPainter.addPaint(painter, location);
        invalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Insets insets = getInsets();
        g2.translate(insets.left, insets.top);
        multiPainter.paint(this, g2);
        g2.translate(-insets.left, -insets.top);
    }

    public Dimension getPreferredSize() {
        Dimension preferredSize = multiPainter.getSize(this);

        Insets insets = getInsets();
        preferredSize.width += insets.left + insets.right;
        preferredSize.height += insets.top + insets.bottom;

        return preferredSize;
    }
}
