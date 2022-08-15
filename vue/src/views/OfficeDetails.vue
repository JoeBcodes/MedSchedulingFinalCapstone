<template>
    <div>
        <office-detail />
        <edit-office v-if="isDoctor" />
        <add-doctor-to-office v-if="isDoctor" />
    </div>
</template>

<script>
import OfficeDetail from '../components/OfficeDetail.vue';
import EditOffice from '../components/EditOffice.vue';
import AddDoctorToOffice from '../components/AddDoctorToOffice.vue';

export default {
  components: { OfficeDetail, EditOffice, AddDoctorToOffice},
  name: "office-details",
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