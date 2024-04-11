/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class AirlineLoginController implements Initializable {

    @FXML
    private Button LoginLoginButton;
    @FXML
    private TextField LoginUsernameTextField;
    private TextField LoginPasswordTextField;
    @FXML
    private Label LoginStatusLabel;
    @FXML
    private Label LoginLoginLabel;
    @FXML
    private PasswordField LoginPasswordPasswordField;
    @FXML
    private Button LoginCloseButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void Login(ActionEvent event) throws Exception{
        if(LoginUsernameTextField.getText().equals("user") && LoginPasswordPasswordField.getText().equals("pass")){            
            LoginStatusLabel.setText("Login Sucess");
            Parent root=FXMLLoader.load(getClass().getResource("AirlineHome.fxml"));
            Stage stage=new Stage();
            Scene scene=new Scene(root);
            stage.setTitle("Airline Managament System");
            stage.setScene(scene);
            stage.show();  
            Stage stage1=(Stage)LoginLoginButton.getScene().getWindow();
            stage1.close();
        }
        else{
            LoginStatusLabel.setText("Login Failed");
        }
    }

    @FXML
    private void Close(ActionEvent event) {
        System.exit(0);
    }
    
}
