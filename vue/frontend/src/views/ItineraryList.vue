<template>
  <div>
    <div
      class="userItineraries"
      v-for="(result, index) in addKey"
      :key="index"
      v-bind:value="result"
    >
      <h3 @click="showItinerary(result)">{{result.name}}</h3>
      <button id="delete" @click="deleteItinerary(result)">Delete</button>
      <!-- <div v-if="result.show === true">
        <option v-for="(location, index) in result.locationList" :key="index">{{location.name}}</option> -->
        <!-- <button @click="showDirections" >Directions</button> -->
        <Directions :wayPoints="result.locationList" :lat="lat" :long="long" />
      <div class="itinItems" v-if="result.show === true">
        <li v-for="(location, index) in result.locationList" :key="index">{{location.name}}</li>
        <!-- <button @click="showDirections" >Directions</button> -->
        <div id="directions">
       <Directions :wayPoints="result.locationList" :lat="lat" :long="long" />
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import auth from "../auth";
import Directions from "./Directions";

export default {
  name: "ItineraryList",

 components: {
     Directions
 },

 props: {
     lat: Number,
     long: Number
 },
  data() {
    return {
      userItineraries: [],
      itineraryNames: [],
      showArray: []
      // username: auth.getUser().sub, //this is not working currently(why)
    };
  },
  methods: {
    showItinerary(result) {
      if (result.show === false) {
        result.show = true;
        this.$forceUpdate();
      } else {
        result.show = false;
        this.$forceUpdate();
      }
    },

    deleteItinerary(result){
console.log(result.itineraryId);
fetch(
`${process.env.VUE_APP_REMOTE_API}/api/delete/${auth.getUser().sub}/${result.itineraryId}`,
{
method: "DELETE",
headers:{
Accept: "application/json",
"Content-Type": "application/json"
}
})
.then(response=>{
return response.json();

});
  }},

  computed: {
    addKey() {
      let holderArray = this.userItineraries;
      holderArray.forEach(e => {
        e.show = false;
      });
      return holderArray;
    }
  },

  mounted() {
    fetch(
      `${process.env.VUE_APP_REMOTE_API}/api/getUser/${auth.getUser().sub}`,
      {
        method: "GET",
        headers: {
          Accept: "application/json",
          "Content-Type": "application/json"
        }
      }
    )
      .then(response => {
        return response.json();
      })
      .then(json => {
        console.log(json);

        this.userItineraries = json;
        // json.forEach((e) => {
        //     this.itineraryNames.push(e.name);
        // });
      });
  
  }
}
 
</script>

<style>
.userItineraries {
  color: white;
  display: grid;
  /* grid-template-areas: "h3"
                         "option"
                         "directions"; */
    text-align: center;
    background: radial-gradient(#2e2e2e, #2e2e2e, rgba(153, 255, 148, .1));
    border-radius: 30px;
    margin: 5px;
    padding: 0px;
    z-index: 102;
    max-width: 300px;
}
.userItineraries h3 {
  /* grid-area: h3; */
  color: white;
  font-family: "Roboto", sans-serif;
  font-size: 30px;
  line-height: 0.3;
  z-index: 103;
}
.userItineraries h3:hover {
  color: #0ffc03;
}
.itinItems{
    font-family: 'Baloo Paaji 2', cursive;
    font-size: 20px;
}
#directions{
  width: 300px;
}
</style>