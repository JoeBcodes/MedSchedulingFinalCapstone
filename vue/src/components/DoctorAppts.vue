<template>
    <div id="apptList">
        <div class="appointment" v-for="appointment in this.$store.state.appointments" v-bind:key="appointment.appt_id">
            {{appointment.patientName}}
            {{appointment.apptDate}}
            {{appointment.apptTime}}
            {{appointment.purposeOfVisit}}
             {{appointment.isRead}}
             {{appointment.isAvailable}}
        </div>
    </div>
</template>

<script>
import ApptService from '../services/ApptService.js';

export default {
    name: "doctor-appts",
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
                // this.appointment.apptId = response.data.apptId;
                // this.appointment.patientId = response.data.patientId;
                // this.appointment.apptDate = response.data.apptDate;
                // this.appointment.apptTime = response.data.apptTime;
                // this.appointment.purpose = response.data.purposeOfVisit;
                // this.appointment.doctorName = response.data.doctorName;
                // this.appointment.patientName = response.data.patientName;
                // this.appointment.isRead = response.data.read;
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
