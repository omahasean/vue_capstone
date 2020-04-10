<template>
<div>
  <Navbar />
  <div id="login" class="text-center">
    <div class="backgroundimage">
    <form class="form-signin" @submit.prevent="login">
      
      <div>
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      </div>
      <div class="invalidalert" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div class="thanksalert" role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
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
      <div class="accountcreate">
      <router-link :to="{ name: 'register' }">Need an account?</router-link>
      <button class="button" type="submit">Sign in</button>
      </div>
    </form>
  </div>
  </div>
</div>
</template>

<script>
import auth from '../auth';
import Navbar from './Navbar'

export default {
  name: 'login',
  components: {
    Navbar
  },
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/login`, {
        method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user),
      })
        .then((response) => {
          if (response.ok) {
            return response.text();
          } else {
            this.invalidCredentials = true;
          }
        })
        .then((token) => {
          if (token != undefined) {
            if (token.includes('"')) {
              token = token.replace(/"/g, '');
            }
            auth.saveToken(token);
            this.$router.push('/');
          }
        })
        .catch((err) => console.error(err));
    },
  },
};
</script>

<style>

.backgroundimage{
background-image: url(../assets/loginbackgroundcapstone.jpg);
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


#login{
  justify-content: center;
  width: 60%;
}

.form-signin{
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  background-color: #005c75;
  border-style: outset;
  text-align:justify;
  margin-left: 30%;
  margin-right: 30%;
  margin-top: 10%;

}

 .sr-only{
   display: flex;
   flex-wrap: wrap;
   width: 100%;
   font-size: 25px;
   padding-top: 5%;
   padding-bottom: 5%;
   justify-content: center;
   color: white;
}

#username{
  width: 100%;
  height: 30px;
  justify-content: center;
  border-style:inset;
  border-color: #005c75;
  color: white;
  padding: 0px;
}

#password{
  width: 100%;
  border-style:inset;
  border-color: #005c75;
  height: 30px;
}

h1{
  grid-area: Title;
  font-size: 35px;
  justify-content: center;
  width: 100%;
  color: white;

}

.invalidalert{
  width: 100%;
  color: #99ff94;
  justify-content: center;
  font-size: 20px;
  text-align: center;
}

.thanksalert{
  width: 100%;
  color: #99ff94;
  justify-content: center;
  font-size: 20px;
  text-align: center;
}

.accountcreate{
  padding-top: 5%;
  grid-area: Createaccount;
  display: inline-block;
  width: 100%;
  justify-content: right;
  color: white;
}


.button{
font-size: 20px;
justify-content: flex-end;
border-radius: 12px;
float: right;
opacity: 0.6;
background-color: #99ff94;
}

.button:hover{
  background-color: white;
  color: #99ff94;
  box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24), 0 17px 50px 0 rgba(0,0,0,0.19);
  opacity: 1.0;
}

.button:active{
  background-color: white;
  box-shadow: 0 5px #666;
  transform: translateY(4px);
}



</style>
