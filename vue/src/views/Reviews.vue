<template>
    <div>
        <doctor-reviews v-if="isDoctor" />
        <patient-reviews v-if="isPatient" />
    </div>
</template>

<script>
import DoctorReviews from '../components/DoctorReviews.vue';
import PatientReviews from '../components/PatientReviews.vue';

export default {
  components: { DoctorReviews, PatientReviews },
  name: "reviews",
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