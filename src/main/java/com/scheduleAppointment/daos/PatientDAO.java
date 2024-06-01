package com.scheduleAppointment.daos;

import com.scheduleAppointment.entities.Patient;

import java.util.List;

public interface PatientDAO {

    Patient getPatientById(int patientId);

    void addPatient(Patient patient);

    List<Patient> getAllPatients();

    void updatePatient(Patient patient);
    void deletePatient(String patientId);
}
