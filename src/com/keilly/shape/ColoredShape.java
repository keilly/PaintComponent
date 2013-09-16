package com.keilly.shape;

import java.awt.*;

/**
* Render a shape in a specified color.
*/
public class ColoredShape implements PaintedShape {
  private final Shape shape;
  private final Color color;

  public ColoredShape(Shape shape, Color color) {
    this.shape = shape;
    this.color = color;
  }

  public Shape getShape() {
    return shape;
  }

  public void paintShape(Graphics2D g2) {
    g2.setColor(color);
    g2.fill(shape);
  }
}
