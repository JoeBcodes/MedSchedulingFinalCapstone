<template>
    <div id="userNav">
        <ul>
            <li v-if="isDoctor">      
                <router-link :to="{ name: 'appts'}">
                    View Appointments 
                </router-link> 
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'office'}">
                    Office Info 
                </router-link>
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'calendar'}">
                    Calendar Info 
                </router-link>
            </li>
            <li v-if="isDoctor">
                <router-link :to="{ name: 'reviews'}">
                    Reviews 
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'appts'}">
                    View Appointments 
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'office'}">
                    Office Info 
                </router-link>
            </li>
            <li v-if="isPatient">
                <router-link :to="{ name: 'reviews'}">
                    Doctors 
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
    height:75px;
    background-color: #8ecae6;
    border:20px;
    margin: 1px;
}

ul li:hover {
    background-color: steelblue;
}

ul li a {
    display: inline-block;
    text-decoration: none;
    color:white;
    padding:27px 0px;
    width: 100%; 
    position:relative;
    z-index: 1;
    transition: all .5s;
}


ul li a:hover {
  color: #023047;
  z-index: 1;
}

ul li a:after {
  display: block;
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  right: 0;
  margin: auto;
  width: 100%;
  height: 1px;
  content: '.';
  color: transparent;
  background: #219ebc;
  visibility: none;
  opacity: 0;
  z-index: -1;
}

ul li a:hover:after {
  opacity: 1;
  visibility: visible;
  height: 100%;
  z-index: -10;
  animation: fill 1s forwards;
  -webkit-animation: fill .5s forwards;
  -moz-animation: fill .5s forwards;

}




</style>