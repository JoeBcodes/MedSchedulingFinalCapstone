package com.techelevator.controller;
import com.techelevator.dao.CalendarDao;
import com.techelevator.dao.JdbcCalendarDao;
import com.techelevator.model.Calendar;
import com.techelevator.model.User;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/calendar")
public class CalendarController {

    private CalendarDao dao;

    public CalendarController(DataSource dataSource) {
        this.dao = new JdbcCalendarDao(dataSource);
    }

    @RequestMapping(path = "/{doctorId}", method = RequestMethod.GET)
    public List<Calendar> getCalendarByDoctorId(@PathVariable int doctorId) {
        return dao.viewCalendar(doctorId);
    }



}