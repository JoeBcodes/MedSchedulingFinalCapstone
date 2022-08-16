<template>
    <div id="apptList">
        <button v-on:click="showForm" id="bookAppt">Book New Appointment</button>
        <appt-form v-if="isShown" />
        <table id="apptTable">    
            <tr>
                <th>Date &amp; Time</th>
                <th>Doctor Name</th>
                <th>Purpose of Visit</th>
                <!-- <th></th> -->
            </tr>
            <tr v-for="appointment in this.$store.state.appointments" v-bind:key="appointment.appt_id">
                <td>{{appointment.apptDate}} @ {{appointment.apptTime}}</td>
                <td>{{appointment.doctorName}}</td>
                <td>{{appointment.purposeOfVisit}}</td>
                <!-- <td class="buttonColumn"><button v-if="appointment.read === false">Mark as Seen</button></td> -->
            </tr>
        </table>
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
            isShown: false
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
        }
    },
    created() {
            this.retrieveAppts();
    }
}
</script>

<style>

#apptList {
    margin:20px;
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