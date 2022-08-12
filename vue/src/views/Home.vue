<template>
  <div class="home">
    <h1>Home - Welcome Dr. {{this.$store.state.user.lastName}}</h1>
    <p>You must be authenticated to see this</p>
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>
