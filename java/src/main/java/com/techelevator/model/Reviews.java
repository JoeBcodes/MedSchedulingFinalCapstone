package com.techelevator.model;

import javax.validation.constraints.NotBlank;
import java.sql.Date;

public class Reviews {

    //@NotBlank
    private int reviewId;
    private int reviewerId;
    private String reviewerName;
    private Date reviewDate;
    private String officeName;
    private int doctorId;
    private String doctorName;
    private String reviewDesc;
    private int rating;
    private String doctorReply;

    public Reviews() { }

    public Reviews(int reviewId, int reviewerId, String reviewerName, Date reviewDate, String officeName, int doctorId, String doctorName, String reviewDesc, int rating, String doctorReply) {
        this.reviewId = reviewId;
        this.reviewerId = reviewerId;
        this.reviewerName = reviewerName;
        this.reviewDate = reviewDate;
        this.officeName = officeName;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.reviewDesc = reviewDesc;
        this.rating = rating;
        this.doctorReply = doctorReply;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(int reviewerId) {
        this.reviewerId = reviewerId;
    }

    public Date getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(Date reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public void setReviewerName(String reviewerName) {
        this.reviewerName = reviewerName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getDoctorReply() {
        return doctorReply;
    }

    public void setDoctorReply(String doctorReply) {
        this.doctorReply = doctorReply;
    }

    @Override
    public String toString() {
        return "Review: " +
                "Review ID: " + reviewId +
                "Reviewer: " + reviewerName +
                "Review Date: " + reviewDate +
                "Office: " + officeName +
                "Doctor: " + doctorName +
                "Review: " + reviewDesc +
                "Rating: " + rating +
                "Doctor Reply " + doctorReply;
    }
}
