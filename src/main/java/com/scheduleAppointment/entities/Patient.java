package com.scheduleAppointment.entities;

public class Patient{
    private int PatientID;
    private String Name;
    private String phone;
    private String Address;
    private String UserName;
    private String Password;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Patient(int patientID, String name, String phone, String address, String PUserName, String PPassword) {
        PatientID = patientID;
        Name = name;
        this.phone = phone;
        Address = address;
        UserName = PUserName;
        Password = PPassword;
    }

    public Patient(String name, String phone, String address, String UserName, String Password) {
        Name = name;
        this.phone = phone;
        Address = address;
        this.UserName = UserName;
        this.Password = Password;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "PatientID=" + PatientID +
                ", Name='" + Name + '\'' +
                ", phone='" + phone + '\'' +
                ", Address='" + Address + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}