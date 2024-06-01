package com.scheduleAppointment.daos;

import com.scheduleAppointment.entities.Patient;
import com.scheduleAppointment.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatientImpl implements PatientDAO{
    private Map<Integer, Patient> patients = new HashMap<>();
    int pid = 0;

    Connection con = null;

    @Override
    public void addPatient(Patient patient){
        try{
            con = SQLConnector.createConnection();
            String sql = "INSERT INTO Patient (Name, Phone, Address, PatientUserName, PatientPassword) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setString(3, patient.getAddress());
            ps.setString(4, patient.getUserName());
            ps.setString(5, patient.getPassword());

            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        patient.setPatientID(pid++);
        patients.put(patient.getPatientID(), patient);

    }

    @Override
    public List<Patient> getAllPatients() {
        return new ArrayList<>(patients.values());
    }

    @Override
    public void updatePatient(Patient patient){
        patients.put(patient.getPatientID(), patient);
        int status = 0;
        try{
            con = SQLConnector.createConnection();
            String qry = "UPDATE Patient SET Name = ?, Phone = ?, ADDRESS = ?, PatientUserName = ?, PatientPassword = ? WHERE patientID = ?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, patient.getName());
            ps.setString(2, patient.getPhone());
            ps.setString(3, patient.getAddress());
            ps.setString(4, patient.getUserName());
            ps.setString(5, patient.getPassword());
            ps.setInt(6, patient.getPatientID());

            status = ps.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
//        return status;
    }

    @Override
    public void deletePatient(String patientID){
        try{
            con = SQLConnector.createConnection();
            String qry = "DELETE FROM Patient WHERE PatientID = ?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setString(1, patientID);
            ps.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Patient getPatientById(int patientID){
        try{
            con = SQLConnector.createConnection();
            String qry = "SELECT * FROM Patient WHERE PatientID = ?";
            PreparedStatement ps = con.prepareStatement(qry);
            ps.setInt(1, patientID);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                System.out.println("ID\tName\tPhone\tAddress\tUserName");
                System.out.print(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
            }
            System.out.println("\n");

        }catch (SQLException e){
            e.printStackTrace();
        }
        return patients.get(patientID);
    }
}
