package org.example.pifagor;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PythagorasTreeFractal extends Application {

    private static final int WIDTH = 800; // Ширина окна
    private static final int HEIGHT = 600; // Высота окна

    private static final double INITIAL_ANGLE = Math.PI / 2; // Начальный угол
    private static final double INITIAL_LENGTH = 200; // Начальная длина
    private static final int MAX_DEPTH = 10; // Максимальная глубина рекурсии

    private TextField angleTextField;
    private TextField lengthTextField;
    private TextField depthTextField;
    private Canvas canvas;
    private GraphicsContext gc;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Pythagoras Tree Fractal");

        canvas = new Canvas(WIDTH, HEIGHT);
        gc = canvas.getGraphicsContext2D();
        drawPythagorasTree(INITIAL_ANGLE, INITIAL_LENGTH, MAX_DEPTH);

        angleTextField = new TextField(String.valueOf(INITIAL_ANGLE));
        lengthTextField = new TextField(String.valueOf(INITIAL_LENGTH));
        depthTextField = new TextField(String.valueOf(MAX_DEPTH));

        Button drawButton = new Button("Нарисовать");
        drawButton.setOnAction(e -> {
            double angle = Double.parseDouble(angleTextField.getText());
            double length = Double.parseDouble(lengthTextField.getText());
            int depth = Integer.parseInt(depthTextField.getText());
            drawPythagorasTree(angle, length, depth);
        });

        GridPane settingsPane = new GridPane();
        settingsPane.setHgap(10);
        settingsPane.setVgap(10);
        settingsPane.setPadding(new Insets(10));
        settingsPane.addRow(0, new Label("Угол:"), angleTextField);
        settingsPane.addRow(1, new Label("Длина:"), lengthTextField);
        settingsPane.addRow(2, new Label("Глубина:"), depthTextField);

        HBox controlBox = new HBox(10, drawButton);
        VBox root = new VBox(10, settingsPane, controlBox, canvas);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawPythagorasTree(double angle, double length, int depth) {
        gc.clearRect(0, 0, WIDTH, HEIGHT);
        drawPythagorasTree(gc, WIDTH / 2, HEIGHT, angle, length, 0, depth);
    }

    private void drawPythagorasTree(GraphicsContext gc, double x, double y, double angle, double length, int currentDepth, int maxDepth) {
        if (currentDepth > maxDepth) {
            return;
        }

        double x2 = x + Math.cos(angle) * length;
        double y2 = y - Math.sin(angle) * length;

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1.0);
        gc.strokeLine(x, y, x2, y2);

        double angle1 = angle - Math.PI / 4;
        double angle2 = angle + Math.PI / 4;
        double lengthRatio = 0.7; // Коэффициент уменьшения длины

        drawPythagorasTree(gc, x2, y2, angle1, length * lengthRatio, currentDepth + 1, maxDepth);
        drawPythagorasTree(gc, x2, y2, angle2, length * lengthRatio, currentDepth + 1, maxDepth);
    }

    public static void main(String[] args) {
        launch(args);
    }
}