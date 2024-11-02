package main;
// package main;
import java.io.IOException;

import javafx.application.Application;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Button;
import javafx.scene.image.Image;
// import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class App extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/resources/fxml/MainUI.fxml"));
            Scene scene = new Scene(root);

            primaryStage.setTitle("Aircraft Collision Detection System");
            Image icon = new Image("resources/images/plane.png");
            primaryStage.getIcons().add(icon);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}


