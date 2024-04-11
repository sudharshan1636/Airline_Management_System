
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.sql.*;
import javafx.scene.control.TableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class AirlineHomeController implements Initializable {

    ObservableList<Flight> list = FXCollections.observableArrayList();
    @FXML
    private Button HomeAddFlightButton;
    @FXML
    private Button HomeRemoveFlightButton;
    @FXML
    private Button HomeBookTicketButton;
    @FXML
    private Button HomeCancelTicketButton;
    @FXML
    private Button HomeModifyFlightButton;
    @FXML
    private Button HomePaymentDetailsButton;
    @FXML
    private Button HomePassengerDetailsButton;
    @FXML
    private AnchorPane HomeTab1;
    @FXML
    private Label HomeTab1Label;
    @FXML
    private AnchorPane HomeTab2RootPane;
    @FXML
    private TableColumn<Flight, String> HomeTab2FlightCodeColumn;
    @FXML
    private TableColumn<Flight, String> HomeTab2NameColumn;
    @FXML
    private TableColumn<Flight, String> HomeTab2SourceColumn;
    @FXML
    private TableColumn<Flight, String> HomeTab2DestinationColumn;
    @FXML
    private TableColumn<Flight, String> HomeTab2DateOfJourneyColumn;
    @FXML
    private TableColumn<Flight, String> HomeTab2CapacityColumn;
    @FXML
    private Tab HomeTab1Welcome;
    @FXML
    private ImageView HomeTab1Image;
    @FXML
    private Tab HomeTab2ShowFlightDetails;
    @FXML
    private TableView<Flight> HomeTab2Table;
    @FXML
    private StackPane rootPane;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showFlightDetails(Event event) {
        initCol();
        loadData();
        
    }
    private void initCol(){
        HomeTab2FlightCodeColumn.setCellValueFactory(new PropertyValueFactory<>("fcode"));
        HomeTab2NameColumn.setCellValueFactory(new PropertyValueFactory<>("fname"));
        HomeTab2SourceColumn.setCellValueFactory(new PropertyValueFactory<>("fsource"));
        HomeTab2DestinationColumn.setCellValueFactory(new PropertyValueFactory<>("fdestination"));
        HomeTab2CapacityColumn.setCellValueFactory(new PropertyValueFactory<>("fcapacity"));
        HomeTab2DateOfJourneyColumn.setCellValueFactory(new PropertyValueFactory<>("fdateofjourney"));

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
        HomeTab2Table.setItems(list);
    }

    @FXML
    private void addFlight(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("AddFlight.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Add Flight Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void removeFlight(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("RemoveFlight.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Remove Flight Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifyFlight(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("ModifyFlight.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Modify Flight Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void bookTicket(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("BookTicket.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Book Flight Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void cancelTicket(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("CancelTicket.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Cancel Ticket Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void passengerDetails(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("PassengerDetails.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Passenger Details Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void paymentDetails(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("PaymentDetails.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Payment Details Page");
        stage.setScene(scene);
        stage.show();
    
    }

    @FXML
    private void menuClose(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void menuRemoveFlight(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("RemoveFlight.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Remove Flight Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuCancelTicket(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("CancelTicket.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Cancel Ticket Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuPassengerDetails(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("PassengerDetails.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Passenger Details Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuPaymentDetails(ActionEvent event) throws Exception{
        Parent root=FXMLLoader.load(getClass().getResource("PaymentDetails.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Payment Details Page");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void menuModifyFlight(ActionEvent event) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("ModifyFlight.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setTitle("Payment Details Page");
        stage.setScene(scene);
        stage.show();
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




