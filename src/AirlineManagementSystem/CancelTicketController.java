/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class CancelTicketController implements Initializable {

    @FXML
    private Label CancelTicketLabel;
    @FXML
    private ComboBox<Integer> CancelTicketComboBox;
    @FXML
    private TextField CancelTicketPassengerNameTextField;
    @FXML
    private Label CancelTicketPassengerNameLabel;
    @FXML
    private Label CancelTicketPassengerPhoneLabel;
    @FXML
    private Label CancelTicketPassengerNationalityLabel;
    @FXML
    private TextField CancelTicketPassengerPhoneTextField;
    @FXML
    private TextField CancelTicketPassengerNationalityTextField;
    @FXML
    private TextField CancelTicketPassengerPassportTextField;
    @FXML
    private TextField CancelTicketPassengerFlightCodeTextField;
    @FXML
    private Label CancelTicketPassengerPassportLabel;
    @FXML
    private Label CancelTicketPassengerFlightCodeLabel;
    @FXML
    private Button CancelTicketCancelTicketButton;
    @FXML
    private Button CancelTicketCloseButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadData();
    }    

    @FXML
    private void loadDetails(ActionEvent event) {
        int ppnr=CancelTicketComboBox.getValue();
        try{
            Conn c=new Conn();
            String str="select * from passenger where PNR_NO='"+ppnr+"'";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String passengername=rs.getString("NAME");
                String passengerphone=rs.getString("PHONE_NO");
                String passengernationality=rs.getString("NATIONALITY");
                String passengerpassport=rs.getString("PASSPORT_NO");
                String passengerflightcode=rs.getString("FLIGHT_CODE");
                CancelTicketPassengerNameTextField.setText(passengername);
                CancelTicketPassengerPhoneTextField.setText(passengerphone);
                CancelTicketPassengerNationalityTextField.setText(passengernationality);
                CancelTicketPassengerPassportTextField.setText(passengerpassport);
                CancelTicketPassengerFlightCodeTextField.setText(passengerflightcode);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelTicket(ActionEvent event) {
        int ppnr=CancelTicketComboBox.getValue();
        try{
            Conn c=new Conn();
            String str1="delete from passenger where PNR_NO='"+ppnr+"'";
            int a1=c.s.executeUpdate(str1);
            String str2="delete from payment where PNR_NO='"+ppnr+"'";
            int a2=c.s.executeUpdate(str2);
            if(a1==1 && a2==1){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Ticket Has Been Cancelled Successfully. Amount Will Be Refunded Shortly");
                alert.showAndWait();
                Stage stage1=(Stage)CancelTicketCloseButton.getScene().getWindow();
                stage1.close();
            }
            else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Ticket Has Not Been Cancelled");
                alert.showAndWait();                       
            }           
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)CancelTicketCloseButton.getScene().getWindow();
        stage1.close();
    }
        
    private void loadData(){
        try{
            Conn c=new Conn();
            String str="select PNR_NO from passenger";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                int ppnr=rs.getInt("PNR_NO");
                CancelTicketComboBox.getItems().addAll(ppnr);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
