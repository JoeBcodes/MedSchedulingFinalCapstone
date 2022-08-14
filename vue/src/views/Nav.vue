<template>
    <div id="userNav">
        <ul>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'appts'}">View Appointments (D)</router-link>
            </li>
            <li v-if="isPatient">Navigation Link 2</li>


            <router-link :to="{ name: 'calendar'}">Calendar</router-link>
            <router-link :to="{ name: 'office'}">Office</router-link>
            <router-link :to="{ name: 'reviews'}">Reviews</router-link>

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
