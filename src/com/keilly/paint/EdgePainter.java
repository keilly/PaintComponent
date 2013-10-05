/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.keilly.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;

/**
 * Paint the boundary of a given shape with a certain stroke and color.
 */
public class EdgePainter implements Painter {
  private static final BasicStroke DEFAULT_STROKE = 
          new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
          
  private final Shape shape;
  private final Color color;
  private final BasicStroke stroke;

  public EdgePainter(Shape shape, Color color, BasicStroke stroke) {
    this.shape = shape;
    this.color = color;
    this.stroke = stroke != null ? stroke : DEFAULT_STROKE;
  }

  @Override
  public Rectangle getBounds(PaintComponent paintComponent)
  {
    Rectangle bounds = shape.getBounds();
    bounds.width += stroke.getLineWidth();
    bounds.height += stroke.getLineWidth();
    return bounds;
  }

  @Override
  public void paint(PaintComponent paintComponent, Graphics2D g2)
  {
    g2.setColor(color);
    g2.setStroke(stroke);
    g2.draw(shape);
  }
}
