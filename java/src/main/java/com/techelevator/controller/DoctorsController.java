package com.techelevator.controller;

import com.techelevator.dao.DoctorsDao;
import com.techelevator.dao.JdbcDoctorsDao;
import com.techelevator.model.Doctors;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RequestMapping("/doctors")
@PreAuthorize("isAuthenticated()")
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class DoctorsController {

    private DoctorsDao doctorsDao;

    public DoctorsController(DataSource dataSource) {
        this.doctorsDao = new JdbcDoctorsDao(dataSource);
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Doctors> listAllDoctors() {
        return doctorsDao.getAllDoctors();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Doctors> listAllDoctorsByOfficeId(@PathVariable int id) {
        return doctorsDao.getAllDoctorsByOfficeId(id);
    }
}
