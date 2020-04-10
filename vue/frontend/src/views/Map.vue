<template>
     <div id="home" class="content-home">
    
    <img v-if="show === true" v-bind:src="showImage()">
    <!-- <img v-else v-bind:src=" imageSrc.src1 "> -->
    <img v-else v-bind:src="getPins()">
    
    </div>
</template>

<script>
export default {
    name: 'Map',

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
      pins: ''
    
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
      return `https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/${this.userCity}?mapSize=2000,1000&key=${apiKey}`
    },
  

    getPins(){
      fetch(`https://dev.virtualearth.net/REST/v1/Imagery/Map/Road/columbus?mapSize=2000,1000&key=${apiKey}`, {
        method: 'POST',
        headers: {
        
          'Content-Type': 'text/plain; charset=utf-8' 
        },

        // body: 'pp=38.889586530732335,-77.05010175704956;23;LM\r\npp=38.88772364638439,-77.0472639799118;7;KM\r\n'
        
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
},

}
const apiKey = 'AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const dummyURL = 'http://dev.virtualearth.net/REST/v1/Locations?locality=Columbus&postalCode=43201&maxResults=10&key='
const city = 'columbus';
</script>

<style>

</style>