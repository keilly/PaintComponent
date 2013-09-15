package com.keilly.shape;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Component to display arbitrary shapes.
 * <p>
 * Clients can add PaintedShapes to this component. The component will size to display all of the added shapes.
 * The shapes will be rendered from the first to last (later added shapes will render on top of earlier added shapes).
 */
public class ShapeComponent extends JComponent
{
  private List<PaintedShape> paintedShapes = new ArrayList<PaintedShape>();

  public void addPaintedShape(PaintedShape paintedShape) {
    paintedShapes.add(paintedShape);
    invalidate();
    repaint();
  }

  @Override
  protected void paintComponent(Graphics g)
  {
    super.paintComponent(g);

    Graphics2D g2 = (Graphics2D)g;
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    Insets insets = getInsets();
    g2.translate(insets.left, insets.top);
    for(PaintedShape paintedShape : paintedShapes) {
      paintedShape.paintShape(g2);
    }
    g2.translate(-insets.left, -insets.top);
  }

  public Dimension getPreferredSize() {
    Dimension preferredSize = new Dimension(10, 10);
    for(PaintedShape ps : paintedShapes) {
      Rectangle bounds = ps.getShape().getBounds();
      preferredSize.width = Math.max(preferredSize.width, bounds.x + bounds.width);
      preferredSize.height = Math.max(preferredSize.height, bounds.y + bounds.height);
    }

    Insets insets = getInsets();
    preferredSize.width += insets.left + insets.right;
    preferredSize.height += insets.top + insets.bottom;

    return preferredSize;
  }


}
