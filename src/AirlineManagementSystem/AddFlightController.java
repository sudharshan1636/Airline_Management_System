/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class AddFlightController implements Initializable {

    @FXML
    private Label AddFlightLabel;
    @FXML
    private TextField AddFlightFlightCodeTextField;
    @FXML
    private TextField AddFlightFlightNameTextField;
    @FXML
    private TextField AddFlightFlightSourceTextField;
    @FXML
    private TextField AddFlightFlightDestinationTextField;
    @FXML
    private TextField AddFlightFlightCapacityTextField;
    @FXML
    private Button AddFlightClearAllButton;
    @FXML
    private Button AddFlightAddFlightButton;
    @FXML
    private Button AddFlightCloseButton;
    @FXML
    private DatePicker AddFlightFlightDateOfJourneyDatePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        AddFlightFlightDateOfJourneyDatePicker.setValue(LocalDate.now());
    }    

    @FXML
    private void clearAll(ActionEvent event) {
        AddFlightFlightCodeTextField.setText("");
        AddFlightFlightNameTextField.setText("");
        AddFlightFlightSourceTextField.setText("");
        AddFlightFlightDestinationTextField.setText("");
        AddFlightFlightCapacityTextField.setText("");
        AddFlightFlightDateOfJourneyDatePicker.setValue(LocalDate.now());
    }

    @FXML
    private void addFlight(ActionEvent event) {
        String f_code=AddFlightFlightCodeTextField.getText();
        String f_name=AddFlightFlightNameTextField.getText();
        String f_source=AddFlightFlightSourceTextField.getText();
        String f_destination=AddFlightFlightDestinationTextField.getText();
        String f_capacity=AddFlightFlightCapacityTextField.getText();
        String f_dateofjourney=(AddFlightFlightDateOfJourneyDatePicker.getValue()).toString();
        if(f_code.isEmpty() || f_name.isEmpty() || f_source.isEmpty() || f_destination.isEmpty() || f_capacity.isEmpty() || f_dateofjourney.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Do Not Leave Any Field Empty");
            alert.showAndWait();
            return;
        }
        else{
            try{
                Conn c=new Conn();
                String str="insert into flight values( '"+f_code+"', '"+f_name+"', '"+f_source+"', '"+f_destination+"', '"+f_capacity+"', '"+f_dateofjourney+"')";
                int a=c.s.executeUpdate(str);
                if(a==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Has Been Added Successfully");
                    alert.showAndWait();
                    Stage stage1=(Stage)AddFlightCloseButton.getScene().getWindow();
                    stage1.close();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Has Not Been Added");
                    alert.showAndWait();
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)AddFlightCloseButton.getScene().getWindow();
        stage1.close();
    }
    
}
