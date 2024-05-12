import java.awt.*;
import java.util.Scanner;
import javax.swing.*;

class Line {
    int x1, y1, x2, y2;

    public Line(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        g.drawLine(x1, y1, x2, y2);
    }

    public boolean intersects(Line other) {
        // Проверка на пересечение двух отрезков
        int s1_x, s1_y, s2_x, s2_y;
        s1_x = x2 - x1;
        s1_y = y2 - y1;
        s2_x = other.x2 - other.x1;
        s2_y = other.y2 - other.y1;

        double s, t;
        double denominator = (-s2_x * s1_y + s1_x * s2_y);

        if (denominator == 0) {
            // Линии параллельны или совпадают
            return false;
        }

        s = (-s1_y * (x1 - other.x1) + s1_x * (y1 - other.y1)) / denominator;
        t = (s2_x * (y1 - other.y1) - s2_y * (x1 - other.x1)) / denominator;

        return (s >= 0 && s <= 1 && t >= 0 && t <= 1);
    }
}

class DrawingPanel extends JPanel {
    Line[] lines;

    public DrawingPanel(Line[] lines) {
        this.lines = lines;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Line line : lines) {
            line.draw(g);
        }

        // Проверяем пересечения и рисуем пересекающиеся линии
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[i].intersects(lines[j])) {
                    g.setColor(Color.RED);
                    g.drawLine(lines[i].x1, lines[i].y1, lines[i].x2, lines[i].y2);
                    g.drawLine(lines[j].x1, lines[j].y1, lines[j].x2, lines[j].y2);
                }
            }
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        // Получаем количество линий от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество линий: ");
        int numLines = scanner.nextInt();

        // Создаем массив для хранения линий
        Line[] lines = new Line[numLines];

        // Получаем координаты точек для каждой линии
        for (int i = 0; i < numLines; i++) {
            System.out.println("Введите координаты точек для линии " + (i+1) + ":");
            System.out.print("Точка A (x1): ");
            int x1 = scanner.nextInt();
            System.out.print("Точка A (y1): ");
            int y1 = scanner.nextInt();
            System.out.print("Точка B (x2): ");
            int x2 = scanner.nextInt();
            System.out.print("Точка B (y2): ");
            int y2 = scanner.nextInt();
            lines[i] = new Line(x1, y1, x2, y2);
        }

        // Закрываем Scanner
        scanner.close();

        // Определяем, какие линии пересекаются или совпадают
        boolean intersectFound = false;
        for (int i = 0; i < lines.length; i++) {
            for (int j = i + 1; j < lines.length; j++) {
                if (lines[i].intersects(lines[j])) {
                    System.out.println("Линия " + (i+1) + " и линия " + (j+1) + " пересекаются.");
                    intersectFound = true;
                } else if (lines[i].x1 == lines[j].x1 && lines[i].y1 == lines[j].y1 &&
                        lines[i].x2 == lines[j].x2 && lines[i].y2 == lines[j].y2) {
                    System.out.println("Линия " + (i+1) + " и линия " + (j+1) + " совпадают.");
                    intersectFound = true;
                } else {
                    System.out.println("Линия " + (i+1) + " и линия " + (j+1) + " не пересекаются и не совпадают.");
                }
            }
        }

        if (!intersectFound) {
            System.out.println("Ни одна из линий не пересекается и не совпадает.");
        }

        // Создаем окно для отображения
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Добавляем панель для рисования
        DrawingPanel panel = new DrawingPanel(lines);
        frame.add(panel);

        // Отображаем окно
        frame.setVisible(true);
    }
}
