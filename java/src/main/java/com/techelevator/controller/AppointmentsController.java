package com.techelevator.controller;


import com.techelevator.dao.AppointmentsDao;
import com.techelevator.dao.JdbcAppointmentsDao;
import com.techelevator.model.Appointments;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RequestMapping("/appointments")
@PreAuthorize("isAuthenticated")
@RestController
public class AppointmentsController {
    private AppointmentsDao appointmentsDao;

    public AppointmentsController(DataSource dataSource) {
        this.appointmentsDao = new JdbcAppointmentsDao(dataSource);
    }

    @RequestMapping(path = "/booked/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllBookedApptsByDoctorList(@PathVariable int userId, boolean isAvailable) {
        return appointmentsDao.getAllBookedApptsByDoctor(userId, isAvailable);
    }

    @RequestMapping(path = "/available/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsByDoctorList(@PathVariable int userId, boolean isAvailable) {
        return appointmentsDao.getAllAvailableApptsByDoctor(userId, isAvailable);
    }

    @RequestMapping(path = "available", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsList(@PathVariable boolean isAvailable) {
        return appointmentsDao.getAllAvailableAppts(isAvailable);
    }
}
