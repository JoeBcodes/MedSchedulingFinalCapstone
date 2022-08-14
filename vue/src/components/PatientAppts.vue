<template>
     <div id="apptList">
        <div class="appointment" v-for="appointment in this.$store.state.appointments" v-bind:key="appointment.appt_id">
            {{appointment.doctorName}}
            {{appointment.apptDate}}
            {{appointment.apptTime}}
             {{appointment.purposeOfVisit}}
             {{appointment.isAvailable}}
        </div>
    </div>
</template>

<script>
import ApptService from '../services/ApptService.js';

export default {
    name: "patient-appts",
    data() {
        return {
            appointments: [],
            appointment: {
                //added doctorId:
                //added isAvailable:
                apptId: null,
                doctorId: null,
                patientId: null,
                apptDate: '',
                apptTime: '',
                 isRead: null,
                 isAvailable: null,
                purpose: '',
                doctorName: '',
                patientName: ''
                
            }
        }
    },
  methods: {
        retrieveAppts() {
            ApptService.getDoctorsAppt(this.$store.state.user).then(response => {
                this.$store.commit("SET_APPTS", response.data);
                console.log(response);
            });
        }
    },
    created() {
            this.retrieveAppts();
        }
}
</script>

<style scoped>

</style>