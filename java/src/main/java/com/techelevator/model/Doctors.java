package com.techelevator.model;

public class Doctors {

    private int doctorId;
    private String doctorName;
    private int doctorOfficeId;
    private String doctorOfficeName;
    private String doctorPhone;
    private String doctorEmail;
    private String doctorSpecialty;

    public Doctors() {}

    public Doctors(int doctorId, String doctorName, int doctorOfficeId, String doctorOfficeName, String doctorPhone, String doctorEmail, String doctorSpecialty) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorOfficeId = doctorOfficeId;
        this.doctorOfficeName = doctorOfficeName;
        this.doctorPhone = doctorPhone;
        this.doctorEmail = doctorEmail;
        this.doctorSpecialty = doctorSpecialty;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getDoctorOfficeId() {
        return doctorOfficeId;
    }

    public void setDoctorOfficeId(int doctorOfficeId) {
        this.doctorOfficeId = doctorOfficeId;
    }

    public String getDoctorOfficeName() {
        return doctorOfficeName;
    }

    public void setDoctorOfficeName(String doctorOfficeName) {
        this.doctorOfficeName = doctorOfficeName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorEmail() {
        return doctorEmail;
    }

    public void setDoctorEmail(String doctorEmail) {
        this.doctorEmail = doctorEmail;
    }

    public String getDoctorSpecialty() {
        return doctorSpecialty;
    }

    public void setDoctorSpecialty(String doctorSpecialty) {
        this.doctorSpecialty = doctorSpecialty;
    }

    @Override
    public String toString() {
        return "Doctor: " +
                "Doctor ID: " + doctorId +
                "Doctor Name: " + doctorName +
                "Doctor Office ID: " + doctorOfficeId +
                "Doctor Office Name: " + doctorOfficeName +
                "Doctor Phone Number: " + doctorPhone +
                "Doctor Email: " + doctorEmail +
                "Doctor Specialty: " + doctorSpecialty;
    }
}
