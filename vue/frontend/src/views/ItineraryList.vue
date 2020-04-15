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
    display: grid;
    text-align: center;
    background: radial-gradient(#2e2e2e, #2e2e2e, rgba(153, 255, 148, .1));
    border-radius: 30px;
    margin: 5px;
    padding: 0px;
}
.userItineraries h3{
    color:white;
    font-family: 'Roboto', sans-serif;
    font-size: 30px;
    line-height: .3;
}
.userItineraries h3:hover{
    color: #0ffc03;
}
.userItineraries option{
    font-family: 'Baloo Paaji 2', cursive;
}

</style>