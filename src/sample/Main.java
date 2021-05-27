package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
public static Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window=primaryStage;
        window.setTitle("Registration");
        window.setScene(new Scene(root, 700, 500));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
