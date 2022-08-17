<template>
  <div class="home">
    <h1>Welcome {{this.$store.state.user.role === 'DOCTOR' ? 'Dr.' : ''}} 
      {{this.$store.state.user.firstName}}  
      {{this.$store.state.user.lastName}}
    </h1>
    
    <img src="../../public/clearLogo.png" alt="Medical App Logo" id="logo-clear" />
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
#logo-clear {
  width: 50%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  opacity: 0.5;
}

/* .home {
  width: 100%;
  max-height: 100%;
} */
</style>