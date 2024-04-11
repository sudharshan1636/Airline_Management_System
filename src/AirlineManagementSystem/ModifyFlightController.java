/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class ModifyFlightController implements Initializable {

    @FXML
    private Label ModifyFlightLabel;
    @FXML
    private ComboBox<String> ModifyFlightComboBox;
    @FXML
    private Label ModifyFlightFlightNameLabel;
    @FXML
    private Label ModifyFlightFlightSourceLabel;
    @FXML
    private Label ModifyFlightFlightDestinationLabel;
    @FXML
    private TextField ModifyFlightFlightSourceTextField;
    @FXML
    private TextField ModifyFlightFlightDestinationTextField;
    @FXML
    private TextField ModifyFlightFlightCapacityTextField;
    @FXML
    private Label ModifyFlightFlightCapacityLabel;
    @FXML
    private Label ModifyFlightFlightDateOfJourneyLabel;
    @FXML
    private DatePicker ModifyFlightFlightDateOfJourneyDatePicker;
    @FXML
    private Button ModifyFlightModifyFlightButton;
    @FXML
    private Button ModifyFlightClearFieldsButton;
    @FXML
    private Button ModifyFlightCloseButton;
    @FXML
    private TextField ModifyFlightFlightNameTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void modifyFlight(ActionEvent event) {
        String f_name=ModifyFlightFlightNameTextField.getText();
        String f_source=ModifyFlightFlightSourceTextField.getText();
        String f_destination=ModifyFlightFlightDestinationTextField.getText();
        String f_capacity=ModifyFlightFlightCapacityTextField.getText();
        String f_dateofjourney=(ModifyFlightFlightDateOfJourneyDatePicker.getValue()).toString();
        if(f_name.isEmpty() || f_source.isEmpty() || f_destination.isEmpty() || f_capacity.isEmpty() || f_dateofjourney.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Do Not Leave Any Field Empty");
            alert.showAndWait();
            return;
        }
        else{
            try{
                Conn c=new Conn();
                String f_code=ModifyFlightComboBox.getValue();
                String str="update flight set FLIGHT_NAME='"+f_name+"', SOURCE='"+f_source+"', DESTINATION='"+f_destination+"', CAPACITY='"+f_capacity+"', DATE_OF_JOURNEY='"+f_dateofjourney+"' where FLIGHT_CODE='"+f_code+"'";
                int a=c.s.executeUpdate(str);
                if(a==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Has Been Modified Successfully");
                    alert.showAndWait();
                    Stage stage1=(Stage)ModifyFlightCloseButton.getScene().getWindow();
                    stage1.close();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Has Not Been Modified");
                    alert.showAndWait();
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @FXML
    private void clearFields(ActionEvent event) {
        ModifyFlightFlightNameTextField.setText("");
        ModifyFlightFlightSourceTextField.setText("");
        ModifyFlightFlightDestinationTextField.setText("");
        ModifyFlightFlightCapacityTextField.setText("");
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)ModifyFlightCloseButton.getScene().getWindow();
        stage1.close();
    }
    
    private void loadData(){
        try{
            Conn c=new Conn();
            String str="select FLIGHT_CODE from flight";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String flightcode=rs.getString("FLIGHT_CODE");
                ModifyFlightComboBox.getItems().addAll(flightcode);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void loadDetails(ActionEvent event) {
        String fcode=ModifyFlightComboBox.getValue();
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
                ModifyFlightFlightNameTextField.setText(flightname);
                ModifyFlightFlightSourceTextField.setText(flightsource);
                ModifyFlightFlightDestinationTextField.setText(flightdestination);
                ModifyFlightFlightCapacityTextField.setText(flightcapacity);
                String yyyy=flightdateofjourney.substring(0,4);
                String mm=flightdateofjourney.substring(5,7);
                String dd=flightdateofjourney.substring(8);
                int d=Integer.parseInt(dd);
                int m=Integer.parseInt(mm);
                int y=Integer.parseInt(yyyy);
                ModifyFlightFlightDateOfJourneyDatePicker.setValue(LocalDate.of(y,m,d));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
    
}
