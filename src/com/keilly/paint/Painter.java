package com.keilly.paint;

import java.awt.*;

/**
 * Class to render into the graphics of a PaintComponent.
 * <p>
 * Painters supply the visible rendered graphics of a PaintComponent. They take turns painting into a PaintComponent,
 * one on top of the other, until all painters have completed rendering.
 * <p>
 * Painters can be shared between PaintComponents.
 */
public interface Painter
{
  /**
   * Return the size that the painter requires to render into the
   * given component.
   * <p>
   * The painted will calculate its preferred size from the union of its painters sizes and locations.
   * @return the size needed by the painter.
   */
  public Dimension getSize(JPainted painted);

  /**
   * Paint into the graphics of the given component
   * @param paintComponent the component requesting painting
   * @param g2 the graphics which to paint into.
   */
  public void paint(JPainted painted, Graphics2D g2);
}
