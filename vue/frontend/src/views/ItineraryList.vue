<template>
  <div>
      <div class="userItineraries" v-for="(result, index) in userItineraries" :key="index" v-bind:value="result">
          <h3 @click="showItinerary">{{result.name}}</h3>
         <div>
             <option  v-for="(location, index) in result.locationList" :key="index">{{location.name}}</option>
             </div>
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
            itineraryNames: [],
            showArray: []
            // username: auth.getUser().sub, //this is not working currently(why)
        }
    },
    methods: {
        showItinerary(){
            

            
        }
    },

    beforeMount(){
        fetch(`${process.env.VUE_APP_REMOTE_API}/api/getUser/${auth.getUser().sub}`, {
          method: 'GET',
        headers: {
          Accept: 'application/json',
          'Content-Type': 'application/json'
        }
        })
        .then((response) =>{
            return response.json();
        })
        .then((json)=>{
            console.log(json);
         
            this.userItineraries = json;
            // json.forEach((e) => {
            //     this.itineraryNames.push(e.name);
            // });
        })
    }
}
</script>

<style>
.userItineraries {
    color: white;
}
</style>