<template>
    <div id="apptList">
        <h2>My Appointments</h2>
        
        <h3>Upcoming Appointments</h3>
        <div class="appointment">
        <table id="apptTable">    
            <tr>
                <th>Patient Name</th>
                <th>Date &amp; Time</th>
                <th>Purpose of Visit</th>
                <th></th>
            </tr>
            <tr v-for="appointment in upcomingAppointments" v-bind:key="appointment.appt_id">
                <td>{{appointment.patientName}}</td>
                <td>{{appointment.apptDate}} @ {{appointment.apptTime}}</td>
                <td>{{appointment.purposeOfVisit}}</td>
                <td class="buttonColumn"><button v-if="appointment.read === false">Mark as Seen</button></td>
            </tr>
        </table>
        </div>

        <h3>Past Appointments</h3>
        <div class="appointment">
        <table id="apptTable">    
            <tr>
                <th>Patient Name</th>
                <th>Date &amp; Time</th>
                <th>Purpose of Visit</th>
                <th></th>
            </tr>
            <tr v-for="appointment in pastAppointments" v-bind:key="appointment.appt_id">
                <td>{{appointment.patientName}}</td>
                <td>{{appointment.apptDate}} @ {{appointment.apptTime}}</td>
                <td>{{appointment.purposeOfVisit}}</td>
                <td class="buttonColumn"><button v-if="appointment.read === false">Mark as Seen</button></td>
            </tr>
        </table>
        </div>
        
    </div>
</template>

<script>
import ApptService from '../services/ApptService.js';

export default {
    name: "doctor-appts",
    data() {
        return {
            date: new Date(),
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
    methods: {
        retrieveAppts() {
            ApptService.getDoctorsAppt(this.$store.state.user).then(response => {
                this.$store.commit("SET_APPTS", response.data);
            });
            const today = this.date.toISOString().split('T')[0];
            this.upcomingAppointments = this.$store.state.appointments.filter(appointment => {
                return today >= appointment;
            });
        }
    },
    created() {
            this.retrieveAppts();
    }
}
</script>


<style>
#apptTable {
    text-align: left;
    border-collapse: collapse;
    width:80%;
}
#apptTable td, th {
    padding:10px 50px 10px 5px;
    border:none;
}
.buttonColumn {
    width: 200px;
    text-align: right;
}
#apptTable tr:nth-child(even) {
    background-color: #f1f1f1d8;
}
</style>
