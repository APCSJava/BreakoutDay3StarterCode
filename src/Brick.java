import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Brick extends Rectangle2D.Double {

    private Color color;

    public Brick(double x, double y, double w, double h) {
        super(x, y, w, h);
        color = new Color(0, 255, 0, 128);
    }

    public void drawBrick(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(this);
    }
}
