<template>
  <div>
    <div
      class="userItineraries"
      v-for="(result, index) in addKey"
      :key="index"
      v-bind:value="result"
    >
      <h3 @click="showItinerary(result)">{{result.name}}</h3>
      <div v-if="result.show === true">
        <option v-for="(location, index) in result.locationList" :key="index">{{location.name}}</option>
      </div>
    </div>
  </div>
</template>

<script>
import auth from "../auth";
export default {
  name: "ItineraryList",

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
    }
  },

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
    text-align: center;
    background: radial-gradient(#2e2e2e, #2e2e2e, rgba(153, 255, 148, .1));
    border-radius: 30px;
    margin: 5px;
    padding: 0px;
    z-index: 102;
}
.userItineraries h3{
    color:white;
    font-family: 'Roboto', sans-serif;
    font-size: 30px;
    line-height: .3;
    z-index: 103;
}
.userItineraries h3:hover{
    color: #0ffc03;
}
.userItineraries option{
    font-family: 'Baloo Paaji 2', cursive;
}

</style>