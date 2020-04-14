<template>
<div class="itinerary-list">
<div id="result" v-for="(result, index) in resultData" :key="index" v-bind:value="result">
    <ul>
    <div>
    <li @click="details" v-bind:value="showDetail">{{result.name}}</li>
    <p v-show="showDetail">{{result.streetAddress}} {{result.city}}, {{result.state}} {{result.zipCode}}<br>{{result.description}}</p>

    <input type="checkbox" id="result.name"  v-bind:value="result" v-model="itenirary">
    </div>
    </ul> 
    <hr id="line">
</div>
<input type="text" v-model="nameItinerary"/>
<button class="button-itinerary" type="button" @click="addItenirary">Create Itinerary</button>
<button class="save-itinerary" type="button" @click="saveItinerary">Save Tour</button>
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
            packagePost: {
                itineraryName: this.nameItinerary,
                itinerary: this.itenirary,
                username: auth.getUser().sub,
            }
        }
    },

    methods: {
        addItenirary() {
            this.$emit('populateItenirary', this.itenirary );
        },
        showDetails(){
            
            this.$emit('loadDetails', this.result)
        },
        details(){
            if(this.showDetail===false){
                this.showDetail=true;
            }
            else{
                this.showDetail=false;
            }
        },
        saveItinerary(){
            fetch(`${process.env.VUE_APP_REMOTE_API}/api/saveItinerary`,{
               method: 'POST',
               headers: {
                   Accept: 'application/json',
                   'Content-Type': 'application/json', 
               },
               body: JSON.stringify({
                itineraryName: this.nameItinerary,
                itinerary: this.itenirary,
                username: auth.getUser().sub,
            }),
               
            })
            .then((response)=>{
                if(response.ok){
                    console.log('ok');
                }
            })

        }
        // saveItinerary(){
        //     console.log(this.itenirary);
        // }

    },

    computed: {
        addKey(){
            return this.resultData.map((e) => {
                e.checked = false;
            })
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
    text-align: center;
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

</style>