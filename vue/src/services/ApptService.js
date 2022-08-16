import axios from 'axios';

export default {

    getAllAppts(apptId) {
        return axios.get(`/appointments/${apptId}`);
    },

    getDoctorsAppt(user) {
        return axios.get(`/appointments/doctor/${user.username}`);
    },

    getPatientAppt(user) {
        return axios.get(`/appointments/patient-booked/${user.username}`, user);
    },

    getApptsByDoctorAndDate(doctorId, date) {
        return axios.get(`/appointments/doctor/${doctorId}/date/${date}`);
    },

    createAppt(appointment) {
        return axios.post(`appointments/new-appointment`, appointment);
    },

    updateReadStatus(apptId) {
        return axios.put(`appointments/${apptId}/mark-read`);
    }

}