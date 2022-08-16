<template>
  <div class="home">
    <h1>Welcome {{this.$store.state.user.role === 'DOCTOR' ? 'Dr.' : ''}} 
      {{this.$store.state.user.firstName}}  
      {{this.$store.state.user.lastName}}
    </h1>
    
    <img src="../../public/clearLogo.png" alt="Medical App Logo" id="logoclear" />
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
#page {
  max-width: 100%;
}

/* .home {
  width: 100%;
  max-height: 100%;
} */
</style>