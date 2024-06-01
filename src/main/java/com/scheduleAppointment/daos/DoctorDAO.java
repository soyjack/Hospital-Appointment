package com.scheduleAppointment.daos;

import com.scheduleAppointment.entities.Patient;

import java.util.List;

interface DoctorDAO {
    void addDoctor();
    Patient getPatientById(int patientId);
    List<Patient> getAllPatients();

    void updatePatient(Patient patient);
    void deletePatient(int patientId);


}
