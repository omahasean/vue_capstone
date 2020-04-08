<template>
  <div class="container">
    <h2>Start Your Own Tour</h2>
      <form class="form">
            <input type="text"  class="search" placeholder="Please Enter a City" v-model.trim="cityName"/>
            <!-- <input type="submit" class="button" value="submit" @click="searchCity"> -->
           <button class="button" @click="searchCity">Submit</button>

           

      </form>
      <hr id="line">
  </div>

</template>

<script>
export default {
  name: 'searchMap',
  

data() {
  return {
    cityName: '',
    landmarkArray: []
  }
},
methods: {
  searchCity(cityName) {
      fetch(`${process.env.VUE_APP_REMOTE_API}/api/search/${cityName}`, {
        method: 'GET',
        headers: {
          
          Accept: 'application/json',
          'Content-Type': 'application/json'
          
        }
      })
      .then((response) => {
        console.log('contact');
        return response.json();
      })
      .then((json) => {
        console.log(json);
        this.landmarkArray = json;
        console.log(this.landmarkArray);
       
      })
      .catch((err) => console.error(err));
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
  h1{
    color:white;
  }
</style>