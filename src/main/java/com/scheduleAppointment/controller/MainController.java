package com.scheduleAppointment.controller;

import com.scheduleAppointment.daos.LoginImpl;
import com.scheduleAppointment.daos.PatientImpl;
import com.scheduleAppointment.entities.Login;
import com.scheduleAppointment.entities.Patient;
import com.scheduleAppointment.util.SQLConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class MainController {

    public static void main(String[] args) {

        SQLConnector sqlObj = new SQLConnector();
        SQLConnector.createConnection();

        Scanner sc = new Scanner(System.in);

        PatientImpl p1 = new PatientImpl();

        Connection con = null;

        while (true) {
            System.out.println("\n============Welcome to Serenity Hospital Appointment portal============\n");
            System.out.println("\n [1] Returning Patient \n [2] New Patient \n [3] Exit     \n");
            int st = sc.nextInt();
            sc.nextLine();
            if (st == 1) {
                System.out.println("Username : ");
                String un = sc.nextLine();
                System.out.println("Password : ");
                String pass = sc.nextLine();
                String x = "";
                try {
                    con = SQLConnector.createConnection();
                    String ck = "SELECT PatientPassword FROM Patient WHERE PatientUserName = ?";
                    PreparedStatement ps = con.prepareStatement(ck);
                    ps.setString(1, un);
                    ResultSet rs = ps.executeQuery();
                    while(rs.next()){
                        x = rs.getString(1);
                    }
                    if (x.equals(pass)){
                        LoginImpl logimp = new LoginImpl();

                        String ext;
                        System.out.println("1 : Update patient");
                        System.out.println("2 : Delete patient");
                        System.out.println("3 : Find patient");
                        System.out.println("4 : Exit");
                        System.out.println("Choose from the above...");

                        ext = sc.nextLine();
                        switch (ext) {
                            case "1":
                                System.out.println("Please enter patient ID.....");
                                int id = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Please enter the Patient Name : ");
                                String name = sc.nextLine();
                                System.out.println("Please enter the Patient Phone : ");
                                String phone = sc.nextLine();
                                System.out.println("Please enter the Patient Address : ");
                                String address = sc.nextLine();
                                System.out.println("Please enter the Patient UserName : ");
                                String username = sc.nextLine();
                                System.out.println("Please enter the Patient Password : ");
                                String password = sc.nextLine();
                                p1.updatePatient(new Patient(id, name, phone, address, username, password));
                                break;
                            case "2":
                                System.out.println("Enter patient ID : ");
                                String pID = sc.nextLine();
                                p1.deletePatient(pID);
                                System.out.println("Patient successfully deleted from the System");
                                break;
                            case "3":
                                System.out.println("Enter patient ID : ");
                                int idd = sc.nextInt();
                                sc.nextLine();
                                p1.getPatientById(idd);
                                break;
                            case "4":
                                System.out.println("exit");
                                break;
                        }

                    }else {
                        System.out.println("Wrong Password!!");
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (st == 2) {
                System.out.println("Please fill out the following question...");
                System.out.println("Enter Name, Phone, Address, UserName and Password...");
                String name = sc.nextLine();
                String phone = sc.nextLine();
                String Address = sc.nextLine();
                String UserName = sc.nextLine();
                String Password = sc.nextLine();
                Patient patient1 = new Patient(name, phone, Address, UserName, Password);
                p1.addPatient(patient1);
                System.out.println("Patient successfully added to the system");
            } else if (st == 3) {
                System.exit(0);
            }
        }
    }
}
