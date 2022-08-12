import axios from 'axios';

export default {

    getAllAppts(apptId) {
        return axios.get(`/appointments/${apptId}`);
    },

    getDoctorsAppt(user) {
        return axios.get(`/appointments/doctor/${user.username}`, user);
    },

    getPatientAppt(user) {
        return axios.get(`/appointments/${user.username}`, user)
    }

//   login(user) {
//     return axios.post('/login', user)
//   }

}