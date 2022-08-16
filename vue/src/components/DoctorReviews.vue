<template>
    <div id="doctorList">
            
            <p>My Reviews</p>
            
            <div class="reviewList" v-for="review in reviews" v-bind:key="review.reviewId">
                
                    <div class="reviewRow">
                        {{review.reviewDesc}}<br />
                        <textarea v-if="!review.doctorReply" v-model.lazy="updatedReview.doctorReply" placeholder="Leave reply here..."></textarea><br />
                        <button v-if="!review.doctorReply" class="leaveReplyButton" v-on:click="addDoctorReply(updatedReview, review.reviewId)">Submit Reply</button>
                    </div>
                
            </div>

    </div>
</template>

<script>
import ReviewsService from '../services/ReviewsService.js';

export default {
    name: "doctor-reviews",
    data() {
        return {
            reviews: [],
            review: {
                reviewId: null,
                reviewerId: null,
                reviewerName: '',
                reviewDate: '',
                officeName: '',
                doctorId: null,
                doctorName: '',
                reviewDesc: '',
                rating: null,
                doctorReply: ''
            },
            updatedReview: {
                reviewId: null,
                doctorReply: ''
            },
            test: '',
            doctors: [],
            isShown: false
        }
    },
    
  methods: {
        retrieveReviews(doctorId) {
            ReviewsService.getAllDoctorReviews(doctorId).then(response => {
                this.reviews = response.data;
                console.log(response);
            });
        },
        showReview() {
            this.isShown = !this.isShown;
        },
        addDoctorReply(updatedReview, reviewId) {
            this.updatedReview.reviewId = reviewId;
            ReviewsService.updateWithDoctorReply(updatedReview);
            setTimeout(function(){window.location.reload();},1000);
        }
    },
    created() {
            this.retrieveReviews(this.$store.state.user.userId);
        }
}
</script>


<style scoped>

</style>