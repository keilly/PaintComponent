import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created with IntelliJ IDEA.
 * User: keilly
 * Date: 14/09/2013
 * Time: 10:55 AM
 * To change this template use File | Settings | File Templates.
 */
public class ShapeApp
{
  public static void main(String[] args){

    int w = 400;
    int h = 400;

    ShapeComponent shapeComponent = new ShapeComponent();
    shapeComponent.addPaintedShape(new ShapeComponent.SimplePaintedShape(new Ellipse2D.Double(w/2 - , 0, 100, 100), new Color(255, 0, 0, 100)));
    shapeComponent.addPaintedShape(new ShapeComponent.SimplePaintedShape(new Ellipse2D.Double(0, 0, 100, 100), new Color(0, 255, 0, 100)));
    shapeComponent.addPaintedShape(new ShapeComponent.SimplePaintedShape(new Ellipse2D.Double(0, 0, 100, 100), new Color(0, 0, 255, 100)));
    shapeComponent.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    shapeComponent.setBackground(Color.WHITE);
    shapeComponent.setOpaque(true);

    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(w, h);
    f.setLocationRelativeTo(null);
    f.setLayout(new FlowLayout());
    f.add(shapeComponent);
    f.setVisible(true);
  }
}
