<template>
<div class="itenirary-container">
    <h1>Tour Itinerary</h1>
    <ul class="itinerary-display">

        <li class="itinerary" v-for="(result, index) in iteniraryData" :key="index">
            <h4>{{result.name}}</h4>
            <p>{{result.streetAddress}}, {{result.city}} {{result.zipCode}}</p>
        </li> 

    </ul>
    <div id="itinerary-Name">
    <label for="itineraryName">Itinerary Name  </label>
    <input id="itineraryName" type="text" v-model.trim="nameItinerary"/>
    <button class="button-itinerary" type="button" @click="saveItinerary()">Save Tour</button>
    </div>
</div>
    
</template>

<script>
import auth from "../auth.js"
export default {
    name: 'Itenirary',
    
    data(){
        return{
        nameItinerary: '',
        username: auth.getUser().sub,
        }
    },
    props: {
        iteniraryData: Array
    },
    methods:{
     saveItinerary(){
         console.log(this.itinerary)
         console.log(this.iteniraryData)
         console.log(this.nameItinerary)
         console.log(this.username)
        fetch(`${process.env.VUE_APP_REMOTE_API}/api/saveItinerary/${this.username}/${this.nameItinerary}`,{
               method: 'POST',
               headers: {
                   Accept: 'application/json',
                   'Content-Type': 'application/json', 
            },
               body: JSON.stringify(this.iteniraryData),
               
            })
    }
    }
}
</script>

<style>
h1{
    font-family: 'Roboto', sans-serif;
}
li {
    list-style-type: none;
}
.itinerary{
    color: white;
    display: flex;
    flex-direction: column;
    text-align: center;
    background: radial-gradient(#2e2e2e, rgba(0, 92, 117, .1));
    border-radius: 30px;
    margin: 5px;
    padding: 10px;
}
.itinerary-display{
    display: flex;
    flex-direction: column;
    align-content: center;
    list-style-type: none;
    margin-block-start: 0px;
    margin-block-end: 0px;
    padding-inline-start: 0px;
}
#itinerary-Name{
    color:rgba(153, 255, 148, 1);
    font-family: 'Open Sans', sans-serif;
    display: flex;
    flex-direction: column;
    justify-content: center;

    justify-items: center;
    align-self: center;
    padding: 5px;
}
#itinerary-Name button{
    margin-top: 10px;
}
#itinerary-Name label{
    align-self: center;
    padding-left: 15px;
    padding-bottom: 5px;
    font-family: 'Open-Sans', sans-serif;
}


</style>