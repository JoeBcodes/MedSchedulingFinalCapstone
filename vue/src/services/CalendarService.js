import axios from 'axios';

export default {

  getCalendarList(doctorId) {
    return axios.get(`/calendar/${doctorId}`);
  },

  updateCalendar(calendar) {
    return axios.put(`/calendar`, calendar);
  },

  createCalendar(calendar) {
    return axios.post(`/calendar`, calendar);
  },

  deleteCalendar(calendarId) {
    return axios.delete(`/calendar/${calendarId}/delete`);
  }
}

