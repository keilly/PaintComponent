/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keilly.paint;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

/**
 * A Painter that will rotate another painter by the given amount.
 */
public class RotatePainter implements Painter {
    private final Painter painterToRotate;
    private final double rotation;
    
    public RotatePainter(Painter painterToRotate, double rotationDegrees) {
        this.painterToRotate = painterToRotate;
        this.rotation = Math.toRadians(rotationDegrees);
    }
    
    @Override
    public Rectangle getBounds(JPainted paintComponent) {
        Path2D path = new Path2D.Double(painterToRotate.getBounds(paintComponent));
        Shape rotated = path.createTransformedShape(AffineTransform.getRotateInstance(rotation));
        return rotated.getBounds();
    }

    @Override
    public void paint(JPainted paintComponent, Graphics2D g2) {
        g2.rotate(rotation);
        painterToRotate.paint(paintComponent, g2);
        g2.rotate(-rotation);
    }
    
}
