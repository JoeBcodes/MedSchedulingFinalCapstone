package com.techelevator.dao;

import com.techelevator.model.Office;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;

public class JdbcOfficeDao implements OfficeDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcOfficeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Office getOfficeById(int officeId) {
        Office office = null;
        String sql = "SELECT office_id, name, address, phone, email, start_hours, end_hours, specialty, hourly_rate " +
                "FROM office " +
                "WHERE office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        if (results.next()) {
            office = mapRowToOffice(results);
        }
        return office;
    }

    @Override
    public List<Office> getAllOffices() {
        List<Office> offices = new ArrayList<>();
        String sql = "SELECT office_id, name, address, phone, email, start_hours, end_hours, specialty, hourly_rate " +
                "FROM office;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Office office = mapRowToOffice(results);
            offices.add(office);
        }
        return offices;
    }

    @Override
    public void updateOfficeInfo(Office office, int officeId) {
        String sql = "UPDATE office " +
                "SET address = ?, phone = ?, start_hours = ?, end_hours = ?, hourly_rate = ? " +
                "WHERE office_id = ?;";
        jdbcTemplate.update(sql, office.getAddress(), office.getPhone(), office.getStartHours(), office.getEndHours(), office.getSpecialty(), officeId);
    }

    @Override
    public void addDoctorToOffice(int officeId, int doctorId) {
        String sql = "INSERT INTO doctors_in_office (doctor_id, office_id) " +
                "VALUES (?, ?);";
        jdbcTemplate.update(sql, doctorId, officeId);
    }

    @Override
    public void updateDoctorOffice(int officeId, int doctorId) {
        String sql = "UPDATE doctors_in_office " +
                "SET office_id = ? " +
                "WHERE doctor_id = ?;";
        jdbcTemplate.update(sql, officeId, doctorId);
    }

    @Override
    public void removeDoctorFromOffice(int officeId, int doctorId) {
        String sql = "DELETE FROM doctors_in_office " +
                "WHERE doctorId = ?; AND officeId = ?";
        jdbcTemplate.update(sql, doctorId, officeId);
    }

    private Office mapRowToOffice(SqlRowSet rs) {
        Office office = new Office();
        office.setOfficeId(rs.getInt("office_id"));
        office.setName(rs.getString("name"));
        office.setAddress(rs.getString("address"));
        office.setPhone(rs.getString("phone"));
        office.setEmail(rs.getString("email"));
        office.setStartHours(rs.getTime("start_hours"));
        office.setEndHours(rs.getTime("end_hours"));
        office.setSpecialty(rs.getString("specialty"));
        office.setHourlyRate(rs.getDouble("hourly_rate"));
        return office;
    }

}
