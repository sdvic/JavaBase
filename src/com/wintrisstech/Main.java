package com.wintrisstech;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;

public class Main extends Application
{
    public static void main(String[] args)
    {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        int R = 18;
        Text text = new Text();
        text.setFont(new Font(10));
        text.setBoundsType(TextBoundsType.VISUAL);
        Circle circle[] = new Circle[16];
        Group group = new Group();
        StackPane stack = new StackPane();
        int i;
        //for (i = 0; i < circle.length; i++)
        {
            i = 0;
            double W = text.getBoundsInLocal().getWidth();
            double H = text.getBoundsInLocal().getHeight();
            text.relocate((R - W / 2), R - H / 2);
            circle[i] = new Circle(R);
            circle[i].setStroke(Color.FORESTGREEN);
            circle[i].setStrokeWidth(4);
            circle[i].setStrokeType(StrokeType.INSIDE);
            circle[i].setFill(Color.AZURE);
            circle[i].relocate(4 * R * i, 0);
            text.setText(i + "");
            circle[i].setId(i + "");
            group.getChildren().add(circle[i]);
        }
        stack.getChildren().addAll(group);
        stage.setTitle("Circle");
        stage.setScene(new Scene(stack));
        stage.show();
    }
}