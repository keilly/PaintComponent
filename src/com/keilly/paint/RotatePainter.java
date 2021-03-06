/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keilly.paint;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;

/**
 * A Painter that will rotate another painter by the given amount.
 */
public class RotatePainter implements Painter {
    private final Painter painterToRotate;
    private final double rotation;
    private Rectangle bounds;
    
    public RotatePainter(Painter painterToRotate, double rotationDegrees) {
        this.painterToRotate = painterToRotate;
        this.rotation = Math.toRadians(rotationDegrees);
    }
    
    @Override
    public Dimension getSize(JPainted painted) {   
        if (bounds == null) {
            Dimension painterSize = painterToRotate.getSize(painted);
            Rectangle2D rect = new Rectangle2D.Double(0, 0, painterSize.width, painterSize.height);
            Path2D path = new Path2D.Double(rect);
            Shape rotated = path.createTransformedShape(AffineTransform.getRotateInstance(rotation));
          bounds = rotated.getBounds();
        }
        return bounds.getSize();
    }

    @Override
    public void paint(JPainted painted, Graphics2D g2) {
        g2.translate(-bounds.x, -bounds.y);
        g2.rotate(rotation);
        painterToRotate.paint(painted, g2);
    }
    
}
