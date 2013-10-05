/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keilly.paint;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

/**
 * Painter that will paint a collection of sub painters.
 */
public class MultiPainter implements Painter {

    private List<Paint> paints = new ArrayList<>();

    public void addPaint(Painter painter, Point location) {
        paints.add(new Paint(painter, location));
    }

    @Override
    public void paint(JPainted paintComponent, Graphics2D g2) {
        for (Paint paint : paints) {
            Graphics2D painterG = (Graphics2D) g2.create();
            painterG.translate(paint.location.x, paint.location.y);
            paint.painter.paint(paintComponent, painterG);
            painterG.translate(-paint.location.x, -paint.location.y);
            painterG.dispose();
        }
    }

    public Dimension getSize(JPainted painted) {
        Dimension preferredSize = new Dimension(10, 10);
        for (Paint paint : paints) {
            Dimension size = paint.painter.getSize(painted);
            preferredSize.width = Math.max(preferredSize.width, paint.location.x + size.width + 1);
            preferredSize.height = Math.max(preferredSize.height, paint.location.y + size.height + 1);
        }

        return preferredSize;
    }

    private class Paint {

        private final Painter painter;
        private final Point location;

        private Paint(Painter painter, Point location) {
            this.painter = painter;
            this.location = location;
        }
    }
}
