<template>
<div class="itinerary-list">
<div id="result" v-for="(result, index) in resultData" :key="index" v-bind:value="result">
    <div>
    <router-link :to="{name:'details'}">{{result.name}}</router-link>
    <input type="checkbox" id="result.name"  v-bind:value="result" v-model="itenirary">
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
            selected: []
        }
    },

    methods: {
        addItenirary() {
            this.$emit('populateItenirary', this.itenirary );
        },
        showDetails(){
            
            this.$emit('loadDetails', this.result)
        }
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
    width: 100%;
    height: 20%;
    padding: 3px;
    font-size: 20px;
    font-family: 'Lobster', cursive;
}

</style>