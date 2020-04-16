<template>
  <div id="directions">
    <ul v-if="show === true">
      <option v-for="(direction,index) in newRoutes" :key="index">
        <li>{{direction}}</li>
      </option>
    </ul>
    <button @click="show = !show">Directions</button>
  </div>
</template>

<script>
export default {
  name: "Directions",

  props: {
    wp: String,
    wayPoints: Array,
    lat: Number,
    long: Number
  },

  data() {
    return {
      routeInfo: "",
      directions: [],
      subLegs: [],
      routeLegs: [],
      newRoutes: [],
      itineraryRoutes: [],
      newWPArray: [],
      points: "",
      show: false
    };
  },

  created() {
    console.log(this.wayPoints);
    this.newWPArray = this.wayPoints.map(e => {
      return `wp.${this.wayPoints.indexOf(e) + 2}=${e.latitude},-${
        e.longitude
      }`;
    });
    this.newWPArray.unshift(`wp.1=${this.lat},${this.long}`)
    this.points = "";
    this.points = this.newWPArray.join("&");
  },

  beforeMount() {
    fetch(
      `http://dev.virtualearth.net/REST/v1/Routes/Driving?${this.points}&o=json&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m`,
      {
        method: "GET",

        headers: {
          Accept: "application/json"
        }
      }
    )
      .then(response => {
        return response.json();
      })
      .then(json => {
        let numberOfStops = json.resourceSets[0].resources[0].routeLegs.length;
        this.newRoutes = [];
        for (let i = 0; i < numberOfStops; i++) {
          json.resourceSets[0].resources[0].routeLegs[i].itineraryItems.forEach(
            item => {
              this.newRoutes.push(item.instruction.text);
            }
          );
        }
      })
      .catch(err => console.log(err));
  }
};
</script>

<style>
#directions {
  color: white;
}
</style>