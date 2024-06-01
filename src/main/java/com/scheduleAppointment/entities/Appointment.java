package com.scheduleAppointment.entities;

public class Appointment{
    private int AppointmentID;
    private int PatientID;
    private int DoctorID;
    private String Date;
    private String status;

    public int getAppointmentID() {
        return AppointmentID;
    }

    public void setAppointmentID(int appointmentID) {
        AppointmentID = appointmentID;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Appointment(int appointmentID, int patientID, int doctorID, String date, String status) {
        AppointmentID = appointmentID;
        PatientID = patientID;
        DoctorID = doctorID;
        Date = date;
        this.status = status;
    }

    public Appointment(int patientID, int doctorID, String date, String status) {
        PatientID = patientID;
        DoctorID = doctorID;
        Date = date;
        this.status = status;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Appointment{" +
                "AppointmentID=" + AppointmentID +
                ", PatientID=" + PatientID +
                ", DoctorID=" + DoctorID +
                ", Date='" + Date + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}