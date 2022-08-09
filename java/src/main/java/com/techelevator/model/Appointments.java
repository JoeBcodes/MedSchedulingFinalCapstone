package com.techelevator.model;

public class Appointments {

    private int apptId;
    //change to userId
    private int doctorId;
    private int patientId;
    private String apptDate;
    private String apptTime;
    private String purposeOfVisit;
    private boolean isRead;
    private boolean isAvailable;
    private String doctorName;
    private String patientName;

    public Appointments() {
    }

    ;

    public Appointments(int apptId, int doctorId, int patientId, String apptDate, String apptTime, String purposeOfVisit,
                        boolean isCompleted, boolean isAvailable) {
        this.apptId = apptId;
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.apptDate = apptDate;
        this.apptTime = apptTime;
        this.purposeOfVisit = purposeOfVisit;
        this.isRead = isRead;
        this.isAvailable = isAvailable;
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

    public String getApptDate() {
        return apptDate;
    }

    public void setApptDate(String apptDate) {
        this.apptDate = apptDate;
    }

    public String getApptTime() {
        return apptTime;
    }

    public void setApptTime(String apptTime) {
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

    public void setRead(boolean completed) {
        isRead = completed;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
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
                '}';
    }
}
