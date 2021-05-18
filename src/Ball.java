import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball extends Ellipse2D.Double {

    private static final int SIZE = Paddle.HEIGHT;
    private static final int START_X = Breakout.WIDTH / 2;
    private static final int START_Y = Breakout.HEIGHT / 2 + SIZE;

    private Color color;
    private double[] speed;

    public Ball() {
        super(START_X, START_Y, Paddle.HEIGHT, Paddle.HEIGHT);
        color = Color.WHITE;
        String speedString = JOptionPane.showInputDialog("What speed?");
        double speed = 1.5; // default
        if (speedString!= null && speedString.length()>0) {
            speed = java.lang.Double.parseDouble(speedString);
        }
        this.speed = new double[]{Math.random() < 0.5 ? -speed : speed, speed};
    }

    public void drawBall(Graphics2D g2) {
        g2.setPaint(color);
        g2.fill(this);
        g2.setPaint(Color.BLACK);
        g2.draw(this);
    }

    public void update() {
        x += speed[0];
        y += speed[1];
    }

    public void flipVerticalSpeed() {
        speed[1] *= -1;
    }

    public void flipHorizontalSpeed() {
        speed[0] *= -1;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color c) {
        color = c;
    }

    public double[] getSpeed() {
        return speed;
    }

    /**
     * Where will the ball be when updated?  If new position would cause a collision, bounce!
     *
     * @return a rectangle located where this would be on next update
     */
    public Rectangle2D.Double project() {
        return new Rectangle2D.Double(x + speed[0], y + speed[1], width, height);
    }
}