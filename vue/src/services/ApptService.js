import axios from 'axios';

export default {

    getAllAppts(apptId) {
        return axios.get(`/appointments/${apptId}`);
    },

    getDoctorsAppt(user) {
        return axios.get(`/appointments/doctor/${user.username}`);
    },

    getPatientAppt(user) {
        return axios.get(`/appointments/patient/${user.username}`, user);
    },

    createAppt(appointment) {
        return axios.post(`/new-appointment`, appointment);
    }

}