package com.scheduleAppointment.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnector {
    public static Connection createConnection(){
        Connection con = null;
        final String DB_NAME = "PatientDB";
        final String DB_URL = "jdbc:mysql://localhost:3306/PatientDB";
        final String DB_USERNAME = "root";
        final String DB_PASSWORD = "153493";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }

        return con;
    }
}
