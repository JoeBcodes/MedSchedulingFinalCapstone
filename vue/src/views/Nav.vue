<template>
    <div id="userNav">
        <ul>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'appts'}">
                    View Appointments (D)
                </router-link>
            </li>
            <li v-if="isPatient">Navigation Link 2</li>
        </ul>
    </div>
</template>

<script>

export default {
    name: "userNav",
    data() {
        return {
            user: {
                role: ''
            }
        };
  },
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
