<template>
  <div class="home">
    <h1>Home</h1>
    <p>You made it</p>
    <button @click="displayMap">Submit</button>
  </div>
</template>

<script>
export default {
  name: 'home',
  components: {},
  data() {
    return {
      landmark: {
        name: '',
        zipcode: ''
      }
    }
  },
  methods: {
    displayMap() {
      fetch(`http://dev.virtualearth.net/REST/v1/Locations?locality=Greenville&maxResults=10&key=${apiKey}`, {
        method: 'GET'
      })
      .then((response) => {
        return response.json();
      })
      .then((json) => {
        console.log(json);
        this.landmark.name = json.name;
      })
      .catch((err) => console.error(err));
    }
  }
}

//const urlMap = 'http://dev.virtualearth.net/REST/v1/Locations/US/OH/43201/Columbus&maxResults={maxResults}&key=AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';
const apiKey = 'AmvR-c42ne6GrECkyJERi7B9mjs7vH-7OGFoG7jf405tiyb7huCJIfK1t_kn8S7m';

</script>
