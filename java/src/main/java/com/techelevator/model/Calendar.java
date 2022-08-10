package com.techelevator.model;
import java.sql.Time;

public class Calendar {
    private int calendarId;
    private int doctorId;
    private String dayOfTheWeek;
    private Time startTime;
    private Time endTime;

    public Calendar() {
    }

    public Calendar(int doctorId, String dayOfTheWeek, Time startTime, Time endTime, int calendarId) {
        this.calendarId = calendarId;
        this.doctorId = doctorId;
        this.dayOfTheWeek = dayOfTheWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getCalendarId() {
        return calendarId;
    }

    public void setCalendarId(int calendarId) {
        this.calendarId = calendarId;
    }

    @Override
    public String toString() {
        return "Calendar{" +
                " calendarId=" + calendarId +
                ", doctorId=" + doctorId +
                ", dayOfTheWeek=" + dayOfTheWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
