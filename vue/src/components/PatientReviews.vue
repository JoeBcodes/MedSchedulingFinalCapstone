<template>
      <div id="reviewsList">
        <div class="reviews" v-for="review in this.$store.state.reviews" v-bind:key="review.review_id">
            {{reviews.reviewerName}}
            {{reviews.reviewDate}}
            {{reviews.officeName}}
            {{reviews.doctorName}}
             {{reviews.reviewDesc}}
              {{reviews.rating}}
               {{reviews.doctorReply}}
        </div>
    </div>
</template>

<script>
import ReviewsService from '../services/ReviewsService.js';

export default {
    name: "patient-reviews",
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
            }
        }
    },
   
  methods: {
        retrieveReviews() {
            ReviewsService.getDoctorsReviews(this.$store.state.user).then(response => {
                this.$store.commit("SET_REVIEWS", response.data);
                console.log(response);
            });
        }
    },
    created() {
            this.retrieveReviews();
        }
}

</script>


<style scoped>

</style>