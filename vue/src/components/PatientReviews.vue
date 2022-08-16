<template>
    <div id="doctorList">
        <select v-model="selectedDoctor" v-on:change="retrieveReviews(selectedDoctor)">
            <option value="0">-Please select a doctor-</option>
            <option v-for="doctor in doctors" v-bind:key="doctor.doctorId" v-bind:value="doctor.doctorId">{{doctor.doctorName}}</option>
        </select>
            
        <div class="individualReview">
            <div v-for="review in reviews" v-bind:key="review.reviewId">
                
                {{review.reviewDesc}}
                {{review.reviewRating}}
                {{review.reviewDate}}
                {{review.reviewerName}}
                {{review.doctorReply}}

            </div>
        </div>

    </div>
</template>

<script>
import ReviewsService from '../services/ReviewsService.js';
import DoctorService from '../services/DoctorService.js';

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
            },
            doctors: [],
            selectedDoctor: 0,
            isShown: false
        }
    },
    
  methods: {
      retrieveAllDoctors() {
          DoctorService.listAllDoctors().then(response => {
              this.doctors = response.data;
              console.log(response);
          })
      },
        retrieveReviews(doctorId) {
            ReviewsService.getAllDoctorReviews(doctorId).then(response => {
                this.reviews = response.data;
                console.log(response);
            });
        },
        showReview() {
            this.isShown = !this.isShown;
        }
    },
    created() {
            //this.retrieveReviews(2);
            this.retrieveAllDoctors();
        }
}

</script>


<style scoped>

</style>