package com.techelevator.dao;

import com.techelevator.model.Appointments;

import java.util.List;

public interface AppointmentsDao {

    List<Appointments> getAllBookedApptsByDoctor(int userId, boolean isAvailable);

    List <Appointments> getAllAvailableApptsByDoctor(int userId, boolean isAvailable);

    List<Appointments> getAllAvailableAppts(boolean isAvailable);

}
