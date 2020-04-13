<template>
    <div class="sidebar">
        <h1 class="Logo">City Tours</h1>
        <SearchMap @sendSearch="recieveData" @sendCity="sendCity"/>
        <ResultList :resultData="searchData" @populateItenirary="listItenirary"/>
        <ItineraryList/>
        
        <Itenirary v-if="directions === false" :iteniraryData="itenirary"/>
       
       
        <Directions :wp="wp" v-if="directions === true" />
        
        <button type="button" @click="toggle">Toggle</button>
    </div>
</template>


<script>
import SearchMap from "./SearchMap";
import ResultList from "./ResultList";
import Itenirary from './Itenirary';
import Directions from "./Directions";
import ItineraryList from "./ItineraryList";

export default {
    name: 'Sidebar',
    components: {
        SearchMap,
        ResultList,
        Itenirary,
        Directions,
        ItineraryList
    },

    props: {
        waypoints: String
    },

    data() {
        return {
            searchData : [],
            userCity: '',
            itenirary: [],
            directions: false,
            wp: ''
            
        }
    },

    methods: {
        recieveData(results) {
            this.searchData = results;
            this.$emit('pushpins', results);
            //console.log(results);
        },

        sendCity(city){
            this.userCity = city;
            this.$emit('cityToHome', city);
        },

        listItenirary(iteniraryArray) {
            this.itenirary = iteniraryArray;
            this.$emit('sendItenirary', iteniraryArray);
        },

        toggle() {
           if (this.directions === true) {
               this.directions = false;
           } else {
               this.directions = true;
           }
           console.log(this.wp);
        }
    },

    updated() {
        this.wp = this.waypoints;
    }

}
</script>

<style>
.sidebar{
    height: 100%; /* Full-height: remove this if you want "auto" height */
  width: 300px; /* Set the width of the sidebar */
  position: fixed; /* Fixed Sidebar (stay in place on scroll) */
  z-index: 1; /* Stay on top */
  top: 0; /* Stay at the top */
  left: 0;
  background-color: #2e2e2e ; /* Black */
  overflow-x: hidden; /* Disable horizontal scroll */
  padding-top: 10px;
  background-image: linear-gradient( #2e2e2e, Black);
}

h1 {
  color: white;
  position: relative;
  z-index: 10;
  text-align: center;
  margin-top:0;
}
.Logo{
    font-family: 'Lobster', cursive;
}

</style>