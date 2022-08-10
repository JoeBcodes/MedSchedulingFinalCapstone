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
//@PreAuthorize("isAuthenticated()")
@RestController
public class AppointmentsController {
    private AppointmentsDao appointmentsDao;

    public AppointmentsController(DataSource dataSource) {
        this.appointmentsDao = new JdbcAppointmentsDao(dataSource);
    }

    //do we need a preauthorize for user? or just general access for reviews
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Appointments getApptByApptId(@PathVariable int id) {
        return appointmentsDao.getApptById(id);
    }

    //@PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(path = "/doctor/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllBookedApptsByDoctorList(@PathVariable int id) {
        return appointmentsDao.getAllBookedApptsByDoctor(id);
    }

    //@PreAuthorize("hasRole('PATIENT')")
    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsByDoctorList(@PathVariable int id) {
        return appointmentsDao.getAllAvailableApptsByDoctor(id);
    }

    //@PreAuthorize("hasRole('PATIENT')")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsList() {
        return appointmentsDao.getAllAvailableAppts();
    }
}
