package com.techelevator.dao;

import com.techelevator.model.Calendar;

import java.util.ArrayList;
import java.util.List;

public interface CalendarDao {

     List<Calendar>  viewCalendar(int doctorId);
     void updateCalendar(Calendar calendar);
     void createCalendar(Calendar calendar);
     void deleteCalendar(int calendarId);
}
