import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Paddle extends Rectangle2D.Double {

    private Color color;
    public static final int WIDTH = 120;
    public static final int HEIGHT = 20;

    public Paddle(double x, double y, double w, double h) {
        super(x, y, w, h);
        color = new Color(208, 0, 255, 255);
    }

    public Paddle()  {
        this(Breakout.WIDTH/2 - Paddle.WIDTH/2, Breakout.HEIGHT-100, Paddle.WIDTH, Paddle.HEIGHT);
    }

    public void drawPaddle(Graphics2D g2d) {
        g2d.setColor(color);
        g2d.fill(this);
    }
}
