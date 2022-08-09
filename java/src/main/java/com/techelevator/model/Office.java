package com.techelevator.model;

import java.sql.Time;

public class Office {
    private int officeId;
    private String name;
    private String address;
    private String phone;
    private String email;
    private Time startHours;
    private Time endHours;
    private String specialty;
    private double hourlyRate;

    public Office() {

    }

    public Office(int officeId, String name, String address, String phone, String email, Time startHours, Time endHours, String specialty, double hourlyRate) {
        this.officeId = officeId;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.startHours = startHours;
        this.endHours = endHours;
        this.specialty = specialty;
        this.hourlyRate = hourlyRate;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Time getStartHours() {
        return startHours;
    }

    public void setStartHours(Time startHours) {
        this.startHours = startHours;
    }

    public Time getEndHours() {
        return endHours;
    }

    public void setEndHours(Time endHours) {
        this.endHours = endHours;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Office Info: " +
                "Office ID: " + officeId +
                "Office name: " + name +
                "Address: " + address +
                "Phone: " + phone +
                "Email: " + email +
                "Start Hours: " + startHours +
                "End Hours: " + endHours +
                "Specialty: " + specialty +
                "Hourly rate: " + hourlyRate;
    }
}
