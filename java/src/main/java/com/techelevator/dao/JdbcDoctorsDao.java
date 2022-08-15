package com.techelevator.dao;

import com.techelevator.model.Doctors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcDoctorsDao implements DoctorsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcDoctorsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Doctors> getAllDoctors() {
        List<Doctors> doctors = new ArrayList<>();
        String sql = "SELECT u.user_id, u.first_name || ' ' || u.last_name AS doctor_name, " +
                "dio.office_id, o.name, u.phone, u.email, o.specialty " +
                "FROM users u " +
                "JOIN doctors_in_office dio " +
                "ON u.user_id = dio.doctor_id " +
                "JOIN office o " +
                "ON dio.office_id = o.office_id " +
                "WHERE u.role = 'DOCTOR';";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Doctors doctor = mapRowToDoctors(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public List<Doctors> getAllDoctorsByOfficeId(int officeId) {
        List<Doctors> doctors = new ArrayList<>();
        String sql = "SELECT u.user_id, u.first_name || ' ' || u.last_name AS doctor_name, " +
                "dio.office_id, o.name, u.phone, u.email, o.specialty " +
                "FROM users u " +
                "JOIN doctors_in_office dio " +
                "ON u.user_id = dio.doctor_id " +
                "JOIN office o " +
                "ON dio.office_id = o.office_id " +
                "WHERE u.role = 'DOCTOR' AND dio.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()) {
            Doctors doctor = mapRowToDoctors(results);
            doctors.add(doctor);
        }
        return doctors;
    }

    private Doctors mapRowToDoctors(SqlRowSet rowSet) {
        Doctors doctors = new Doctors();
        doctors.setDoctorId(rowSet.getInt("user_id"));
        doctors.setDoctorName(rowSet.getString("doctor_name"));
        doctors.setDoctorOfficeId(rowSet.getInt("office_id"));
        doctors.setDoctorOfficeName(rowSet.getString("name"));
        doctors.setDoctorPhone(rowSet.getString("phone"));
        doctors.setDoctorEmail(rowSet.getString("email"));
        doctors.setDoctorSpecialty(rowSet.getString("specialty"));
        return doctors;
    }
}
