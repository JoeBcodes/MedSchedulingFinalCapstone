<template>
    <div id="doctorList">
            
        <h2>My Reviews</h2>
        
        <div class="reviewList" v-for="review in reviews" v-bind:key="review.reviewId">
            <doctor-review :review="review" />
            <br /><br />
        </div>

    </div>
</template>

<script>
import ReviewsService from '../services/ReviewsService.js';
import DoctorReview from './DoctorReview.vue'

export default {
    name: "doctor-reviews",
    components: {
        DoctorReview
    },
    data() {
        return {
            reviews: [],
            updatedReview: {
                reviewId: null,
                doctorReply: ''
            },
            doctors: [],
            isShown: false
        }
    },
    
  methods: {
        retrieveReviews(doctorId) {
            ReviewsService.getAllDoctorReviews(doctorId).then(response => {
                this.reviews = response.data;
            });
        },
    },
    created() {
        this.retrieveReviews(this.$store.state.user.userId);
    }
}
</script>


<style scoped>

</style>