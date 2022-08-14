import axios from 'axios';

// const http = axios.create({
//     baseURL: "http:localhost:9000"
// });

export default {
    getAllOffices() {
        return axios.get(`/office`);
    },

    getOfficeInfoById(officeId) {
        return axios.get(`/office/${officeId}`);
    },

    updateOfficeInfo(SOMETHINGOFFICE) {
        return axios.put(``)
    },



    addDoctorToOffice(officeId, doctorId) {
        return axios.post(`/${officeId}/update/add-doctor`, doctorId);
    },

    removeDoctorFromOffice(officeId) {
        return axios.delete(`/${officeId}/update/remove-doctor`, doctorId);

        
    //removeDoctorFromOffice(officeId, doctorId) {
       // return axios.delete(`/${officeId}/update/remove-doctor/${doctorId}`); possible change?
    }
}