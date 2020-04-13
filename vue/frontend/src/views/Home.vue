<template>

  <div id="homePage" class="home">
    <Navbar/>
    <Sidebar @cityToHome="showNew" @pushpins="formatPins" @sendItenirary="formatWP"/>
  <div id="home" class="content-home">
    
    <img v-if="show === false" v-bind:src="showImage()">
    <!-- <img v-else v-bind:src=" imageSrc.src1 "> -->
    <img v-else-if="wp.length === 0" v-bind:src="getPins()">
    <img v-else v-bind:src="getWaypoints()">
    
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
      
      imageSrc : {
      src: 'http://dev.virtualearth.net/REST/v1/Imagery/Map/Road/47.619048,-122.35384/15?mapSize=2000,700&pp=47.620495,-122.34931;21;AA&pp=47.619385,-122.351485;;AB&pp=47.616295,-122.3556;22&mapMetadata=0&format=jpeg&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m',
      src1: `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/${city}?mapSize=2000,1000&key=${apiKey}`
      },
      location: {
        latitude: '',
        longitude: '',
      },
      temp: [],
      show: false,
      userCity: '',
      pins: '',
      pinsArray: [],
      wpArray: [],
      wp: ''
      
    
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

    showNew(city) {
      this.userCity = city;
      this.show = true;
      console.log(this.userCity);
    },

    showImage() {
      return `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/columbus?mapSize=2000,1000&key=${apiKey}`
    },
  

    getPins(){
      fetch(`https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/?mapSize=2000,1000&key=${apiKey}`, {
        method: 'POST',
        headers: {
        
          'Content-Type': 'text/plain; charset=utf-8' 
        },
          body: this.pins
        
        
      })
      .then((response) => {
        console.log(response.type);
        return response.blob();
      })
      .then((blob) => {
        let imageURL = URL.createObjectURL(blob);
        let img = document.createElement('img');
        img.src = imageURL;
        
        document.getElementById('home').appendChild(img);
      })
      
    },

    formatPins(results){
      this.pinsArray = results.map((e) => {
          return `pp=${e.latitude},-${e.longitude}`;
        });
      this.pins = '';
      this.pins = this.pinsArray.join('&');
      console.log(this.pins);
    },

    formatWP(iteniraryResults){
      this.wpArray = iteniraryResults.map((e) => {
          return `wp.${iteniraryResults.indexOf(e)+1}=${e.latitude},-${e.longitude}`;
        });
      this.wp = '';
      this.wp = this.wpArray.join('&');
      console.log(this.wp);
     
    },

    getWaypoints() {
      fetch(`https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/Routes/?${this.wp}&mapSize=2000,1000&key=${apiKey}`, {
        method: 'GET',

        headers: {
          'Content-Type': 'text/plain; charset=utf-8' 
        }
      })
      .then((response) => {
        console.log(response.type);
        return response.blob();
      })
      .then((blob) => {
        let imageURL = URL.createObjectURL(blob);
        let img = document.createElement('img');
        img.src = imageURL;
        document.getElementById('home').appendChild(img);
      })
    }

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
