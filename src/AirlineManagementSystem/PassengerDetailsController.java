/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AirlineManagementSystem;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author patil
 */
public class PassengerDetailsController implements Initializable {

    ObservableList<Passenger> list=FXCollections.observableArrayList();
    @FXML
    private Label PassengerDetailsLabel;
    @FXML
    private TableView<Passenger> PassengerDetailsTable;
    @FXML
    private TableColumn<Passenger, Integer> PassengerDetailsPNRColumn;
    @FXML
    private TableColumn<Passenger, String> PassengerDetailsNameColumn;
    @FXML
    private TableColumn<Passenger, String> PassengerDetailsPhoneColumn;
    @FXML
    private TableColumn<Passenger, String> PassengerDetailsNationalityColumn;
    @FXML
    private TableColumn<Passenger, String> PassengerDetailsFlightCodeColumn;
    @FXML
    private Button PassengerDetailsCloseButton;
    @FXML
    private TableColumn<Passenger, String> PassengerDetailsPassportColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }    

    private void initCol(){
        PassengerDetailsPNRColumn.setCellValueFactory(new PropertyValueFactory<>("ppnr"));
        PassengerDetailsNameColumn.setCellValueFactory(new PropertyValueFactory<>("pname"));
        PassengerDetailsPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("pphone"));
        PassengerDetailsNationalityColumn.setCellValueFactory(new PropertyValueFactory<>("pnationality"));
        PassengerDetailsPassportColumn.setCellValueFactory(new PropertyValueFactory<>("ppassport"));
        PassengerDetailsFlightCodeColumn.setCellValueFactory(new PropertyValueFactory<>("pflightcode"));

    }
    
    private void loadData(){
        try{
            list.clear();
            Conn c=new Conn();
            String str="select * from passenger";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                int passengerpnr=rs.getInt("PNR_NO");
                String passengername=rs.getString("NAME");
                String passengerphone=rs.getString("PHONE_NO");
                String passengernationality=rs.getString("NATIONALITY");
                String passengerpassport=rs.getString("PASSPORT_NO");
                String passengerflightcode=rs.getString("FLIGHT_CODE");
                list.add(new Passenger(passengerpnr,passengername,passengerphone,passengernationality,passengerpassport,passengerflightcode));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        PassengerDetailsTable.setItems(list);
    }
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)PassengerDetailsCloseButton.getScene().getWindow();
        stage1.close();
    }
    
    public static class Passenger{
        private final SimpleIntegerProperty ppnr;
        private final SimpleStringProperty pname;
        private final SimpleStringProperty pphone;
        private final SimpleStringProperty pnationality;
        private final SimpleStringProperty ppassport;
        private final SimpleStringProperty pflightcode;

        private Passenger(Integer ppnr, String pname, String pphone, String pnationality, String ppassport, String pflightcode) {
            this.ppnr=new SimpleIntegerProperty(ppnr);
            this.pname=new SimpleStringProperty(pname);
            this.pphone=new SimpleStringProperty(pphone);
            this.pnationality=new SimpleStringProperty(pnationality);
            this.ppassport=new SimpleStringProperty(ppassport);
            this.pflightcode=new SimpleStringProperty(pflightcode);
        }

        public Integer getPpnr() {
            return ppnr.get();
        }

        public String getPname() {
            return pname.get();
        }

        public String getPphone() {
            return pphone.get();
        }

        public String getPnationality() {
            return pnationality.get();
        }

        public String getPpassport() {
            return ppassport.get();
        }

        public String getPflightcode() {
            return pflightcode.get();
        }
        
        
        
    }
    
}
