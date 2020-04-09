<template>
  <div class="container">
    <div id="form=box">
    <h2>Start Your Own Tour</h2>
      <form class="form">
            <input type="text"  class="search" placeholder="Please Enter a City" v-model.trim="cityName"/>
            <!-- <input type="submit" class="button" value="submit" @click="searchCity"> -->
           
           <div id="list">
           
           <select v-model.number="radius">
             <option disabled value="">Miles away</option>
             <option value="5">5</option>
             <option value="10">10</option>
             <option value="25">25</option>
           </select>
           </div>

           <button class="button" type="button" @click="searchCity(); sendCity(); getCoordinates()" >Submit</button>
           <!-- <button class="button" type="button" @click="$emit('passInofrmation')">Submit</button> -->
      </form>
      <hr id="line">
    </div>
  <div class="results">
    <ul>
      <li v-for="(landmark, index) in landmarkArray" :key="index">{{landmark.name}} {{landmark.streetAddress}}, {{landmark.city}} {{landmark.zipCode}}</li>
    </ul>    
  </div>
  </div>
</template>

<script>
export default {
  name: 'searchMap',
  

data() {
  return {
    cityName: '',
    landmarkArray: [],
    radius: 0,
    location: {
      lon: 0,
      lat: 0
    }
  }
},
methods: {
  searchCity() {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/search/${this.location.lat}/${this.location.lon}/${this.radius}`, {
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
        //console.log(json);
        // this.landmarkArray = json;
        this.$emit('sendSearch', json);
        
       
      })
      .catch((err) => console.error(err));
    },

    sendCity(){
      this.$emit('sendCity', this.cityName.toLowerCase());
      
    },

    getCoordinates() {
      fetch(`https://geocode.xyz/?locate=${this.cityName}&geoit=JSON&auth=629009026059708430417x5389`, {
        method: 'GET',
        headers: {
          Accept: 'application/json',
          
        }
      })
      .then((response) => {
        return response.json();
      })
      .then((json) => {
        this.location.lat = Math.abs(json.latt);
        this.location.lon = Math.abs(json.longt);
        console.log(`${this.location.lon}`+ ' ' + `${this.location.lat}`);
      })
      .catch((err) => console.log(err));
    }
  }
  }

</script>

<style>
  .content{
    padding-right: 30px;
  }
  .form{
    display: grid;
    grid-template-columns: 1fr, 6fr, 1fr;
    grid-template-rows: auto;
    grid-template-areas:
      ". search ."
      ". radius ."
      ". button ."
}
  .search{
    grid-area: search;
    justify-self: center;
    width: 100%;
    margin-bottom: 1em;
  }
  .button{
    grid-area: button;
    width: 100%;
    height: 20%;
    padding-bottom: 30px;
  }
  #line{
    margin-top: 1em;
    border-color: #99ff94;
    width: 15em;
    }
  h2{
    display: flex;
    justify-content: center;
    align-self: center;
    color:#99ff94
  }
  .results{
    color:white;
  }

  #list {
    grid-area: radius;
    color: white;
  }
</style>