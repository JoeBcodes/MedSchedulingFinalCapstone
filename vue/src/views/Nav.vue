<template>
    <div id="userNav">
        <ul>
            <li v-if="isDoctor">      
                <router-link :to="{ name: 'appts'}">
                    View Appointments (D)
                </router-link> 
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'office'}">
                    Office Info (D)
                </router-link>
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'calendar'}">
                    Calendar Info (D)
                </router-link>
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'reviews'}">
                    Reviews (D)
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'appts'}">
                    View Appointments (P)
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'office'}">
                    Office Info (P)
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'reviews'}">
                    Reviews (P)
                </router-link>
            </li>
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

<style>

ul li {
    display:block;
    height:75px;
    background-color: lightsteelblue;
    border:1px grey solid;
}
ul li:hover {
    background-color: steelblue;
}
ul li a {
    text-decoration: none;
    color:white;
    display: block;
    height: 100%;
}

</style>