import javax.swing.*;
import java.awt.*;

public class Breakout extends JFrame {

    public static final int HEIGHT = 600;
    public static final int WIDTH = 800;

    public Breakout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setTitle("My Breakout Game on Swing");

        // center the window on the viewing screen
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((int) screenDim.getWidth() / 2 - WIDTH / 2, (int) screenDim.getHeight() / 2 - HEIGHT / 2);

        // create a panel component and add it to the window
        this.add(new BreakoutPanel());
    }


    public static void main(String[] args) {
        Breakout game = new Breakout();
        game.setVisible(true);
        System.out.println("Ready to go!");
    }

}
