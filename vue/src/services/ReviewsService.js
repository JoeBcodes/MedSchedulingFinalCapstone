import axios from 'axios';


export default {

    getAllOfficeReviews(office) {
        return axios.get(`/reviews/office/${office.officeId}`);
    },

    getAllDoctorReviews(doctors) {
        return axios.get(`/reviews/doctor/${doctors.doctorId}`);
    },

    getReviewById(reviews) {
        return axios.get(`/reviews/${reviews.reviewId}`);
    },

    createReview(reviews) {
        return axios.post('/reviews', reviews);
    },

    updateWithDoctorReply(reviews) {
        return axios.put(`/reviews/`, reviews);
    }

}