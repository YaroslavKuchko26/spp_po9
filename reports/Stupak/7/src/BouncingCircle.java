import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouncingCircle extends JPanel implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int CIRCLE_RADIUS = 50;
    private static final int CIRCLE_SPEED = 5;

    private int circleX;
    private int circleY;
    private int circleVelocityX;
    private int circleVelocityY;

    public BouncingCircle() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        circleX = WIDTH / 2;
        circleY = HEIGHT / 2;
        circleVelocityX = CIRCLE_SPEED;
        circleVelocityY = CIRCLE_SPEED;

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillOval(circleX - CIRCLE_RADIUS, circleY - CIRCLE_RADIUS, CIRCLE_RADIUS * 2, CIRCLE_RADIUS * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circleX += circleVelocityX;
        circleY += circleVelocityY;

        if (circleX - CIRCLE_RADIUS < 0 || circleX + CIRCLE_RADIUS > WIDTH) {
            circleVelocityX = -circleVelocityX;
        }
        if (circleY - CIRCLE_RADIUS < 0 || circleY + CIRCLE_RADIUS > HEIGHT) {
            circleVelocityY = -circleVelocityY;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.add(new BouncingCircle());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}