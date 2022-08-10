package com.techelevator.dao;
import com.techelevator.model.Calendar;
import com.techelevator.model.User;
import com.techelevator.model.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;


@Component
public class JdbcCalendarDao implements CalendarDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcCalendarDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Calendar>  viewCalendar(int doctorId) {
           List<Calendar> calendars = new ArrayList<>();
           String sql = "SELECT doctor_id, day_of_the_week, start_time, end_time " +
                        "FROM calendar " +
                        "WHERE doctor_id = ?;";
           SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
           while (results.next()) {
               Calendar calendar = mapRowToCalendar(results);
               calendars.add(calendar);
           }
           return calendars;
       }

    private Calendar mapRowToCalendar(SqlRowSet rs) {
        Calendar calendar = new Calendar();
        calendar.setDoctorId(rs.getInt("doctor_id"));
        calendar.setDayOfTheWeek(rs.getString("day_of_the_week"));
        calendar.setStartTime(rs.getTime("start_time"));
        calendar.setEndTime(rs.getTime("end_time"));
        return calendar;
    }
}