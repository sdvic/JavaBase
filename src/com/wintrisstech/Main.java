package com.wintrisstech;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;

    public class Main extends Application
    {
        Circle circle;
        Group group;
        StackPane stack = new StackPane();
        Text text;

        public static void main(String[] args) throws Exception
        {
            launch(args);
        }

        @Override
        public void start(final Stage stage) throws Exception {
            for (int i = 0; i < 6; i++)
            {
                 circle = createCircle(i);
                 group = new Group(createCircle(i));
                 text = new Text(i + "");
            }
            text.setBoundsType(TextBoundsType.VISUAL);
            stack.getChildren().addAll(group, text);
            stage.setScene(new Scene(stack));
            stage.show();
        }

        private Circle createCircle(int i) {
            final Circle circle = new Circle(30);
            circle.setStroke(Color.FORESTGREEN);
            circle.setStrokeWidth(5);
            circle.setStrokeType(StrokeType.INSIDE);
            circle.setFill(Color.AZURE);
            circle.relocate(i * 10, 0);
            return circle;
        }
    }
