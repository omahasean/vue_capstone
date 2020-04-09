<template>

  <div id="homePage" class="home">
    <Navbar/>
    <Sidebar/>
    <div class="content-home">
  
    <img v-bind:src=" imageSrc.src1 ">
    
    
    </div>
  </div>
  
</template>

<script>
import Sidebar from './Sidebar';
import Navbar from './Navbar';
export default {
  name: 'home',
  components: {
    Navbar,
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
      src: 'http://dev.virtualearth.net/REST/v1/Imagery/Map/Road/47.619048,-122.35384/15?mapSize=2000,700&pp=47.620495,-122.34931;21;AA&pp=47.619385,-122.351485;;AB&pp=47.616295,-122.3556;22&mapMetadata=0&format=jpeg&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m',
      src1: `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/${city}?mapSize=2000,1000&key=${apiKey}`
      },
      location: {
        latitude: '',
        longitude: '',
      },
      temp: []
    }
  },
  methods: {
    displayMap() {
      fetch(`${dummyURL}${apiKey}`, {
        method: 'GET'
      })
      .then((response) => {
        return response.json();
      })
      .then((json) => {
        console.log(json);
        // this.landmark.name = json.name;
      })
      .catch((err) => console.error(err));
    },
    
}
}
//const urlMap = 'http://dev.virtualearth.net/REST/v1/Locations/US/OH/43201/Columbus&maxResults={maxResults}&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const apiKey = 'AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const dummyURL = 'http://dev.virtualearth.net/REST/v1/Locations?locality=Columbus&postalCode=43201&maxResults=10&key='
const city = 'columbus';
</script>

<style scoped>
  /* .content-home{
   margin-left:310px
  } */

  img {
    margin: 0;
  }
</style>
