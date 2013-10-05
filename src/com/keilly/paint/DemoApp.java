package com.keilly.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Runnable class to demonstrate the ShapeComponent.
 */
public class DemoApp
{
  public static void main(String[] args){

    int w = 400;
    int h = 400;

    JPainted circleComponent = new JPainted();

    Shape circle = new Ellipse2D.Double(0, 0, 100, 100);
    ShapePainter redCircle = new ShapePainter(circle, new Color(255, 0, 0, 150));
    ShapePainter greenCircle = new ShapePainter(circle, new Color(0, 255, 0, 150));
    ShapePainter blueCircle = new ShapePainter(circle, new Color(0, 0, 255, 150));

    circleComponent.addPaint(redCircle, new Point(33, 0));
    circleComponent.addPaint(greenCircle, new Point(0, 33));
    circleComponent.addPaint(blueCircle, new Point(66, 33));

    circleComponent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));

    JPainted textComponent = new JPainted();
    Shape backgroundShape = new RoundRectangle2D.Double(0, 0, 100, 30, 10, 10);
    textComponent.addPaint(
            new ShapePainter(backgroundShape, new Color(255, 0, 200, 150)),
            new Point(4, 4));
    textComponent.addPaint(
            new EdgePainter(backgroundShape, new Color(200, 0, 150), 
                new BasicStroke(8f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[]{10f}, 0f)),
            new Point(4, 4));
    textComponent.addPaint(
            new TextPainter("Hello", 
                            new Font(Font.MONOSPACED, Font.BOLD, 15), 
                            Color.BLACK), 
            new Point(30, 13));

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    f.setSize(w, h);
    f.setLocationRelativeTo(null);
    f.setLayout(new FlowLayout());
    f.add(circleComponent);
    f.add(textComponent);
    f.setVisible(true);
  }
}
