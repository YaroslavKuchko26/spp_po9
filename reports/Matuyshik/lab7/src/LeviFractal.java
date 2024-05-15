import java.awt.*;
import javax.swing.*;

public class LeviFractal extends JPanel {
    private int level;
    private Point startPoint;
    private int length;

    public LeviFractal(int level, Point startPoint, int length) {
        this.level = level;
        this.startPoint = startPoint;
        this.length = length;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLeviFractal(g, level, startPoint, length);
    }

    private void drawLeviFractal(Graphics g, int level, Point startPoint, int length) {
        if (level == 0) {
            // Рисуем отрезок
            int endX = startPoint.x + length;
            int endY = startPoint.y;
            g.drawLine(startPoint.x, startPoint.y, endX, endY);
        } else {
            // Находим координаты точки для нового отрезка
            int newX = startPoint.x + length / 4;
            int newY = startPoint.y - length / 4;

            // Рисуем новые отрезки
            drawLeviFractal(g, level - 1, startPoint, length / 3);
            drawLeviFractal(g, level - 1, new Point(newX, newY), length / 3);
            drawLeviFractal(g, level - 1, new Point(newX + length / 3, newY - length / 3), length / 3);
            drawLeviFractal(g, level - 1, new Point(newX + 2 * length / 3, newY + length / 3), length / 3);
            drawLeviFractal(g, level - 1, new Point(newX + length, newY), length / 3);
        }
    }

    public static void main(String[] args) {
        // Ввод параметров
        int level = Integer.parseInt(JOptionPane.showInputDialog("Введите уровень фрактала:"));
        int startX = Integer.parseInt(JOptionPane.showInputDialog("Введите начальную координату X:"));
        int startY = Integer.parseInt(JOptionPane.showInputDialog("Введите начальную координату Y:"));
        int length = Integer.parseInt(JOptionPane.showInputDialog("Введите длину отрезка:"));

        // Создание окна для отображения фрактала
        JFrame frame = new JFrame("Levi Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Добавление панели для отображения фрактала
        LeviFractal fractalPanel = new LeviFractal(level, new Point(startX, startY), length);
        frame.add(fractalPanel);

        // Отображение окна
        frame.setVisible(true);
    }
}
