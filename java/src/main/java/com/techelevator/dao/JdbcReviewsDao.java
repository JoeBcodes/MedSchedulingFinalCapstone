package com.techelevator.dao;

import com.techelevator.model.Reviews;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcReviewsDao implements ReviewsDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewsDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Reviews> getAllReviewsByDoctorId(int doctorId) {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT r.review_id, r.reviewer_id, ru.first_name || ' ' || ru.last_name AS reviewer_name, " +
                    "r.review_date, o.name, r.doctor_id, du.first_name || ' ' || du.last_name AS doctor_name, " +
                    "r.review_desc, r.rating " +
                "FROM reviews r " +
                "JOIN users ru " +
                "ON r.reviewer_id = ru.user_id " +
                "JOIN users du " +
                "ON r.doctor_id = du.user_id " +
                "JOIN doctors_in_office dio " +
                "ON r.doctor_id = dio.doctor_id " +
                "JOIN office o " +
                "ON dio.office_id = o.office_id " +
                "WHERE r.doctor_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, doctorId);
        while (results.next()) {
            Reviews review = mapRowToReviews(results);
            reviews.add(review);
        }
        return reviews;
    }

    @Override
    public List<Reviews> getAllReviewsByOfficeId(int officeId) {
        List<Reviews> reviews = new ArrayList<>();
        String sql = "SELECT r.review_id, r.reviewer_id, ru.first_name || ' ' || ru.last_name AS reviewer_name, " +
                "r.review_date, o.name, r.doctor_id, du.first_name || ' ' || du.last_name AS doctor_name, " +
                "r.review_desc, r.rating " +
                "FROM reviews r " +
                "JOIN users ru " +
                "ON r.reviewer_id = ru.user_id " +
                "JOIN users du " +
                "ON r.doctor_id = du.user_id " +
                "JOIN doctors_in_office dio " +
                "ON r.doctor_id = dio.doctor_id " +
                "JOIN office o " +
                "ON dio.office_id = o.office_id " +
                "WHERE o.office_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, officeId);
        while (results.next()) {
            Reviews review = mapRowToReviews(results);
            reviews.add(review);
        }
        return reviews;
    }

    private Reviews mapRowToReviews(SqlRowSet rowSet) {
        Reviews reviews = new Reviews();
        reviews.setReviewId(rowSet.getInt("review_id"));
        reviews.setReviewerId(rowSet.getInt("reviewer_id"));
        reviews.setReviewerName(rowSet.getString("reviewer_name"));
        reviews.setReviewDate(rowSet.getDate("review_date"));
        reviews.setOfficeName(rowSet.getString("name"));
        reviews.setDoctorId(rowSet.getInt("doctor_id"));
        reviews.setDoctorName(rowSet.getString("doctor_name"));
        reviews.setReviewDesc(rowSet.getString("review_desc"));
        reviews.setRating(rowSet.getInt("rating"));
        return reviews;
    }
}
