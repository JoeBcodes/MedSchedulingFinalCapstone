package com.techelevator.controller;

import com.techelevator.dao.JdbcReviewsDao;
import com.techelevator.dao.ReviewsDao;
import com.techelevator.model.Reviews;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.List;

@RestController
//@PreAuthorize("isAuthenticated()")
@RequestMapping(path = "/reviews")
public class ReviewsController {

    private ReviewsDao reviewsDao;

    public ReviewsController(DataSource dataSource) {
        this.reviewsDao = new JdbcReviewsDao(dataSource);
    }

    @RequestMapping(path = "/office/{id}", method = RequestMethod.GET)
    public List<Reviews> getAllOfficeReviews(@PathVariable int id) {
        return reviewsDao.getAllReviewsByOfficeId(id);
    }

    @RequestMapping(path = "/doctor/{id}", method = RequestMethod.GET)
    public List<Reviews> getAllDoctorReviews(@PathVariable int id) {
        return reviewsDao.getAllReviewsByDoctorId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Reviews getReview(@PathVariable int id) {
        return reviewsDao.getReviewById(id);
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public void createReview(@Valid @RequestBody Reviews review) {
        reviewsDao.create(review);
    }

    @RequestMapping(path = "", method = RequestMethod.PUT)
    public void updateReviewWithDoctorReply(@Valid @RequestBody Reviews review) {
        reviewsDao.addDoctorReplyToReview(review);
    }


}
