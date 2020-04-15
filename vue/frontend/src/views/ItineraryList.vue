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
}
</style>