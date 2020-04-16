<template>

  <div id="homePage" class="home">
    <Navbar/>
   
    <Sidebar @cityToHome="showNew" @pushpins="formatPins" @sendItenirary="formatWP" :waypoints="wp" :lat="currentLat" :long="currentLong"/>
  <div id="home" class="content-home">
    
    <img v-if="show === false" v-bind:src="showImage()">
    <!-- <img v-else v-bind:src=" imageSrc.src1 "> -->
    <!-- <img id="pinImage" v-else-if="wp.length === 0" v-bind:src="getPins()">
    <img id="waypointImage" v-else v-bind:src="getWaypoints()"> -->
 <img id="pinImage"   v-bind:src="getPins()">
    <img id="waypointImage"   v-bind:src="getWaypoints()">
   
    
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
      wp: '',
      showPin: false,
      currentLat: 0,
      currentLong: 0
      
    
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
      this.showPin = true;
      console.log(this.userCity);
    },

    showImage() {
      
      return `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/${this.currentLat},${this.currentLong}/15?mapSize=2000,1000&pp=${this.currentLat},${this.currentLong}&key=${apiKey}`
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
        // document.getElementById('home').r
        let imageURL = URL.createObjectURL(blob);
        let img = document.createElement('img');
        img.src = imageURL;
        img.id = 'pins';
        
        
        let routeImage = document.getElementById('waypointImg');
        if(routeImage != null) {
          document.getElementById('home').removeChild(routeImage)
        }

        if(document.getElementById('pins') != null) {
          document.getElementById('home').removeChild('pins')
        }
        // if(){
          document.getElementById('home').appendChild(img);
        // } else {
        // document.getElementById('home').replaceChild(img);
        // }
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
        img.id = 'waypointImg'

        let pinImage = document.getElementById('pins');
        pinImage.parentNode.removeChild(pinImage);
          // document.getElementById('home').removeChild(document.getElementById('pins'));

        document.getElementById('home').appendChild(img);
       
        // document.getElementById('home').replaceChild(img, pinImage);
      })
    },

    showPosition(position) {
  
    this.currentLat = position.coords.latitude;
    this.currentLong = position.coords.longitude;
    console.log(this.currentLat);
}
  },

  created() {
    
  // if (navigator.geolocation) {
    navigator.geolocation.watchPosition(this.showPosition);
   
  // } else { 
  //   x.innerHTML = "Geolocation is not supported by this browser.";
  // }
},




   

}

  
  
    





//const urlMap = 'http://dev.virtualearth.net/REST/v1/Locations/US/OH/43201/Columbus&maxResults={maxResults}&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const apiKey = 'AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const dummyURL = 'http://dev.virtualearth.net/REST/v1/Locations?locality=Columbus&postalCode=43201&maxResults=10&key='
const city = 'columbus';

</script>

<style scoped>

  img {
    margin: 0;
  }

 #home button{
   margin-left: 400px;
   height: 100px;
   width: 100px;
   left: 50%;
 }
</style>
