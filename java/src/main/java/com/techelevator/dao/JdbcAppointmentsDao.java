package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcAppointmentsDao implements AppointmentsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentsDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int findIdBy

}
