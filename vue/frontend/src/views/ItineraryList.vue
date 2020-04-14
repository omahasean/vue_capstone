<template>
  <div>
      <div class="userItineraries" v-for="(result, index) in userItineraries" :key="index" v-bind:value="result">
          <h3>{{result.name}}</h3>
      </div>
  </div>
</template>

<script>
import auth from '../auth';
export default {
    name:'ItineraryList',


    data() {
        return {
            userItineraries: [],
            user: auth.getUser(), //this is not working currently(why)
        }
    },
    methods: {
        
    },

    beforeMount(){
        fetch(`${process.env.VUE_APP_REMOTE_API}/api/getUser/`, {
          method: 'POST',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(this.user)
        })
        .then((response) =>{
            return response.json();
        })
        .then((json)=>{
            console.log(json);
        })
    }
}
</script>

<style>

</style>