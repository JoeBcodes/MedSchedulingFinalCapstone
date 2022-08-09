package com.techelevator.dao;

import com.techelevator.model.Reviews;

import java.util.List;

public interface ReviewsDao {

    List<Reviews> getAllReviewsByDoctorId(int doctorId);
    List<Reviews> getAllReviewsByOfficeId(int officeId);
}
