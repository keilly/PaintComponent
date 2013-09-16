package com.keilly.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Runnable class to demonstrate the ShapeComponent.
 */
public class TestApp
{
  public static void main(String[] args){

    int w = 400;
    int h = 400;

    ShapeComponent shapeComponent = new ShapeComponent();
    shapeComponent.addPaintedShape(new ColorPaintedShape(new Ellipse2D.Double(33, 0, 100, 100), new Color(255, 0, 0, 100)));
    shapeComponent.addPaintedShape(new ColorPaintedShape(new Ellipse2D.Double(0, 33, 100, 100), new Color(0, 255, 0, 100)));
    shapeComponent.addPaintedShape(new ColorPaintedShape(new Ellipse2D.Double(66, 33, 100, 100), new Color(0, 0, 255, 100)));
    shapeComponent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    shapeComponent.setBackground(Color.WHITE);
    shapeComponent.setOpaque(true);

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(w, h);
    f.setLocationRelativeTo(null);
    f.setLayout(new FlowLayout());
    f.add(shapeComponent);
    f.setVisible(true);
  }
}
