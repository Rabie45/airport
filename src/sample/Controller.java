package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class Controller {


    @FXML
    private Button clientButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameField;

    @FXML
    private ImageView imge;

    @FXML
    private TextArea dataArea;

    @FXML
    private ChoiceBox<?> chooseBox;

    @FXML
    private TextField dateField;

    @FXML
    private TextField flightID;

    @FXML
    private TextField depatureField;

    @FXML
    private TextField arrivalField;

    @FXML
    private Button addFlight;
    @FXML
    private Button deleteFlight;
    @FXML
    private TextField deleteFlightText;

    private ImageView icons=new ImageView(new image());

    String user;
    String pass;
    EmlopyClass emp;

    public void setSubmitButton() throws SQLException, IOException {
        user = usernameField.getText();
        pass = passwordField.getText();
        emp = new EmlopyClass(user, pass);
        boolean state = emp.checkUser();
        System.out.println("user " + user + "password " + pass + " " + state);
        if (state == true) {
            employScene();
        }
//   emp=new EmlopyClass(user,pass);
//boolean checkUser=emp.checkUser();
    }

    public void employScene() throws IOException {
        Parent employScene = FXMLLoader.load(getClass().getResource("employScene.fxml"));
        Scene employ = new Scene(employScene);
        Main.window.setTitle("employee");
       Main.window.setScene(employ);
       Main.window.show();


    }
    public void clientScene() throws IOException {
        Parent employScene = FXMLLoader.load(getClass().getResource("clientScene.fxml"));
        Scene employ = new Scene(employScene);
        Main.window.setTitle("employee");
        Main.window.setScene(employ);
        Main.window.show();
    }
    public void addFlight() throws SQLException {
       String date=dateField.getText();
       int fligt=Integer.parseInt(flightID.getText());
       String depature=depatureField.getText();
       String arrival=arrivalField.getText();
       emp= new EmlopyClass(date,fligt,depature,arrival);
       emp.addFlight();

    }
    public void deleteFlight() throws SQLException {
        int flight=Integer.parseInt(deleteFlightText.getText());
        emp= new EmlopyClass(flight);
        emp.deleteFlight();
    }

}