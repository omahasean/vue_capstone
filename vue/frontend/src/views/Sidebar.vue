<template>
    <div class="sidebar">
        <h1 class="Logo">City Tours</h1>
        <ul class="tabs">
            <li @click="show">My Tours</li>
            <li @click="hide">New Tour</li>
        </ul>
        <SearchMap v-show="tour" @sendSearch="recieveData" @sendCity="sendCity"/>

        <div v-show="showComp === true">
        <ResultList v-show="tour" :resultData="searchData" @populateItenirary="listItenirary"/>

        
        <Itenirary v-show="tour" v-if="directions === false" :iteniraryData="itenirary"/>
       
       
        
        
        <button v-show="tour" type="button" @click="toggle">Toggle</button>
        
        </div>
<ItineraryList v-show="!tour" :lat="lat" :long="long"/>
    </div>
</template>


<script>
import SearchMap from "./SearchMap";
import ResultList from "./ResultList";
import Itenirary from './Itenirary';

import ItineraryList from "./ItineraryList";
import auth from "../auth"

export default {
    name: 'Sidebar',
    components: {
        SearchMap,
        ResultList,
        Itenirary,
        
        ItineraryList,

    },

    props: {
        waypoints: String,
        lat: Number,
        long: Number
    },

    data() {
        return {
            searchData : [],
            userCity: '',
            itenirary: [],
            directions: false,
            wp: '',
            tour: true,
            username: auth.getUser().sub,
            showComp: false,
            
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
            this.showComp = true;
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
        },
        show(){
            if(this.tour===true){
                this.tour=false;
            }
        },
        hide(){
            if(this.tour===false){
                this.tour=true;
            }
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
  position: fixed;
  z-index: 101; /* Stay on top */
  top: 0; /* Stay at the top */
  left: 0;
  background-color: #2e2e2e ; /* Black */
  overflow-x: hidden;
  padding-top: 10px;
  background-image: linear-gradient( #2e2e2e, Black);
}
.sidebar::-webkit-scrollbar {
  display: none;
}
.tabs {
  grid-template-columns: 1fr, 6fr, 1fr;
  grid-template-rows: auto;
  grid-template-areas:
    ". content .";
  list-style-type: none;
  overflow: hidden;
  top: 0;
  width: 300px;
}
.tabs li {
  grid-area: content;
  display: inline;
  margin: 10px;
  margin-left: -10px;
  border-top: 1px solid #005c75;
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
  padding-right: 42px;
  padding-left: 42px;
  font-family: 'Baloo Paaji 2', cursive;
  background-image: linear-gradient(#99ff94, #005c75);
}
.tabs li:first-of-type{
    margin-left: -39px;
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
.tabs li.active{
  background-color: #99ff94;
}
</style>