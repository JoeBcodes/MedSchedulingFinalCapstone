<template>
    <div>
        <doctor-calendar v-if="isDoctor" />
        <patient-calendar v-if="isPatient" />
    </div>
</template>

<script>
import DoctorCalendar from '../components/DoctorCalendar.vue';
import PatientCalendar from '../components/PatientCalendar.vue';

export default {
  components: { DoctorCalendar, PatientCalendar },
  name: "calendar",
  computed: {
      isDoctor() {
        return this.$store.state.user.role === 'DOCTOR';
      },

      isPatient() {
          return this.$store.state.user.role === 'PATIENT';
      }
  }
};
</script>