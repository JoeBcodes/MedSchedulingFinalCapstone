<template>
    <div id="userNav">
        <ul>
            <li v-if="isDoctor">Navigation Link 1</li>
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
      userRole() {
          return 'patient';
      },

      isDoctor() {
        return this.userRole === 'doctor';
      },

      isPatient() {
          return this.userRole === 'patient';
      }
  }
};
</script>
