package com.techelevator.dao;

import com.techelevator.model.Appointments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentsDao implements AppointmentsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    @Override
//    public int findIdByApptDate() {}


    //change to userId

//isAvailable should be false, should only be visible to Drs// must also display the patient name
    //sql use OR
    @Override
    public Appointments findAllBookedApptsByDoctor(int userId, boolean isAvaialble) {
        return null;
    }


    //find all by specific dr, should only be visible to patients
    @Override
    public Appointments findAllAvailableApptsByDoctor(int doctorId, boolean isAvailable) {
        return null;
    }


    //find all regardless of Dr, only viewable by patient
    @Override
    public Appointments findAllAvailableAppts(boolean isAvailable) {
        return null;
    }

//    @Override
//    public Appointments findAllApptByPatient(int patientId) {
//        return null;
//    }

}
