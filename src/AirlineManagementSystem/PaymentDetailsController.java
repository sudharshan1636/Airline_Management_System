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
public class PaymentDetailsController implements Initializable {

    ObservableList<Payment> list= FXCollections.observableArrayList();
    @FXML
    private Label PaymentDetailsLabel;
    @FXML
    private TableView<Payment> PaymentDetailsTable;
    @FXML
    private TableColumn<Payment, Integer> PaymentDetailsPNRColumn;
    @FXML
    private TableColumn<Payment, String> PaymentDetailsPhoneColumn;
    @FXML
    private TableColumn<Payment, String> PaymentDetailsCardColumn;
    private TableColumn<Payment, String> PassengerDetailsNationalityColumn;
    @FXML
    private TableColumn<Payment, String> PaymentDetailsAmountColumn;
    @FXML
    private Button PaymentDetailsCloseButton;
    @FXML
    private TableColumn<Payment, String> PaymentDetailsPaymentDateColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initCol();
        loadData();
    }    

    private void initCol(){
        PaymentDetailsPNRColumn.setCellValueFactory(new PropertyValueFactory<>("ppnr"));
        PaymentDetailsPhoneColumn.setCellValueFactory(new PropertyValueFactory<>("pphone"));
        PaymentDetailsCardColumn.setCellValueFactory(new PropertyValueFactory<>("pcard"));
        PaymentDetailsAmountColumn.setCellValueFactory(new PropertyValueFactory<>("pamount"));
        PaymentDetailsPaymentDateColumn.setCellValueFactory(new PropertyValueFactory<>("ppaymentdate"));

    }
    
    private void loadData(){
        try{
            list.clear();
            Conn c=new Conn();
            String str="select * from payment";
            ResultSet rs=c.s.executeQuery(str);
            while(rs.next()){
                int passengerpnr=rs.getInt("PNR_NO");
                String passengerphone=rs.getString("PHONE_NO");
                String passengercard=rs.getString("CARD_NO");
                String passengeramount=rs.getString("AMOUNT_PAID");
                String passengerpaymentdate=rs.getString("PAYMENT_DATE");
                list.add(new Payment(passengerpnr,passengerphone,passengercard,passengeramount,passengerpaymentdate));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        PaymentDetailsTable.setItems(list);
    }
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage1=(Stage)PaymentDetailsCloseButton.getScene().getWindow();
        stage1.close();
    }
    
    public static class Payment{
        private final SimpleIntegerProperty ppnr;
        private final SimpleStringProperty pphone;
        private final SimpleStringProperty pcard;
        private final SimpleStringProperty pamount;
        private final SimpleStringProperty ppaymentdate;

        private Payment(Integer ppnr, String pphone, String pcard, String pamount, String ppaymentdate) {
            this.ppnr=new SimpleIntegerProperty(ppnr);
            this.pphone=new SimpleStringProperty(pphone);
            this.pcard=new SimpleStringProperty(pcard);
            this.pamount=new SimpleStringProperty(pamount);
            this.ppaymentdate=new SimpleStringProperty(ppaymentdate);
        }

        public Integer getPpnr() {
            return ppnr.get();
        }

        public String getPphone() {
            return pphone.get();
        }

        public String getPcard() {
            return pcard.get();
        }

        public String getPamount() {
            return pamount.get();
        }

        public String getPpaymentdate() {
            return ppaymentdate.get();
        }
                
    }
}
