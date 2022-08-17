<template>
    <div id="apptList">
        <h2>My Appointments</h2>
        
        <div id="apptListWrap">
            <h3>Upcoming Appointments</h3>
            <div class="appointment">
            <table class="apptTable">    
                <tr>
                    <th>Patient Name</th>
                    <th>Date &amp; Time</th>
                    <th>Purpose of Visit</th>
                    <th></th>
                </tr>
                <tr v-for="appointment in upcomingAppointments" v-bind:key="appointment.appt_id" :class="{ 'notRead' : !appointment.read}">
                    <td>{{appointment.patientName}}</td>
                    <td>{{appointment.apptDate}} @ {{formattedTime(appointment.apptTime)}}</td>
                    <td>{{appointment.purposeOfVisit}}</td>
                    <td class="buttonColumn"><button v-if="appointment.read === false" v-on:click="markAsRead(appointment.apptId)">Mark as Seen</button></td>
                </tr>
            </table>
            </div>
        </div>
        <div id="apptListWrap1" v-if="pastAppointments.length > 0">
            <h3>Past Appointments</h3>
            <div class="appointment">
            <table class="apptTable">    
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
                    <td class="buttonColumn"></td>
                </tr>
            </table>
            </div>
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
        },
        markAsRead(appointmentId) {
            ApptService.updateReadStatus(appointmentId).then(response => {
                if(response.status === 200) {
                    this.retrieveAppts();
                }
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
        }
    },
    created() {
            this.retrieveAppts();
    }
}
</script>


<style>
#apptListWrap {
    background-color: rgba(255, 255, 255, 0.9);
    padding:20px;
    margin-bottom:20px;
    border-radius: 20px;
    width:80%;
}
#apptListWrap1 {
    background-color: rgba(223, 223, 223, 0.9);
    padding:20px;
    margin-bottom:20px;
    border-radius: 20px;
    width:80%;
}
.apptTable {
    text-align: left;
    border-collapse: collapse;
    width:100%;
}
.apptTable td, th {
    padding:10px 50px 10px 5px;
    border:none;
}
.buttonColumn {
    width: 200px;
    text-align: right;
}
tr:nth-child(even) {
    background-color: #f1f1f1d8;
}
tr.notRead {
    background-color: lemonchiffon;
    font-weight:bold;
    border:1px solid rgb(255, 255, 255);
}
tr.notRead:hover {
    background-color: rgb(255, 247, 176);
}
</style>
