<template>
    <div id="apptList">
        <button v-on:click="showForm" id="bookAppt">Book New Appointment</button>
        <appt-form v-if="isShown" />

        <div class="appointment" v-for="appointment in this.$store.state.appointments" v-bind:key="appointment.appt_id">
            {{appointment.patientName}}
            {{appointment.apptDate}}
            {{appointment.apptTime}}
            {{appointment.purposeOfVisit}}
        </div>
    </div>
</template>

<script>
import ApptService from '../services/ApptService.js';
import ApptForm from '../components/ApptForm.vue';

export default {
  components: { ApptForm },
    name: "doctor-appts",
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
                console.log(response);
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
}
button#bookAppt:hover {
    background-color: lightsteelblue;
}
</style>