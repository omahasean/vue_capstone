<template>
<div class="itinerary-list">
    
<div id="result" v-for="(result, index) in addKey" :key="index"  >
   
    <div>
    <p id="resultName" @click="details(result)">{{result.name}}</p>


    
<p id="resultDetail" v-if="result.show">{{result.streetAddress}}<br>{{result.city}}, {{result.state}} {{result.zipCode}}<br><br>{{result.description}}</p>
    </div>
    <div>
    <input type="checkbox"  v-bind:value="result" :id="result.name" v-model="itenirary">
    </div>
    

</div>
<div id="itinerary-Name">
<label for="itineraryName">Itinerary Name:  </label>
<input id="itineraryName" type="text" v-model.trim="nameItinerary"/>
</div>
<button class="button-itinerary" type="button" @click="addItenirary(); saveItinerary()">Create Itinerary</button> 
<input type="text" v-model.trim="nameItinerary"/>

</div>
</template>

<script>
import auth from '../auth'
export default {
    name: 'ResultList',

    props: {
        resultData: Array
    },

    data() {
        return {
            itenirary: [],
            checked: false,
            selected: [],
            showDetail: false,
            detail: [],
            nameItinerary: '',
            username: auth.getUser().sub,
            
        }
    },

    methods: {
        addItenirary() {
            this.$emit('populateItenirary', this.itenirary );
        },
        showDetails(){
            
            this.$emit('loadDetails', this.result)
        },
        details (result){
            if(result.show === false){
                result.show = true;
                this.$forceUpdate();
            }
            else{
                result.show = false;
                this.$forceUpdate();
            }
        },
        saveItinerary(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/saveItinerary/${this.username}/${this.nameItinerary}`,{
               method: 'POST',
               headers: {
                   Accept: 'application/json',
                   'Content-Type': 'application/json', 
               },
               body: JSON.stringify(this.itenirary),
               
            })
            // .then((response)=>{
               
            
            // })

        }
        

    },
    computed: {
        addKey(){
            let holderArray = this.resultData;
            holderArray.forEach((e) => {
                e.show = false;
            });
            return holderArray;
        }
    }
}

</script>

<style>
.itinerary-list{
    grid-template-areas: 1fr, 6fr, 1fr;
        grid-template-rows: auto;
    grid-template-areas:
    ". result ."
    ". button ." 
}
#result {
    color: white;
    display: grid;
    text-align: center;
    background: radial-gradient(#2e2e2e, #2e2e2e, rgba(153, 255, 148, .1));
    border-radius: 30px;
    margin: 5px;
    padding: 10px;
}
#resultName{
    font-family: 'Open Sans', sans-serif;
    font-size: 18px;
}
#resultDetail{
    font-family: 'Roboto', sans-serif;
}
.button-itinerary{
    grid-area: button;
    margin-left: 4em;
    width: 50%;
    height: 20%;
    padding: 3px;
    font-size: 20px;
    font-family: 'Lobster', cursive;
}
#itinerary-Name{
    color:rgba(153, 255, 148, 1);
    font-family: 'Open Sans', sans-serif;
    display: flex;
    justify-content: center;
    margin: 10px;
}
#itinerary-Name label{
    padding-right: 5px;
}

/* #itinerary-grid{
    display: grid;
    grid-template-areas: "name box"
                         "details details";
    align-items: center;
}

#name {
    grid-area: name;
    margin-right: 0px;
    padding-left: 0px;
}

#box {
    grid-area: box;
    margin-left: 0px;
    padding-right: 0px;
}

#details {
    grid-area: details;
} */

</style>