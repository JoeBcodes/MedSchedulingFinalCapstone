<template>

  <div id="app">
      <head>
        <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
      </head>
    <div id="header">
      <img src="../public/clearLogo.png" alt="Medical App logo" id="logo" />
      <p id="header-text"> Medical Scheduling </p>
      <img src="../public/jr-logo.jpg" alt="J R Group logo" id="jr-group" />
    </div>

  
      
    <div id="nav">
      <ul>
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
      </ul>
      <userNav v-if="$store.state.token !== ''" />
      <img src="../public/never-miss.jpg" alt="Never Miss Appt" id="never-miss" />
    </div>

    <div id="main">
      <div id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout {{this.$store.state.user.firstName}} {{this.$store.state.user.lastName}}</router-link></div>
      <router-view />
    </div>

  </div>
</template>

<script>
import userNav from '@/views/Nav.vue';

export default {
  components: {
    userNav
  },
  methods: {
  }
}

</script>

<style>
html, body, #app {
  min-height: 100vh;
  padding: 0;
  margin: 0;
}

#app {
  display: grid;
  grid-template-columns: 250px 1fr;
  grid-template-rows: 100px 1fr;
  grid-template-areas: 
  "header header"
  "nav main";
  font-family: Arial, Helvetica, sans-serif;
}

#header {
  width:100%;
  /* padding-top: 10px;
  padding-bottom: 10px; */
  background-image: linear-gradient(to right, rgba(2,48,71,0.25), rgba(2,48,71,1));
  grid-area: header;
  display: grid;
  grid-template-columns: 1fr 1fr 312.53px;
}

#header-text {
 font-family: 'Crimson Text', serif;
 
}

#logo {
  width: 90px;
  padding-left: 80px;
  padding-top: 5px;
  vertical-align: bottom;

}

#jr-group {
  height: 100px;
  text-align: right;
}

#never-miss {
  width: 247.5px;
}

#header-text {
  font-size: 40px;
  color: white;
}

#nav {
  grid-area: nav;
  border-right: solid 1px black;
  height: 100%;
}

#nav ul {
  list-style-type: none;
  font-size: 20px;
  padding:0 0 0 0;
  margin: 0;
}

#nav ul li {
  text-align: center;
}

#main {
  position: relative;
  grid-area: main;
  padding:20px;
}

#logout {
  position: absolute;
  right: 10px;
  top: 10px;
}

@media only screen and (max-width: 600px) {

  #nav {
    text-align: center;
  }

  #main {
    padding: 5px 20px;
  }

}

</style>