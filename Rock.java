import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Rock implements MovingObject {


    public Rock(int x, int y, int diameter) {
        this.x = x;
        this.y = y;
        this.diameter = diameter;
    }

    @Override
    public void draw(Graphics2D g2D) {
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, diameter, diameter);
        g2D.fill(circle);
    }

    @Override
    public void translate(int xChange, int yChange) {
        x += xChange;
        y += yChange;
    }

    private int x, y, diameter;
}
