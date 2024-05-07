package Task1;

import com.sun.javafx.scene.layout.region.Margins;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class RotatingTriangle extends Application {
    private static final ArrayList<Double> triangleSides = new ArrayList<>(List.of(300., 200., 150.));
    private static List<Double> triangleVertexPositions;
    ObservableList<Double> trianglePoints;
    Polygon triangle;
    private static double windowWidth, windowHeight;
    private static Point rotationCenter = new Point();
    double maxDistToVertex;

    @Override
    public void init() throws Exception {
        //validate triangle sides
        if (triangleSides.size() != 3)
            throw new IllegalArgumentException("Provided not 3 triangle sides");
        for (int i = 0; i < triangleSides.size(); i++){
            if (triangleSides.get(i) >= triangleSides.get((i+1)%3) + triangleSides.get((i+2)%3)){
                throw new IllegalArgumentException("Wrong triangle sides");
            }
        }

        //convert triangle sides to vertex positions
        double a = triangleSides.get(0);
        double b = triangleSides.get(1);
        double c = triangleSides.get(2);

        //A coords
        double x1 = 0.0;
        double y1 = 0.0;

        //B coords
        double x2 = c;
        double y2 = 0.0;

        //C coords
        double cosCAB =  (b * b + c * c - a * a) / (2 * b * c);
        double x3 = b * cosCAB;
        double y3 = Math.sqrt(b * b - x3 * x3);

        triangleVertexPositions = List.of(x1,y1,x2,y2,x3,y3);

        //Find center of mass coord
        rotationCenter.setX(Math.abs((x1 + x2 + x3) / 3));
        rotationCenter.setY(Math.abs((y1 + y2 + y3) / 3));

        maxDistToVertex = 0;
        for (int i = 0; i < 3; i++) {
            maxDistToVertex = Math.max(maxDistToVertex,
                    Math.sqrt(
                            Math.pow(rotationCenter.getX() - triangleVertexPositions.get(i * 2), 2)
                            + Math.pow(rotationCenter.getY() - triangleVertexPositions.get(i * 2 + 1), 2)
                    )
            );
        }
        windowHeight = windowWidth = maxDistToVertex * 2;

        super.init();
    }

    @Override
    public void start(Stage primaryStage) {
        // Создаем треугольник
        triangle = new Polygon();
        triangle.getPoints().addAll(triangleVertexPositions);
        trianglePoints = triangle.getPoints();
        triangle.setFill(Color.RED);

        triangle.setLayoutY(maxDistToVertex - rotationCenter.getY());
        triangle.setLayoutX(maxDistToVertex - rotationCenter.getX());

        // Создаем группу и добавляем треугольник в нее
        Group root = new Group(triangle);

        // Создаем сцену
        Scene scene = new Scene(root, windowWidth, windowHeight);

        // Устанавливаем сцену и отображаем окно
        primaryStage.setScene(scene);
        primaryStage.show();

        // Устанавливаем таймер для вращения треугольника
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                rotateTriangle();
            }
        }, 0, 10);
    }

    private void rotateTriangle() {
        for (int i = 0; i < trianglePoints.size(); i += 2) {
            Point trianglePoint = new Point(trianglePoints.get(i), trianglePoints.get(i+1));
            trianglePoint.rotateAroundPoint(rotationCenter,  0.01);
            trianglePoints.set(i, trianglePoint.getX());
            trianglePoints.set(i+1, trianglePoint.getY());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}