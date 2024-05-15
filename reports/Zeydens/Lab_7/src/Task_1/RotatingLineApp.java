package org.example.graphics;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingLineApp extends Application {

    private static final double LINE_LENGTH = 200;
    private static final double DURATION_SECONDS = 3;

    @Override
    public void start(Stage primaryStage) {
        TextField x1Field = new TextField();
        TextField y1Field = new TextField();
        TextField x2Field = new TextField();
        TextField y2Field = new TextField();
        TextField strokeWidthField = new TextField();

        Button startButton = new Button("Start");
        startButton.setOnAction(event -> {
            double x1 = Double.parseDouble(x1Field.getText());
            double y1 = Double.parseDouble(y1Field.getText());
            double x2 = Double.parseDouble(x2Field.getText());
            double y2 = Double.parseDouble(y2Field.getText());
            double strokeWidth = Double.parseDouble(strokeWidthField.getText());

            Line line = createLine(x1, y1, x2, y2, strokeWidth);
            RotateTransition rotateTransition = createRotationAnimation(line);

            Group root = new Group(line);
            Scene scene = new Scene(root, 400, 400);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Rotating Line");
            primaryStage.show();

            rotateTransition.play();
        });

        VBox vbox = new VBox(
                new Label("Enter line coordinates and stroke width:"),
                new Label("x1: "),
                x1Field,
                new Label("y1: "),
                y1Field,
                new Label("x2: "),
                x2Field,
                new Label("y2: "),
                y2Field,
                new Label("Stroke Width: "),
                strokeWidthField,
                startButton
        );
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rotating Line");
        primaryStage.show();
    }

    private Line createLine(double x1, double y1, double x2, double y2, double strokeWidth) {
        Line line = new Line(x1, y1, x2, y2);
        line.setStroke(Color.RED);
        line.setStrokeWidth(strokeWidth);
        return line;
    }

    private RotateTransition createRotationAnimation(Line line) {
        double centerX = line.getStartX();
        double centerY = line.getStartY();

        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(DURATION_SECONDS), line);
        rotateTransition.setByAngle(0);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.setAutoReverse(false);

        // Change line color during animation
        rotateTransition.currentTimeProperty().addListener((observable, oldValue, newValue) -> {
            double progress = newValue.toSeconds() / DURATION_SECONDS;
            if (progress <= 0.5) {
                line.setStroke(Color.RED.interpolate(Color.GREEN, progress * 2));
            } else {
                line.setStroke(Color.GREEN.interpolate(Color.RED, (progress - 0.5) * 2));
            }

            // Calculate the new coordinates for the line based on the rotation around the endpoint
            double angle = progress * 360;
            double newX = centerX + Math.cos(Math.toRadians(angle)) * LINE_LENGTH;
            double newY = centerY + Math.sin(Math.toRadians(angle)) * LINE_LENGTH;

            line.setEndX(newX);
            line.setEndY(newY);
        });

        return rotateTransition;
    }

    public static void main(String[] args) {
        launch(args);
    }
}