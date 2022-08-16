<template>
    <div id="form_container">
            <div class="form_item">
            <label>Choose Office: </label>
            <select v-model="selectedOfficeId" v-on:change="getDoctorList()">
                <option selected="selected" value="0">- Please Select -</option>
                <option name="apptOffice" v-for="office in offices" v-bind:key="office.officeId" v-bind:value="office.officeId">{{office.name}}</option>
            </select>
            </div>

            <div class="form_item">
            <label>Select Doctor: </label>
            <select name="apptDoctor" v-model="appointment.doctorId" v-on:change="getDoctorSchedule(appointment.doctorId)">
                <option selected="selected" value="0">- Please Select -</option>
                <option v-if="!doctors.length" selected="selected" value="0">Please select an office first</option>
                <option v-for="doctor in doctors" v-bind:key="doctor.doctorId" v-bind:value="doctor.doctorId">{{doctor.doctorName}}</option>
            </select>
            </div>

            <div class="form_item">
            <label>Select Appointment Day: </label>
            <vc-date-picker mode="date" :min-date='new Date()' :disabled-dates='{ weekdays: this.availableDaysFilter }' v-model="date" />
            </div>

            <div class="form_item">
            <label>Pick a time: </label>
            <select v-model="appointment.apptTime">
                <option selected="selected" value="">Pick a Time Slot</option>
                <option v-for="time in availableTimes" v-bind:key="time" v-bind:value="time">{{formattedTime(time)}}</option>
            </select>
            </div>

            <div class="form_item">
            <label>Please describe the reason for the visit: </label>
            <textarea v-model="appointment.purposeOfVisit"></textarea>
            </div>

            <input type="submit" name="Book Appointment" @click="bookAppointment" />
    </div>
</template>

<script>
import OfficeService from '../services/OfficeService.js';
import DoctorService from '../services/DoctorService.js';
import ApptService from '../services/ApptService.js';

export default {
    name: 'appt-form',
    data() {
    return {
      date: new Date(),
      times: [],
      offices: [],
      selectedOfficeId: 0,
      doctors: [],
      selectedDoctorId: 0,
      appointment: {
        doctorId: 0,
        patientId: 0,
        apptDate: new Date(),
        apptTime: '',
        purposeOfVisit: '',
        read: false,
        available: false
      },
      availableDays: [],
      bookedApptsByDate: [],
      daysOfTheWeek: [1,2,3,4,5,6,7],
      doctorStartTime: '09:00:00',
      doctorEndTime: '17:00:00',
      apptTimesTaken: []
    }
  },
  
  computed: {
    availableTimes() {
      if(!this.doctorStartTime || !this.doctorEndTime) {
        return []
      }

      return this.times.filter((time) => {
         return this.doctorStartTime <= time &&
                this.doctorEndTime >= time &&
                !this.apptTimesTaken.includes(time);
      });
    },
    availableDaysFilter() {
        const DayKey = {
            'Sunday' : 1,
            'Monday' : 2,
            'Tuesday' : 3,
            'Wednesday' : 4,
            'Thursday' : 5,
            'Friday' : 6,
            'Saturday' : 7,
        }
        const returnedArray = this.availableDays.map((day) => {
            return DayKey[day.dayOfTheWeek];
        });

        return this.daysOfTheWeek.filter((day) => {
            return !returnedArray.includes(day);
        });
    }
  },
  methods: {
      bookAppointment() {
        this.appointment.apptDate = this.appointment.apptDate.toISOString().split('T')[0];
        this.appointment.patientId = this.$store.state.user.userId;
        ApptService.createAppt(this.appointment);
        location.reload(true);




        //   {
        //   // ...this.appointment,
        //   // date: this.appointment.apptDate.toISOString().split('T')[0]
        // });
      },
      getOfficeList() {
          OfficeService.getAllOffices().then(response => {
                this.offices = response.data;
            });
      },
      getDoctorList() {
          //const officeId = event.target.value;
          DoctorService.listAllDoctorsByOfficeId(this.selectedOfficeId).then(response => {
              this.doctors = response.data;
          });
      },
      getDoctorSchedule(doctorId) {
          DoctorService.getScheduleForDoctor(doctorId).then(response => {
              this.availableDays = response.data;
          });
      },
      getTimesForDayOfTheWeek() {
          this.appointment.apptDate = this.date;
          this.getApptsbyDate();
          const dayFilter = this.appointment.apptDate.toLocaleDateString("en", { weekday: 'long'});
          this.availableDays.forEach(days => {
              if (dayFilter === days.dayOfTheWeek) {
                  this.doctorStartTime = days.startTime;
                  this.doctorEndTime = days.endTime;
              }
          });
      },
      getApptsbyDate() {
          const offset = this.appointment.apptDate.getTimezoneOffset()
          const newDate = new Date(this.appointment.apptDate.getTime() - (offset*60*1000))
          const finalDate = newDate.toISOString().split('T')[0];
          ApptService.getApptsByDoctorAndDate(this.appointment.doctorId, finalDate).then(response => {
              this.bookedApptsByDate = response.data
              this.bookedApptsByDate.forEach(time => {
              console.log(time);
              this.apptTimesTaken.push(time.apptTime);
          });
          });
      },
    formattedTime(time) {
        const fmtTime = time.split(':'); 

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
    }

  },
  watch: {
    office() {
       // this.doctor = null;
       // this.selectedDate = null;
       // this.time = null;
     },
    doctor() {
       // this.selectedDate = null;
       // this.time = null;
       /*
         fetch.stuff.then((response) => {
           this.doctorStartTime = response.data.doctorStartTime;
           this.doctorEndTime = response.data.doctorEndTime;
         })
       */
    },
    date(newDate) {
         this.getTimesForDayOfTheWeek();
         return newDate;
       // this.time = null
       /*
         fetch.stuff.then((response) => {
           this.appts = response.data.appts;
         })
       */
     }
  },
  
  created() {
    this.getOfficeList();
    const times = []
    let counter = 0
    while(counter < 24) {
      times.push(`${counter < 10 ? "0" + counter : counter}:00:00`)
      times.push(`${counter < 10 ? "0" + counter : counter}:30:00`)
      counter += 1
    }
    
    this.times = times;
  }
}
</script>

<style>

label {
    display: block;
}
textarea {
    width:300px;
    height: 50px;
    font-size: 20px;
}
.form_item {
    width:300px;
    border-radius: 10px;
    border:1px #89ABFD solid;
    background-color: #f2f2f2;
    margin: 10px 0;
    padding: 10px 40px 20px 40px;
    font-size: 20px;
}
select {
    font-size: 20px;
    padding:10px;
}
select option {
    height: 30px;
    padding: 10px;
    margin:10px;
}
</style>