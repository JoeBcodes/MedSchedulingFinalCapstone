<template>
    <div id="calendarList">
        <div class="calendar">
            <h2>Current Schedule</h2>
            <table id="availCalendar">
                <tr>
                    <th>Day of the week</th>
                    <th>Start Time</th>
                    <th>End Time</th>
                    <th>Remove</th>
                </tr>
                <tr v-for="calendar in this.$store.state.calendars" v-bind:key="calendar.calendar_id">
                    <td>{{calendar.dayOfTheWeek}}</td>
                    <td>{{calendar.startTime}}</td>
                    <td>{{calendar.endTime}}</td>
                    <td class="deleteBtn"><a href="" v-on:click="deleteCalendarEntry(calendar.calendarId)"><img src="../../public/pill_delete.png" /></a></td>
                </tr>
            </table>
        </div>
        <h2>Add available hours by day</h2>
        <form>
            <div class="calendarFormItem">
            <label>Day of the Week:</label>
            <select v-model="calendar.dayOfTheWeek">
                <option value="0">- Please select a day -</option>
                <option>Sunday</option>
                <option>Monday</option>
                <option>Tuesday</option>
                <option>Wednesday</option>
                <option>Thursday</option>
                <option>Friday</option>
                <option>Saturday</option>
            </select>
            </div>
            <div class="calendarFormItem">
            <label>Start Time:</label>
            <input type="time" v-model="calendar.startTime" />
            </div>
            <div class="calendarFormItem">
            <label>End Time:</label>
            <input type="time" v-model="calendar.endTime" />
            </div>
            <input id="subBtn" type="submit" value="Enter Times" v-on:click.prevent="addCalendarItem" />
        </form>
    </div>
</template>

<script>
import CalendarService from '../services/CalendarService.js';

export default {
    name: "doctor-calendar",
    data() {
        return {
            calendars: [],
            calendar: {
                doctorId: null,
                dayOfTheWeek: '0',
                startTime: '08:00',
                endTime: '17:00',
            },
            arrayOfDays: {
                sunday: 1,
                monday: 2,
                tuesday: 3,
                wednesday: 4, 
                thursday: 5, 
                friday: 6,
                saturday: 7
            }
        }
    },
 methods: {
        retrieveCalendars(doctorId) {
            CalendarService.getCalendarList(doctorId).then(response => {
                this.$store.commit("SET_CALENDAR", response.data);
                console.log(response);
            });
        },
        addCalendarItem() {
            this.calendar.doctorId = this.$store.state.user.userId;
            this.calendar.startTime = this.calendar.startTime + ":00";
            this.calendar.endTime = this.calendar.endTime + ":00";
            CalendarService.createCalendar(this.calendar).then(response => {
                if (response.status === 200) {
                    this.retrieveCalendars(this.$store.state.user.userId);
                    this.calendar.dayOfTheWeek = '0';
                    this.calendar.startTime = '';
                    this.calendar.endTime = '';
                }
            });

        },
        deleteCalendarEntry(reviewId) {
            CalendarService.deleteCalendar(reviewId);
        }
        // sortCalendarList(listOfDays) {
        //     for(i = 0; i < arrayOfDays.length; i++) {
        //     if(this.arrayOfDays.listOfDays[i] > this.arrayOfDays.listOfDays[i + 1] ) {

        //     }
        

    },
    created() {
            this.retrieveCalendars(this.$store.state.user.userId);
        }
}
</script>


<style scoped>
#availCalendar {
    border-collapse: collapse;
}
#availCalendar td {
    padding:10px;
}
.calendarFormItem {
    display: inline-block;
    margin:0 20px;
}
input {
    font-size:20px;
}
#subBtn {
    margin: 20px;
}
.deleteBtn {
    text-align: center;
    vertical-align: middle;
    width:30px;
    height: 30px;
}
.deleteBtn a {
    display: inline-block;
    width: 30px;
    height: 100%;
    vertical-align: middle;
}
.deleteBtn a:hover {
    background: rgba(240, 128, 128, 0.534);
}
.deleteBtn img {
    width: 20px;
    vertical-align: middle;
}
</style>
