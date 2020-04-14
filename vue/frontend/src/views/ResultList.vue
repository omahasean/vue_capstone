<template>
<div class="itinerary-list">
<div id="result" v-for="(result, index) in addKey" :key="index"  >
   
    <div>
    <p @click="details(result)">{{result.name}}</p>


    <!-- <p v-show="showDetail">{{result.streetAddress}} {{result.city}}, {{result.state}} {{result.zipCode}}<br>{{result.description}}</p> -->
<p v-if="result.show">{{result.streetAddress}} {{result.city}}, {{result.state}} {{result.zipCode}}<br>{{result.description}}</p>
    </div>
    <div>
    <input type="checkbox"  v-bind:value="result" :id="result.name" v-model="itenirary">
    </div>
    
    <hr id="line">
</div>
<button class="button-itinerary" type="button" @click="addItenirary">Create Itinerary</button>
</div>
</template>

<script>
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
            }
            else{
                result.show = false;
            }
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
    grid-area: result;
    color: white;
    text-align: center;
}

/* #result ~ h5 {
    display: none;
}

#result ~ h5:active {
    display:inline-block;
} */
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