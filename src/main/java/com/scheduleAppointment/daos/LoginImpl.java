package com.scheduleAppointment.daos;

import com.scheduleAppointment.entities.Login;
import com.scheduleAppointment.entities.Patient;
import com.scheduleAppointment.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginImpl implements LoginDAO {
    Connection con = null;

//    public LoginImpl(Login login) {
//        login.
//    }
    @Override
    public Connection login(Login login){
        try{
            con = SQLConnector.createConnection();
            String qry = "SELECT PatientPassword FROM Patient WHERE PatientID = ?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, login.getUsername());
//            ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            String x = "";
            while(rs.next()){
                x = rs.getString(1);
                System.out.println(x);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
    @Override
    public void createAccount(Patient patient){
        try{
            con = SQLConnector.createConnection();
            String sql = "INSERT INTO Patient (Name, Phone, Address) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setString(3, patient.getAddress());
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}

