<template>
    <div>
        <office-detail />
        <edit-office v-if="isDoctor" />
    </div>
</template>

<script>
import OfficeDetail from '../components/OfficeDetail.vue';
import EditOffice from '../components/EditOffice.vue';

export default {
  components: { OfficeDetail, EditOffice },
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