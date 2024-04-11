/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class RemoveFlightController implements Initializable {

    @FXML
    private Label RemoveFlightLabel;
    @FXML
    private TextField RemoveFlightFlightNameTextField;
    @FXML
    private Label RemoveFlightFlightNameLabel;
    @FXML
    private Label RemoveFlightFlightSourceLabel;
    @FXML
    private Label RemoveFlightFlightDestinationLabel;
    @FXML
    private TextField RemoveFlightFlightSourceTextField;
    @FXML
    private TextField RemoveFlightFlightDestinationTextField;
    @FXML
    private TextField RemoveFlightFlightDateOfJourneyTextField;
    @FXML
    private Label RemoveFlightFlightCapacityLabel;
    @FXML
    private Label RemoveFlightFlightDateOfJourneyLabel;
    @FXML
    private Button RemoveFlightRemoveFlightButton;
    @FXML
    private Button RemoveFlightCloseButton;
    @FXML
    private ComboBox<String> RemoveFlightComboBox;
    @FXML
    private TextField RemoveFlightFlightCapacityTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData(); //gets initliazed when the remove flight button is clicked on home page
    }    

    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)RemoveFlightCloseButton.getScene().getWindow();
        stage1.close();
    }

    @FXML
    private void removeFlight(ActionEvent event) {
        String fcode=RemoveFlightComboBox.getValue();
        try{
            Conn c=new Conn();
            String str="delete from flight where FLIGHT_CODE='"+fcode+"'";
            int a=c.s.executeUpdate(str);
            if(a==1){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Flight Has Been Removed Successfully");
                alert.showAndWait();
                Stage stage1=(Stage)RemoveFlightCloseButton.getScene().getWindow();
                stage1.close();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Flight Has Not Been Removed");
                alert.showAndWait();                       
            }           
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    private void loadData(){
        try{
            Conn c=new Conn();
            String str="select FLIGHT_CODE from flight";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String flightcode=rs.getString("FLIGHT_CODE");
                RemoveFlightComboBox.getItems().addAll(flightcode);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDetails(ActionEvent event) {//gets executed whenever an option of the combobox is selected
        String fcode=RemoveFlightComboBox.getValue();
        try{
            Conn c=new Conn();
            String str="select * from flight where FLIGHT_CODE='"+fcode+"'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String flightname=rs.getString("FLIGHT_NAME");
                String flightsource=rs.getString("SOURCE");
                String flightdestination=rs.getString("DESTINATION");
                String flightcapacity=rs.getString("CAPACITY");
                String flightdateofjourney=rs.getString("DATE_OF_JOURNEY");
                RemoveFlightFlightNameTextField.setText(flightname);
                RemoveFlightFlightSourceTextField.setText(flightsource);
                RemoveFlightFlightDestinationTextField.setText(flightdestination);
                RemoveFlightFlightCapacityTextField.setText(flightcapacity);
                RemoveFlightFlightDateOfJourneyTextField.setText(flightdateofjourney);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
