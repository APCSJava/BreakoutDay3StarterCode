import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BreakoutPanel extends JPanel {

    private Image background = null;
    private ArrayList<Brick> bricks = new ArrayList<>();
    private Paddle paddle = new Paddle();
    private Ball ball = new Ball();

    public BreakoutPanel() {
        try {
            background = ImageIO.read(new File("res/cat.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bricks.add(new Brick(0, 0, 60, 20));
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    paddle.x -= 20;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    paddle.x += 20;
                }
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                paddle.x = e.getX() - Paddle.WIDTH/2;
                repaint();
            }
        });
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateGame();
                repaint();
            }
        });
        timer.start();
        this.setFocusable(true);
    }

    private void updateGame() {
        System.out.println("Update game elements now...");
        // game logic -- collisions, bounces, etc.
    }

    /**
     * Components receive a call to paintComponent when Java is good and ready. This JPanel is responsible for drawing
     * all game elements -- bricks, paddle, ball, background, text messages, etc. when it is called.  Similar to the
     * draw() loop in Processing.
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        drawBackground(g2d);
        showMessage("Hello, Breakout", g2d);
        for (Brick b : bricks) {
            b.drawBrick(g2d);
        }
        paddle.drawPaddle(g2d);
    }

    public void drawBackground(Graphics2D g2d) {
        if (background != null) g2d.drawImage(background, 0, 0, Breakout.WIDTH, Breakout.HEIGHT, null);
    }

    public void showMessage(String s, Graphics2D g2d) {
        Font font = new Font("SansSerif", Font.PLAIN, 40);
        Rectangle2D textBox = font.getStringBounds(s, g2d.getFontRenderContext());
        g2d.setFont(font);
        g2d.setColor(new Color(64, 64, 64, 128));
        g2d.drawString(s, (int) (Breakout.WIDTH / 2 - textBox.getWidth() / 2), 50);
    }
}
