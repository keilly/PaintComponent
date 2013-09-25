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
  public Rectangle getBounds(PaintComponent paintComponent)
  {
    return shape.getBounds();
  }

  @Override
  public void paint(PaintComponent paintComponent, Graphics2D g2)
  {
    g2.setColor(color);
    g2.fill(shape);
  }
}
