package com.keilly.paint;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Component which renders itself by calling out to a series of painters. Each painter renders itself one
 * on top of another into the component.
 */
public class JPainted extends JComponent
{
  private List<Paint> paints = new ArrayList<>();

  public void addPaint(Painter painter, Point location) {
    paints.add(new Paint(painter, location));
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
    for(Paint paint : paints) {
      Graphics2D painterG = (Graphics2D)g2.create();
      painterG.translate(paint.location.x, paint.location.y);
      paint.painter.paint(this, painterG);
      painterG.translate(-paint.location.x, -paint.location.y);
      painterG.dispose();
    }
    g2.translate(-insets.left, -insets.top);
  }

  public Dimension getPreferredSize() {
    Dimension preferredSize = new Dimension(10, 10);
    for(Paint paint : paints) {
      Rectangle bounds = paint.painter.getBounds(this);
      preferredSize.width =  Math.max(preferredSize.width, paint.location.x + bounds.x + bounds.width + 1);
      preferredSize.height = Math.max(preferredSize.height, paint.location.y + bounds.y + bounds.height + 1);
    }

    Insets insets = getInsets();
    preferredSize.width += insets.left + insets.right;
    preferredSize.height += insets.top + insets.bottom;

    return preferredSize;
  }
  
  private class Paint {
      private final Painter painter;
      private final Point location;
      
      private Paint(Painter painter, Point location) {
          this.painter = painter;
          this.location = location;
      }
  }
}
