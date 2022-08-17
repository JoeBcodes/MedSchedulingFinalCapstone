<template>
    <div id="apptList">
        <button v-on:click="showForm" id="bookAppt">Book New Appointment</button>
        <div class="patientApptWrap">
            <appt-form v-if="isShown" />
            <h2>Upcoming Appointments</h2>
            <table class="apptTable">    
                <tr>
                    <th>Date &amp; Time</th>
                    <th>Doctor Name</th>
                    <th>Purpose of Visit</th>
                </tr>
                <tr v-for="appointment in upcomingAppointments" v-bind:key="appointment.appt_id">
                    <td>{{appointment.apptDate}}<br />{{formattedTime(appointment.apptTime)}}</td>
                    <td>{{appointment.doctorName}}</td>
                    <td>{{appointment.purposeOfVisit}}</td>
                </tr>
            </table>
        </div>
        <div class="patientApptWrap1" v-if="pastAppointments.length > 0">
        <h2>Past Appointments</h2>
        <table class="apptTable">    
            <tr>
                <th>Date &amp; Time</th>
                <th>Doctor Name</th>
                <th>Purpose of Visit</th>
            </tr>
            <tr v-for="appointment in pastAppointments" v-bind:key="appointment.appt_id">
                <td>{{appointment.apptDate}} @ {{appointment.apptTime}}</td>
                <td>{{appointment.doctorName}}</td>
                <td>{{appointment.purposeOfVisit}}</td>
            </tr>
        </table>
        </div>
    </div>
</template>

<script>
import ApptService from '../services/ApptService.js';
import ApptForm from '../components/ApptForm.vue';

export default {
  components: { ApptForm },
    name: "patient-appts",
    data() {
        return {
            appointments: [],
            appointment: {},
            isShown: false,
            date: new Date()
        }
    },
    methods: {
        retrieveAppts() {
            ApptService.getPatientAppt(this.$store.state.user).then(response => {
                this.$store.commit("SET_APPTS", response.data);
            });
        },
        showForm() {
            this.isShown = !this.isShown;
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
        }
    },
    computed: {
        pastAppointments() {
            return this.$store.state.appointments.filter(appointment => {
                const appointmentDate = new Date(appointment.apptDate + ' ' + appointment.apptTime);
                return this.date >= appointmentDate;
            });
        },
        upcomingAppointments() {
            return this.$store.state.appointments.filter(appointment => {
                const appointmentDate = new Date(appointment.apptDate + ' ' + appointment.apptTime);
                return this.date <= appointmentDate;
            });
        }
    },
    created() {
            this.retrieveAppts();
    }
}
</script>

<style>
.patientApptWrap {
    background-color: rgba(255, 255, 255, 0.9);
    border-radius:20px;
    padding:20px 40px;
    margin-bottom:20px;
    width: 90%;
}
.patientApptWrap1 {
    background-color: rgba(223, 223, 223, 0.9);
    border-radius:20px;
    padding:20px 40px;
    width:90%;
}
.apptList {
    margin:20px;
}
.apptTable {
    border-collapse: collapse;
    width:100%;
}
.apptTable th {
    text-align: left;
}
.apptTable td{
    padding:20px;
}
button#bookAppt {
    padding: 10px;
    font-size: 16px;
    border-color: #89ABFD;
    margin-bottom: 30px;
}
button#bookAppt:hover {
    background-color: lightsteelblue;
}
</style>