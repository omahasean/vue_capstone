<template>
  <div id="register" class="text-center">
    <div class="backgroundimage">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Create An Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        There were problems registering this user.
      </div>
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
      <router-link :to="{ name: 'login' }">
        Have an account?
      </router-link>
      <button class="createbutton" type="submit">
        Create Account
      </button>
    </form>
  </div>
  </div>
</template>

<script>
export default {
  name: 'register',
  
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
    };
  },
  methods: {
    register() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/register`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            this.$router.push({ path: '/login', query: { registration: 'success' } });
          } else {
            this.registrationErrors = true;
          }
        })

        .then((err) => console.error(err));
    },
  },
};
</script>

<style>

.backgroundimage{
background-image: url(../assets/loginbackgroundcapstone.jpg);
  /* background-size: 100%; */
  background-repeat: no-repeat;
  object-fit: cover;
  height: 100%;
  width: 100%;
  background-position: 50% 50%;
  position: absolute;
  top: 0;
  left: 0;
  z-index: -1;
}

.form-register {
    display: flex;
  /* width: 100%; */
  flex-wrap: wrap;
  background-color: #005c75;
  border-style: outset;
  text-align:justify;
  margin-left: 30%;
  margin-right: 30%;
  margin-top: 10%;
}

#username {
  font-size: 15px;
}

#password {
  font-size: 15px;
}

#confirmPassword {
  width: 100%;
  margin-top: 5%;
  height: 30px;
  border-style:inset;
  border-color: #005c75;
  font-size: 15px;
}

.createbutton{
font-size: 20px;
width: 100%;
justify-content: flex-end;
border-radius: 12px;
float: right;
opacity: 0.6;
background-color: #99ff94;
}

.createbutton:hover{
  background-color: white;
  color: #99ff94;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
  opacity: 1.0;
}

.createbutton:active{
  background-color: white;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}

a:-webkit-any-link {
  color: white;
  font-size: 15px;
}

a:-webkit-any-link:hover{
  font-size: 20px;
}


a:-webkit-any-link:visited {
  color: #99ff94;
}

</style>
