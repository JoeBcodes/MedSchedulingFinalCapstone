<template>
    <div>
        <office-detail />
        <doctor-office v-if="isDoctor" />
        <patient-office v-if="isPatient" />
    </div>
</template>

<script>
import DoctorOffice from '../components/DoctorOffice.vue';
import PatientOffice from '../components/PatientOffice.vue';
import OfficeDetail from '../components/OfficeDetail.vue';

export default {
  components: { DoctorOffice, PatientOffice, OfficeDetail },
  name: "office",
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