package com.techelevator.dao;

import com.techelevator.model.Appointments;

import java.util.List;

public interface AppointmentsDao {

    List<Appointments> getAllBookedApptsByDoctor(int userId);

    List <Appointments> getAllAvailableApptsByDoctor(int userId);

    List<Appointments> getAllAvailableAppts();

}