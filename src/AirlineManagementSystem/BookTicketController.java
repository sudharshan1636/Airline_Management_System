/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.*;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class BookTicketController implements Initializable {

    ObservableList<Flight> list=FXCollections.observableArrayList();
    @FXML
    private Label BookTicketLabel;
    @FXML
    private TableView<Flight> BookTicketTable;
    @FXML
    private TableColumn<Flight, String> BookTicketFlightCodeColumn;
    @FXML
    private TableColumn<Flight, String> BookTicketNameColumn;
    @FXML
    private TableColumn<Flight, String> BookTicketSourceColumn;
    @FXML
    private TableColumn<Flight, String> BookTicketDestinationColumn;
    @FXML
    private TableColumn<Flight, String> BookTicketCapacityColumn;
    @FXML
    private TableColumn<Flight, String> BookTicketDateOfJourneyColumn;
    @FXML
    private ComboBox<String> BookTicketComboBox;
    @FXML
    private Button BookTicketBookTicketButton;
    @FXML
    private Button BookTicketCloseButton;
    @FXML
    private TextField BookTicketNationalityTextField;
    @FXML
    private TextField BookTicketPhoneNoTextField;
    @FXML
    private TextField BookTicketPassportNoTextField;
    @FXML
    private TextField BookTicketCardNumberTextField;
    @FXML
    private TextField BookTicketNameTextField;
    @FXML
    private Label BookTicketPassengerDetailsLabel;
    @FXML
    private Label BookTicketPaymentDetailsLabel;
    @FXML
    private DatePicker BookTicketPaymentDateDatePicker;
    @FXML
    private TextField BookTicketAmountTextField;
    @FXML
    private Label BookTicketPaymentDateLabel;
    @FXML
    private Label BookTicketAmountLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
        loadData1();
    }    
    
    private void initCol(){
        BookTicketFlightCodeColumn.setCellValueFactory(new PropertyValueFactory<>("fcode"));
        BookTicketNameColumn.setCellValueFactory(new PropertyValueFactory<>("fname"));
        BookTicketSourceColumn.setCellValueFactory(new PropertyValueFactory<>("fsource"));
        BookTicketDestinationColumn.setCellValueFactory(new PropertyValueFactory<>("fdestination"));
        BookTicketCapacityColumn.setCellValueFactory(new PropertyValueFactory<>("fcapacity"));
        BookTicketDateOfJourneyColumn.setCellValueFactory(new PropertyValueFactory<>("fdateofjourney"));

    }
    
    private void loadData(){
        try{
            list.clear();
            Conn c=new Conn();
            String str="select * from flight";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String flightcode=rs.getString("FLIGHT_CODE");
                String flightname=rs.getString("FLIGHT_NAME");
                String flightsource=rs.getString("SOURCE");
                String flightdestination=rs.getString("DESTINATION");
                String flightcapacity=rs.getString("CAPACITY");
                String flightdateofjourney=rs.getString("DATE_OF_JOURNEY");
                list.add(new Flight(flightcode,flightname,flightsource,flightdestination,flightcapacity,flightdateofjourney));
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        BookTicketTable.setItems(list);
        BookTicketPaymentDateDatePicker.setValue(LocalDate.now());
        
    }
    
    private void loadData1(){
        try{
            Conn c=new Conn();
            String str="select FLIGHT_CODE from flight";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                String flightcode=rs.getString("FLIGHT_CODE");
                BookTicketComboBox.getItems().addAll(flightcode);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @FXML
    private void initAmount(ActionEvent event) {
       if(BookTicketComboBox.getValue().startsWith("AI")){
            BookTicketAmountTextField.setText("Rs. 10000");
        }
        else if(BookTicketComboBox.getValue().startsWith("IX")){
            BookTicketAmountTextField.setText("Rs. 9000");
        }
        else if(BookTicketComboBox.getValue().startsWith("IGO")){
            BookTicketAmountTextField.setText("Rs. 5000");
        }
        else{
            BookTicketAmountTextField.setText("Rs. 6000");
        } 
    }

    @FXML
    private void bookTicket(ActionEvent event) {
        String fcode=BookTicketComboBox.getValue();
        String pname=BookTicketNameTextField.getText();
        String pphone=BookTicketPhoneNoTextField.getText();
        String pnationality=BookTicketNationalityTextField.getText();
        String ppassport=BookTicketPassportNoTextField.getText();
        String pcard=BookTicketCardNumberTextField.getText();
        String ppaymentdate=BookTicketPaymentDateDatePicker.getValue().toString();
        String pamount=BookTicketAmountTextField.getText();
        if(fcode.isEmpty() || pname.isEmpty() || pphone.isEmpty() || pnationality.isEmpty() || ppassport.isEmpty() || pcard.isEmpty() || ppaymentdate.isEmpty() || pamount.isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please Do Not Leave Any Field Empty");
            alert.showAndWait();
            return;
        }
        else{
            try{
                Conn c=new Conn();
                String str1="insert into passenger(NAME,PHONE_NO,NATIONALITY,PASSPORT_NO,FLIGHT_CODE) values( '"+pname+"', '"+pphone+"', '"+pnationality+"', '"+ppassport+"', '"+fcode+"')";
                int a1=c.s.executeUpdate(str1);
                String str2="insert into payment(PHONE_NO,CARD_NO,AMOUNT_PAID,PAYMENT_DATE) values('"+pphone+"', '"+pcard+"', '"+pamount+"', '"+ppaymentdate+"')";
                int a2=c.s.executeUpdate(str2);
                if(a1==1 && a2==1){
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Ticket Has Been Booked Successfully");
                    alert.showAndWait();
                    Stage stage1=(Stage)BookTicketCloseButton.getScene().getWindow();
                    stage1.close();
                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Flight Ticket Has Not Been Booked");
                    alert.showAndWait();
                }
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)BookTicketCloseButton.getScene().getWindow();
        stage1.close();
    }
    
    public static class Flight{
        private final SimpleStringProperty fcode;
        private final SimpleStringProperty fname;
        private final SimpleStringProperty fsource;
        private final SimpleStringProperty fdestination;
        private final SimpleStringProperty fcapacity;
        private final SimpleStringProperty fdateofjourney;
        
        Flight(String fcode,String fname,String fsource,String fdestination,String fcapacity,String fdateofjourney){
            this.fcode=new SimpleStringProperty(fcode);
            this.fname=new SimpleStringProperty(fname);
            this.fsource=new SimpleStringProperty(fsource);
            this.fdestination=new SimpleStringProperty(fdestination);
            this.fcapacity=new SimpleStringProperty(fcapacity);
            this.fdateofjourney=new SimpleStringProperty(fdateofjourney);
        }

        public String getFcode() {
            return fcode.get();
        }

        public String getFname() {
            return fname.get();
        }

        public String getFsource() {
            return fsource.get();
        }

        public String getFdestination() {
            return fdestination.get();
        }

        public String getFcapacity() {
            return fcapacity.get();
        }

        public String getFdateofjourney() {
            return fdateofjourney.get();
        }
  
    }
}
