package com.keilly.shape;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Runnable class to demonstrate the ShapeComponent.
 */
public class DemoApp
{
  public static void main(String[] args){

    int w = 400;
    int h = 400;

    ShapeComponent shapeC = new ShapeComponent();
    shapeC.addShape(new ColoredShape(new Ellipse2D.Double(33, 0, 100, 100), new Color(255, 0, 0, 150)));
    shapeC.addShape(new ColoredShape(new Ellipse2D.Double(66, 33, 100, 100), new Color(0, 0, 255, 150)));
    shapeC.addShape(new ColoredShape(new Ellipse2D.Double(0, 33, 100, 100), new Color(255, 255, 0, 150)));
    shapeC.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

    ShapeComponent sc2 = new ShapeComponent();
    sc2.addShape(new ColoredShape(new Ellipse2D.Double(33, 0, 100, 100), new Color(255, 0, 0)));
    sc2.addShape(new ColoredShape(new Ellipse2D.Double(0, 33, 100, 100), new Color(0, 255, 0)));
    sc2.addShape(new ColoredShape(new Ellipse2D.Double(66, 33, 100, 100), new Color(0, 0, 255)));
    sc2.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(w, h);
    f.setLocationRelativeTo(null);
    f.setLayout(new FlowLayout());
    f.add(shapeC);
    f.add(sc2);
    f.setVisible(true);
  }
}
