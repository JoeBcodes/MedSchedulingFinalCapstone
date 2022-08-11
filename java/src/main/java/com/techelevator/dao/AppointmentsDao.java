package com.techelevator.dao;

import com.techelevator.model.Appointments;

import java.util.List;

public interface AppointmentsDao {

    Appointments getApptById(int apptId);

    List<Appointments> getAllBookedApptsByDoctor(String doctorName);

    List<Appointments> getAllBookedApptsByPatient(String username);

    List <Appointments> getAllAvailableApptsByDoctor(int userId);

    List<Appointments> getAllAvailableAppts();

    void createAppt(Appointments appointment);

    List<Appointments> getUnreadAppts();

}
