package com.keilly.shape;

import java.awt.*;

/**
 * Class to render a shape in a ShapeComponent.
 */
public interface PaintedShape {
  public Shape getShape();
  public void paintShape(Graphics2D g2);
}
