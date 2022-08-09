package com.techelevator.controller;

import com.techelevator.dao.JdbcReviewsDao;
import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Reviews;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
public class ReviewsController {

    private ReviewsDao reviewsDao;

    public ReviewsController(DataSource dataSource) {
        this.reviewsDao = new JdbcReviewsDao(dataSource);
    }

    @RequestMapping(path = "/office/{id}/reviews", method = RequestMethod.GET)
    public List<Reviews> getAllOfficeReviews(@PathVariable int id) {
        return reviewsDao.getAllReviewsByOfficeId(id);
    }

    @RequestMapping(path = "/doctor/{id}/reviews", method = RequestMethod.GET)
    public List<Reviews> getAllDoctorReviews(@PathVariable int id) {
        return reviewsDao.getAllReviewsByDoctorId(id);
    }
}
