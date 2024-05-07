package Task2;

import com.sun.javafx.scene.layout.region.Margins;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.w3c.dom.css.Rect;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SierpinskiCarpet extends Application {
    private static double windowSize = 729;
    private static int depth = 5;
    private static Group root;
    private static List<Color> colors = new ArrayList<>(
            List.of(
                    Color.RED, Color.AQUAMARINE, Color.ALICEBLUE, Color.ANTIQUEWHITE,
                    Color.BISQUE, Color.AZURE, Color.WHEAT, Color.CORNFLOWERBLUE,
                    Color.TAN, Color.SLATEGREY, Color.TOMATO, Color.SILVER,
                    Color.VIOLET, Color.PINK, Color.SALMON, Color.OLIVE
            )
    );

    @Override
    public void start(Stage primaryStage) {
        // Создаем группу и добавляем треугольник в нее
        root = new Group();

        drawRectangles(depth, windowSize / 2, windowSize / 2);

        // Создаем сцену
        Scene scene = new Scene(root, windowSize, windowSize);

        // Устанавливаем сцену и отображаем окно
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void drawRectangles(int curDepth, double x, double y){
        if (curDepth > 0){
            int rectSize = (int) (windowSize / Math.pow(3, depth - curDepth + 1));
            Rectangle rect = new Rectangle(x - rectSize / 2, y - rectSize / 2, rectSize, rectSize);
            rect.setFill(colors.get((int) (Math.random() * colors.size())));
            root.getChildren().add(rect);
            curDepth--;
            drawRectangles(curDepth, x + rectSize, y + rectSize);
            drawRectangles(curDepth, x - rectSize, y + rectSize);
            drawRectangles(curDepth, x + rectSize, y - rectSize);
            drawRectangles(curDepth, x - rectSize, y - rectSize);
            drawRectangles(curDepth, x + rectSize, y);
            drawRectangles(curDepth, x - rectSize, y);
            drawRectangles(curDepth, x, y + rectSize);
            drawRectangles(curDepth, x, y - rectSize);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}