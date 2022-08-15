<template>
    <div>
        <doctor-calendar v-if="isDoctor" />
    </div>
</template>

<script>
import DoctorCalendar from '../components/DoctorCalendar.vue';
//import PatientCalendar from '../components/PatientCalendar.vue';

export default {
  components: { DoctorCalendar},
  name: "calendar",
  computed: {
      isDoctor() {
        return this.$store.state.user.role === 'DOCTOR';
      }
      // isPatient() {
      //     return this.$store.state.user.role === 'PATIENT';
      // }
  }
};
</script>