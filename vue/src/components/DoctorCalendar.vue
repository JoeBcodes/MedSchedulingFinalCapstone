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
                    <td>{{formattedTime(calendar.startTime)}}</td>
                    <td>{{formattedTime(calendar.endTime)}}</td>
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
            filterCal: [],
            dayArray: [
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
            ],
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
    computed: {
    
    },
    methods: {
        retrieveCalendars(doctorId) {
            CalendarService.getCalendarList(doctorId).then(response => {
                this.$store.commit("SET_CALENDAR", response.data);
                this.filteredCalendar();
            });
        },
        filteredCalendar() {
            // for (let i = 0; i == this.dayArray.length; i++) {
            //     const entry = this.$store.state.calendars.find(item => {
            //         item.dayOfTheWeek === this.dayArray[i]
            //             console.log(item);
            //     });
            // }
            this.filterCal = this.$store.state.calendars.filter(item => {
                for (let i = 0; i == this.dayArray.length; i++) {
                    console.log(item);
                    return item.dayOfTheWeek === this.dayArray[i];
                }
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
.calendar {
    background-color: rgba(255, 255, 255, 0.9);
    border-radius:20px;
    padding:20px 40px;
    width:555px;
}
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
