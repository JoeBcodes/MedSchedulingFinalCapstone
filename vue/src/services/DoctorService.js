import axios from 'axios';

// const http = axios.create({
//     baseURL: "http:localhost:9000"
// });

export default {
    listAllDoctors() {
        return axios.get(`/doctors`);
    },

    listAllDoctorsByOfficeId(officeId) {
        return axios.get(`/doctors/${officeId}`);
    }
}