package com.scheduleAppointment.entities;

public class Doctor{
    private int DoctorID;
    private String Name;
    private String Specialization;
    private String ContactInfo;
    private boolean Availability;

    public int getDoctorID() {
        return DoctorID;
    }

    public void setDoctorID(int doctorID) {
        DoctorID = doctorID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public String getContactInfo() {
        return ContactInfo;
    }

    public void setContactInfo(String contactInfo) {
        ContactInfo = contactInfo;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public Doctor(int doctorID, String name, String specialization, String contactInfo, boolean availability) {
        DoctorID = doctorID;
        Name = name;
        Specialization = specialization;
        ContactInfo = contactInfo;
        Availability = availability;
    }

    public Doctor(String name, String specialization, String contactInfo, boolean availability) {
        Name = name;
        Specialization = specialization;
        ContactInfo = contactInfo;
        Availability = availability;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Doctor{" +
                "DoctorID=" + DoctorID +
                ", Name='" + Name + '\'' +
                ", Specialization='" + Specialization + '\'' +
                ", ContactInfo='" + ContactInfo + '\'' +
                ", Availability=" + Availability +
                '}';
    }


}