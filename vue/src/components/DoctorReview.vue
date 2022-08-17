<template>
    <div class="reviewRow">
        <div class="review_desc">
            <div class="reviewDate">{{review.reviewDate}}</div>
            <br />
            {{review.reviewDesc}} - <div class="signature">{{review.reviewerName}} </div>
        </div>

        <div class="commentBox">
            <p v-if="review.doctorReply">Doctor Response</p>
            <p v-if="review.doctorReply">{{review.doctorReply}} - <span class="signature">{{review.doctorName}}</span></p>
            <textarea v-if="!review.doctorReply" v-model.lazy="updatedReview.doctorReply" placeholder="Leave reply here..."></textarea><br />
            <button v-if="!review.doctorReply" class="leaveReplyButton" v-on:click="addDoctorReply(updatedReview, review.reviewId)">Submit Reply</button>
        </div>
    </div>
</template>

<script>
import ReviewsService from '../services/ReviewsService.js';

export default {
    name: "doctor-review",
    props: ['review'],
    data() {
        return {
            updatedReview: {
                reviewId: null,
                doctorReply: ''
            },
            isShown: false
        }
    },
    
  methods: {
        showReview() {
            this.isShown = !this.isShown;
        },
        addDoctorReply(updatedReview, reviewId) {
            this.updatedReview.reviewId = reviewId;
            ReviewsService.updateWithDoctorReply(updatedReview);
            setTimeout(function(){window.location.reload();},1000);
        }
    }
}
</script>


<style>
.reviewRow {
    display: grid;
    grid-template-columns: 500px 1fr;
    grid-template-areas: "description reply";
    border-bottom: solid 1px #dfddddfd;
    padding-bottom: 20px;
    width: 80%;
}
.review_desc {
    grid-area: description;
}
.commentBox {
    grid-area: reply;
    text-align: right;
}
.commentBox p {
    margin: 0;
}
.signature {
    font-style: italic;
    color: rgb(65, 65, 65);
    font-size: 16px;
}
.reviewDate {
    font-size:12px;
}
</style>