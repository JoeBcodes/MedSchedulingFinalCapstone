<template>

<!--print out list of drs in Office-->

    <div id="officeDetailsList">
        <div class="office-details">
            <h2>{{office.name}}</h2>
            <p>{{office.address}}</p>
            <p>{{office.phone}}</p>
            <p>{{office.email}}</p>
            <p>Hours: {{formattedTime(office.startHours)}} - {{formattedTime(office.endHours)}}</p>
            <p>We specialize in {{office.specialty}} services<p>
            <p>Our appointment rates is ${{office.hourlyRate}}/hr</p>
        </div>
    </div>
</template>

<script>
import OfficeService from '../services/OfficeService.js';

export default {
    data() {
        return {
            offices: []
        }
    },
    name: "office-detail",
    methods: {
        retrieveOfficeDetails() {
            OfficeService.getOfficeInfoById(1).then(response => {
                this.$store.commit("SET_OFFICE", response.data);
                console.log(response);
            });
        },
        formattedTime(time) {
            const fmtTime = time.split(':'); 

            // fetch
            var hours = Number(fmtTime[0]);
            var minutes = Number(fmtTime[1]);

            let timeValue;

            if (hours > 0 && hours <= 12) {
            timeValue= "" + hours;
            } else if (hours > 12) {
            timeValue= "" + (hours - 12);
            } else if (hours == 0) {
            timeValue= "12";
            }
            
            timeValue += (minutes < 10) ? ":0" + minutes : ":" + minutes;  // get minutes
            timeValue += (hours >= 12) ? " P.M." : " A.M.";  // get AM/PM

            return timeValue;
        },
        getOffices() {
        OfficeService.getAllOffices().then(response => {
                this.offices = response.data;
                console.log(this.offices);
            })
        }
    },

    //list of all drs in this office
    //reviews
    computed: {
        office() { return this.$store.state.office }
    },
    created() {
            this.retrieveOfficeDetails();
            this.getOffices();
    }
}
</script>

<style>
.office-details {
    border-radius: 20px;
    background-color: #f1f1f1d8;
    padding: 10px 30px;
    margin-bottom: 20px;
    width:300px;
}
</style>