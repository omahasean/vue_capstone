<template>

  <div id="homePage" class="home">
    <Sidebar/>
    <div class="content-home">
    <h1>City Tours</h1>
      
    <button @click="displayMap">Submit</button>
    <button @click="getLocations">Submit</button>
   
    <button @click="getCoordinates">GetCoordinates</button>
    <!-- <button @click="showMap">Map</button> -->
    <img v-bind:src=" imageSrc.src1 ">
    <option v-for="(landmarkObject, index) in landmarkArray" v-bind:value="index" v-bind:key="index">{{ landmarkObject.name }}</option>
    
    </div>
  </div>
  
</template>

<script>
import Sidebar from './Sidebar';
export default {
  name: 'home',
  components: {
    Sidebar
  },
  data() {
    return {
      landmarkArray: [],
      // landmark: {
      //   name: '',
      //   zipcode: '',
      //   streetAddress: '',
      //   state: '',
      //   city: '',
    
      // },
      imageSrc : {
      src: 'http://dev.virtualearth.net/REST/v1/Imagery/Map/Road/47.619048,-122.35384/15?mapSize=2000,1000&pp=47.620495,-122.34931;21;AA&pp=47.619385,-122.351485;;AB&pp=47.616295,-122.3556;22&mapMetadata=0&format=jpeg&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m',
      src1: `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/${city}?mapSize=500,400&key=${apiKey}`
      },
      location: {
        latitude: '',
        longitude: '',
      },
      temp: []
    }
  },
  methods: {
    getCoordinates() {
     fetch(`http://dev.virtualearth.net/REST/v1/Locations/US/WA/Redmond/1%20Microsoft%20Way?&key=${apiKey}`, {
       method: 'GET'
     })
     .then((response) => {
       return response.json();
     })
     .then((json) => {
       console.log(json);
      this.temp = json;
      console.log(this.temp);
      //this.location.longitude = json.
     })
     .catch((err) => console.log(err));
   },
    displayMap() {
      fetch(`${dummyURL}${apiKey}`, {
        method: 'GET'
      })
      .then((response) => {
        return response.json();
      })
      .then((json) => {
        console.log(json);
        this.landmark.name = json.name;
      })
      .catch((err) => console.error(err));
    },
    getLocations() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/search`, {
        method: 'GET',
        headers: {
          
          Accept: 'application/json',
          'Content-Type': 'application/json'
          
        }
      })
      .then((response) => {
        return response.json();
      })
      .then((json) => {
        this.landmarkArray = json;
          
        
        // console.log(json);
        // console.log(this.landmarkArray);
       
      })
      .catch((err) => console.error(err));
    }
  }
}

//const urlMap = 'http://dev.virtualearth.net/REST/v1/Locations/US/OH/43201/Columbus&maxResults={maxResults}&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const apiKey = 'AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const dummyURL = 'http://dev.virtualearth.net/REST/v1/Locations?locality=Columbus&postalCode=43201&maxResults=10&key='
const city = 'columbus';
</script>

<style scoped>
  .content-home{
   margin-left:310px
  }
</style>
