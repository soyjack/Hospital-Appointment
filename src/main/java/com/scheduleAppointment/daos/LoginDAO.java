package com.scheduleAppointment.daos;

import com.scheduleAppointment.entities.Login;
import com.scheduleAppointment.entities.Patient;

import java.sql.Connection;

public interface LoginDAO {

    //    public LoginImpl(Login login) {
    //        login.
    //    }
    Connection login(Login login);

    void createAccount(Patient patient);
}
