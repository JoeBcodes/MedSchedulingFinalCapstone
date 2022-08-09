package com.techelevator.dao;

import com.techelevator.model.Appointments;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAppointmentsDao implements AppointmentsDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcAppointmentsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

//    @Override
//    public int findIdByApptDate() {}


    //change to userId

//isAvailable should be false, should only be visible to Drs// must also display the patient name
    //sql use OR
    @Override
    public List <Appointments> getAllBookedApptsByDoctor(int userId, boolean isAvailable) {
        List <Appointments> appointments = new ArrayList<>();
        String sql = "SELECT doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available " +
                "FROM appointments " +
                "WHERE doctor_id = ? AND is_available = false;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, isAvailable);
        while (results.next()) {
            Appointments appointment = mapRowToAppointments(results);
            appointments.add(appointment);
        }
        return appointments;
    }


    //find all by specific dr, should only be visible to patients
    @Override
    public List <Appointments> getAllAvailableApptsByDoctor(int userId, boolean isAvailable) {
        List <Appointments> appointments = new ArrayList<>();
        String sql = "SELECT doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available " +
                "FROM appointments " +
                "WHERE doctor_id = ? AND is_available = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId, isAvailable);
        while (results.next()) {
            Appointments appointment = mapRowToAppointments(results);
            appointments.add(appointment);
        }
        return appointments;
    }


    //find all regardless of Dr, only viewable by patient
    @Override
    public List<Appointments> getAllAvailableAppts(boolean isAvailable) {
        List <Appointments> appointments = new ArrayList<>();
        String sql = "SELECT doctor_id, patient_id, appt_date, appt_time, purpose_of_visit, is_read, is_available " +
                "FROM appointments " +
                "WHERE is_available = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, isAvailable);
        while (results.next()) {
            Appointments appointment = mapRowToAppointments(results);
            appointments.add(appointment);
        }
        return appointments;
    }

//    @Override
//    public Appointments findAllApptByPatient(int patientId) {
//        return null;
//    }

    private Appointments mapRowToAppointments(SqlRowSet rs) {
        Appointments appointment = new Appointments();
        appointment.setApptId(rs.getInt("appt_id"));
        appointment.setDoctorId(rs.getInt("doctor_id"));
        appointment.setPatientId(rs.getInt("patient_id"));
        appointment.setApptDate(rs.getDate("appt_date"));
        appointment.setApptTime(rs.getTime("appt_time"));
        appointment.setPurposeOfVisit(rs.getString("purpose_of_visit"));
        appointment.setRead(rs.getBoolean("is_read"));
        appointment.setAvailable(rs.getBoolean("is_available"));
        return appointment;
    }

}
