<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <span>I am registering as a:</span><br />
      <input type="radio" name="role" value="DOCTOR" v-model="user.role" />
      <label class="radioLabel" for="role">Doctor</label>
      <input type="radio" name="role" value="PATIENT" v-model="user.role" />
      <label class="radioLabel" for="role">Patient</label>
      <br />
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <label for="firstName" class="sr-only">First name: </label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="FirstName"
        v-model="user.firstName"
        required
      />
      <label for="lastName" class="sr-only">Last name: </label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="LastName"
        v-model="user.lastName"
        required
      />
      <label for="phone" class="sr-only">Phone #: </label>
      <input
        type="text"
        id="phone"
        class="form-control"
        placeholder="Phone"
        v-model="user.phone"
        required
      />
      <label for="email" class="sr-only">Email: </label>
      <input
        type="text"
        id="email"
        class="form-control"
        placeholder="Email"
        v-model="user.email"
        required
      />
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>

      <router-link :to="{ name: 'login' }">Have an account?</router-link>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: '',
        firstName: '',
        lastName: '',
        phone: '',
        email: ''
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
input {
  display: block;
  margin-bottom:10px;
}
input[type="radio"] {
  display: inline;
}
.form-register button {
  display: block;
  margin-bottom:10px;
}
.radioLabel {
  display: inline;
}
</style>
