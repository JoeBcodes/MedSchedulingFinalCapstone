<template>
  <div id="app">
    <div id="header">
      <img src="../public/logo.png" alt="Medical App logo" id="logo" />
    </div>
      
    <div id="nav">
      <ul>
        <li><router-link v-bind:to="{ name: 'home' }">Home</router-link></li>
      </ul>
      <userNav v-if="$store.state.token !== ''" />
    </div>

    <div id="main">
      <div id="logout"><router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link></div>
      <router-view />
    </div>

  </div>
</template>

<script>
import userNav from '@/views/Nav.vue';

export default {
  components: {
    userNav
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
  background-color: #C8C8C8;
  grid-area: header;
}

#logo {
  height: 100%;
}

#nav {
  grid-area: nav;
  border-right: solid 1px black;
  height: 100%;
}

#nav ul {
  list-style-type: none;
  font-size: 20px;
  padding:20px 0;
}

#nav ul li {
  text-align: center;
}

#main {
  position: relative;
  grid-area: main;
  margin-left:20px;
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