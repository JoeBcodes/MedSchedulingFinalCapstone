<template>
    <div>
        <doctor-appts v-if="isDoctor" />
        <patient-appts v-if="isPatient" />
    </div>
</template>

<script>
import DoctorAppts from '../components/DoctorAppts.vue';
import PatientAppts from '../components/PatientAppts.vue';

export default {
  components: { DoctorAppts, PatientAppts },
  name: "appts",
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