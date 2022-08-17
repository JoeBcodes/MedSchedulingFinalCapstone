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

    updateOfficeInfo(office) {
        console.log(office);
        return axios.put(`office/${office.officeId}/update`, office);
    },

    addDoctorToOffice(officeId, doctorId) {
        return axios.post(`office/${officeId}/update/add-doctor/${doctorId}`);
    },

    removeDoctorFromOffice(officeId, doctorId) {
        return axios.delete(`/${officeId}/update/remove-doctor`, doctorId);

    },

    updateOfficeForDoctor(officeId, doctorId) {
        return axios.put(`/office/${officeId}/update/update-doctor-office/${doctorId}`);
    },
    
    getOfficeByDoctorId(doctorId) {
        return axios.get(`/office/doctor/${doctorId}`);
    }
    //removeDoctorFromOffice(officeId, doctorId) {
       // return axios.delete(`/${officeId}/update/remove-doctor/${doctorId}`); possible change?
    //}
}