package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingBallApplet extends JApplet implements ActionListener {

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 50;

    private Timer timer;

    private int ballRadius;
    private int direction;

    @Override
    public void init() {
        ballRadius = BALL_SIZE;
        direction = 1;


        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ballRadius += direction;

        if (ballRadius == 200 || ballRadius == BALL_SIZE) {
            direction *= -1;
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;

        int x = centerX - ballRadius / 2;
        int y = centerY - ballRadius / 2;

        g2d.setColor(Color.WHITE);
        g2d.fillOval(x - 1, y - 1, ballRadius + 2, ballRadius + 2);
        g2d.setColor(Color.RED);
        g2d.fillOval(x, y, ballRadius, ballRadius);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Moving Ball Applet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JApplet applet = new MovingBallApplet();
        applet.init();

        frame.add(applet);
        frame.setSize(WIDTH, HEIGHT);
        frame.setVisible(true);
    }
}