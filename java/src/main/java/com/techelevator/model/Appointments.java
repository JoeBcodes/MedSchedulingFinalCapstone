package com.techelevator.model;

import java.sql.Time;
import java.util.Date;

public class Appointments {

    private int apptId;
    //change to userId
    private int doctorId;
    private int patientId;
    private Date apptDate;
    private Time apptTime;
    private String purposeOfVisit;
    private boolean isRead;
    private boolean isAvailable;
    private String doctorName;
    private String patientName;

    public Appointments() {
    }

    ;

    public Appointments(int apptId, int doctorId, int patientId, Date apptDate, Time apptTime, String purposeOfVisit,
                        boolean isRead, boolean isAvailable, String doctorName, String patientName) {
        this.apptId = apptId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.apptDate = apptDate;
        this.apptTime = apptTime;
        this.purposeOfVisit = purposeOfVisit;
        this.isRead = isRead;
        this.isAvailable = isAvailable;
        this.doctorName = doctorName;
        this.patientName = patientName;
    }


    public int getApptId() {
        return apptId;
    }

    public void setApptId(int apptId) {
        this.apptId = apptId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getApptDate() {
        return apptDate;
    }

    public void setApptDate(Date apptDate) {
        this.apptDate = apptDate;
    }

    public Time getApptTime() {
        return apptTime;
    }

    public void setApptTime(Time apptTime) {
        this.apptTime = apptTime;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "apptId=" + apptId +
                ", doctorId='" + doctorId +
                ", patientId=" + patientId +
                ", apptDate=" + apptDate +
                ", apptTime=" + apptTime +
                ", purposeOfVisit=" + purposeOfVisit +
                ", isRead=" + isRead +
                ", isAvailable=" + isAvailable +
                ", doctorName=" + doctorName +
                ", patientName=" + patientName +
                '}';
    }
}
