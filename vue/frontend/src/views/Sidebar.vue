<template>
    <div class="sidebar">
        <h1>City Tours</h1>
        <SearchMap @sendSearch="recieveData"/>
        <ResultList :resultData="searchData"/>
    </div>
</template>


<script>
import SearchMap from "./SearchMap";
import ResultList from "./ResultList";
export default {
    name: 'Sidebar',
    components: {
        SearchMap,
        ResultList
    },

    data() {
        return {
            searchData : []
        }
    },

    methods: {
        recieveData(results) {
            this.searchData = results;
            console.log(results);
        }
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
}

h1 {
  color: white;
  position: relative;
  z-index: 10;
  text-align: center;
  margin-top:0;
}


</style>