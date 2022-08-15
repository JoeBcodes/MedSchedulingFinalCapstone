<template>
        <div id="calendarList">
        <div class="calendar" v-for="calendar in this.$store.state.calendars" v-bind:key="calendar.calendar_id">
            {{calendar.doctorName}}
            {{calendar.dayOfTheWeek}}
            {{calendar.startTime}}
            {{calendar.endTime}}
        </div>
    </div>
</template>

<script>
import CalendarService from '../services/CalendarService.js';

export default {
    name: "patient-calendar",
    data() {
        return {
            calendars: [],
            calendar: {
                calendarId: null,
                doctorId: null,
                dayOfTheWeek: '',
                startTime: '',
                endTime: '',
            }
        }
    },
 methods: {
        retrieveCalendars() {
            CalendarService.getDoctorsCalendar(this.$store.state.user).then(response => {
                this.$store.commit("SET_CALENDAR", response.data);
                console.log(response);
            });
        }
    },
    created() {
            this.retrieveCalendars();
        }
}
</script>


<style scoped>

</style>