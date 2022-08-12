package com.techelevator.controller;
import com.techelevator.dao.CalendarDao;
import com.techelevator.dao.JdbcCalendarDao;
import com.techelevator.model.Calendar;
import com.techelevator.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/calendar")
@PreAuthorize("isAuthenticated()")
@CrossOrigin(origins = "http://localhost:8080")
public class CalendarController {

    private CalendarDao dao;

    public CalendarController(DataSource dataSource) {
        this.dao = new JdbcCalendarDao(dataSource);
    }

    @RequestMapping(path = "/{doctorId}", method = RequestMethod.GET)
    public List<Calendar> getCalendarByDoctorId(@PathVariable int doctorId) {
        return dao.viewCalendar(doctorId);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public  void updateCalendarByDoctorId(@RequestBody Calendar calendar) {
        dao.updateCalendar(calendar);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createCalendarByDoctorId(@RequestBody Calendar calendar) {
         dao.createCalendar(calendar);
    }


}