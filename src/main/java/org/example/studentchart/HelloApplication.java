package org.example.studentchart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application
{
    int height = 600;
    int width = 600;

    @Override
    public void start(Stage stage) throws IOException
    {
        UI ui = new UI();
        HelloController controller = new HelloController(ui);
        Parent root = ui.getView();
        Scene scene = new Scene(root, height, width);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
