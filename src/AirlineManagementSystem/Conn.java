/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AirlineManagementSystem;

import java.sql.*;
/**
 *
 * @author patil
 */
public class Conn {
    Connection c;
    Statement s;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/airline_management_system","root","");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
