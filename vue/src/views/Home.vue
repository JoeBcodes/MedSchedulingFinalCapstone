<template>
  <div class="home">
    <h1>Home - Welcome {{this.$store.state.user.role === 'DOCTOR' ? 'Dr.' : ''}} 
      {{this.$store.state.user.firstName}}  
      {{this.$store.state.user.lastName}}
    </h1>
    <p>You must be authenticated to see this</p>
    <img src="../../public/page.png" alt="Medical App Page" id="page" />
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style>
#page {
  width: 100%;
}
</style>