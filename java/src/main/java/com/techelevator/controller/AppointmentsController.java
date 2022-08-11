package com.techelevator.controller;


import com.techelevator.dao.AppointmentsDao;
import com.techelevator.dao.JdbcAppointmentsDao;
import com.techelevator.model.Appointments;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.List;

@RequestMapping("/appointments")
//@PreAuthorize("isAuthenticated()")
@RestController
public class AppointmentsController {
    private AppointmentsDao appointmentsDao;

    public AppointmentsController(DataSource dataSource) {
        this.appointmentsDao = new JdbcAppointmentsDao(dataSource);
    }

    @PreAuthorize("permitAll()")
    //do we need a preauthorize for user? or just general access for reviews
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Appointments getApptByApptId(@PathVariable int id) {
        return appointmentsDao.getApptById(id);
    }

    //@PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(path = "/doctor/{id}", method = RequestMethod.GET)
    //public List<Appointments> getAllBookedApptsByDoctorList(@PathVariable int id) {
    public List<Appointments> getAllBookedApptsByDoctorList(Principal principal) {
        return appointmentsDao.getAllBookedApptsByDoctor(principal.getName());
    }

    @PreAuthorize("hasRole('PATIENT')")
    @RequestMapping(path = "/patient-booked/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllBookedApptsByPatientList(Principal principal) {
        return appointmentsDao.getAllBookedApptsByPatient(principal.getName());
    }

    @PreAuthorize("hasRole('PATIENT')")
    @RequestMapping(path = "/patient/{id}", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsByDoctorList(@PathVariable int id) {
        return appointmentsDao.getAllAvailableApptsByDoctor(id);
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Appointments> getAllAvailableApptsList() {
        return appointmentsDao.getAllAvailableAppts();
    }

    @PreAuthorize("hasRole('DOCTOR')")
    @RequestMapping(path = "/doctor/notifications", method = RequestMethod.GET)
    public List<Appointments> getUnreadApptsList() {
        return appointmentsDao.getUnreadAppts();
    }

    //@PreAuthorize("hasRole('PATIENT')")
    @RequestMapping(path = "/new-appointment", method = RequestMethod.POST)
    public void createNewAppt(@RequestBody Appointments appointment) {
        appointmentsDao.createAppt(appointment);
    }



}
