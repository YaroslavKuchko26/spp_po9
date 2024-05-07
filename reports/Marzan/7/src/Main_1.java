import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Random random = new Random();
        primaryStage.setTitle("Letter Animation");
        double width = 1000, height = 1000;
        Group root = new Group();
        Scene scene = new Scene(root, width, height, Color.WHITE);
        char[] letters = {'A', 'N', 'D', 'R', 'E', 'Y', ' ', 'M', 'A', 'R', 'Z', 'A', 'N'};
        int startX = 10;
        int startY = 30;
        for (char letterChar : letters) {
            Text letter = new Text(String.valueOf(letterChar));
            letter.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            letter.setFill(Color.BLACK);
            letter.setX(startX);
            letter.setY(startY);
            root.getChildren().add(letter);
            TranslateTransition transition = new TranslateTransition(Duration.seconds(2), letter);
            switch (random.nextInt(4)) {
                case 0:
                    transition.setFromX(-startX);
                    transition.setFromY(height - startY);
                    break;
                case 1:
                    transition.setFromX(width - startX);
                    transition.setFromY(-startY);
                    break;
                case 2:
                    transition.setFromX(width - startX);
                    transition.setFromY(height - startY);
                    break;
                default:
                    transition.setFromX(-startX);
                    transition.setFromY(-startY);
                    break;
            }
            transition.setToX(250);
            transition.setToY(250);
            transition.setCycleCount(TranslateTransition.INDEFINITE);
            transition.setAutoReverse(true);
            transition.play();
            startX += 40; // Увеличиваем горизонтальное смещение для следующей буквы
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}