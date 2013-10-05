package com.keilly.paint;

import java.awt.*;

/**
 * Paint a paint in a specified color.
 */
public class ShapePainter implements Painter
{
  private final Shape shape;
  private final Color color;

  public ShapePainter(Shape shape, Color color) {
    this.shape = shape;
    this.color = color;
  }

  @Override 
  public Dimension getSize(JPainted painted)
  {
    return shape.getBounds().getSize();
  }  

  @Override
  public void paint(JPainted painted, Graphics2D g2)
  {
    g2.setColor(color);
    g2.fill(shape);
  }
}
