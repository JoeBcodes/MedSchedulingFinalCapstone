@import url("https://fonts.googleapis.com/css?family=Montserrat&display=swap");
<template>
  <div class="home">
    <head>
        <link href="https://fonts.googleapis.com/css?family=Crimson+Text|Work+Sans:400,700" rel="stylesheet">
      </head>
    <h1 id="welcome">
      <span class="1">Welcome </span>
      <span class="1">{{this.$store.state.user.role === 'DOCTOR' ? 'Dr.' : ''}} </span>
      <span class="1">{{this.$store.state.user.firstName}} </span>
      <span class="1">{{this.$store.state.user.lastName}} </span>
    </h1>
    
    <!-- <img src="../../public/clearLogo.png" alt="Medical App Logo" id="logo-clear" /> -->
  </div>
</template>

<script>
export default {
  name: "home"
};
</script>

<style scoped>
#logo-clear {
  width: 50%;
  display: block;
  margin-left: auto;
  margin-right: auto;
  opacity: .8;
}

.home {
  font-family: 'Crimson Text', serif;
}

h1 #welcome{
  font-size: 50px;
  padding-left: 40px;
  transform: scale(0.94);
  animation: scale 3s forwards cubic-bezier(0.5, 1, 0.89, 1);
}

@keyframes scale {
  100% {
    transform: scale(1);
  }
}

span  {
   font-size: 44px;
  display: inline-block;
  opacity: 0;
  filter: blur(4px);
  white-space: pre-wrap;
  
}

span:nth-child(1) {
  padding-left: 40px;
  animation: fade-in 0.8s 0.1s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(2) {
  animation: fade-in 0.8s 0.2s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(3) {
  animation: fade-in 0.8s 0.3s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

span:nth-child(4) {
  animation: fade-in 0.8s 0.4s forwards cubic-bezier(0.11, 0, 0.5, 0);
}

@keyframes fade-in {
  100% {
    opacity: 1;
    filter: blur(0);
  }
}

</style>