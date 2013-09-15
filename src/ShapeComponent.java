import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keilly
 * Date: 14/09/2013
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
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
    preferredSize.width += insets.left + insets.right + 1;
    preferredSize.height += insets.top + insets.bottom + 1;

    return preferredSize;
  }

  public interface PaintedShape {
    public Shape getShape();
    public void paintShape(Graphics2D g2);
  }

  public static class SimplePaintedShape implements PaintedShape {
    private final Shape shape;
    private final Color color;

    public SimplePaintedShape(Shape shape, Color color) {
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
}
