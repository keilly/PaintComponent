package com.keilly.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Component which renders itself by calling out to a series of painters. Each painter renders itself one
 * on top of another into the component.
 */
public class PaintComponent extends JComponent
{
  private List<Painter> painters = new ArrayList<>();

  public void addPainter(Painter painter) {
    painters.add(painter);
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
    for(Painter painter : painters) {
      Graphics2D painterG = (Graphics2D)g2.create();
      painter.paint(this, painterG);
      painterG.dispose();
    }
    g2.translate(-insets.left, -insets.top);
  }

  public Dimension getPreferredSize() {
    Dimension preferredSize = new Dimension(10, 10);
    for(Painter ps : painters) {
      Rectangle bounds = ps.getBounds(this);
      preferredSize.width = Math.max(preferredSize.width, bounds.x + bounds.width);
      preferredSize.height = Math.max(preferredSize.height, bounds.y + bounds.height);
    }

    Insets insets = getInsets();
    preferredSize.width += insets.left + insets.right;
    preferredSize.height += insets.top + insets.bottom;

    return preferredSize;
  }
}
