<template>
    <div id="doctorList">
        <p id="textline"> Please use the dropdown menu below to see a list of our doctors and read their reviews</p>
        <select v-model="selectedDoctor" v-on:change="retrieveReviews(selectedDoctor)">
        
            <option value="0">-Please select a doctor-</option>
            <option v-for="doctor in doctors" v-bind:key="doctor.doctorId" v-bind:value="doctor.doctorId">{{doctor.doctorName}}</option>
        </select>
            
        <div class="individualReview" v-for="review in reviews" v-bind:key="review.reviewId">
            <p class="review_desc">"{{review.reviewDesc}}"</p>
            <p class="signature">{{review.reviewerName}} <br />
                <span class="reviewDate">{{review.reviewDate}}</span>    
            </p>
            <div class="doctorReply">
            <p v-if="review.doctorReply">Doctor's Reply</p>
            <p v-if="review.doctorReply" class="review_desc">"{{review.doctorReply}}"</p>
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


<style>
#textline {
    font-weight: bold;
}

.individualReview {
    display: block;
    width: 400px;
    background-color: #e0e0e0d8;
    padding: 20px 40px;
    margin: 20px 0;
    border-radius: 20px;
}
.review_desc {
    font-size: 20px;
}
.doctorReply {
    text-align: right;
}
.doctorReply p {
    margin:0;
    margin-bottom: 5px;
}
</style>