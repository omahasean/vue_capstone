<template>
<div>
<div id="result" v-for="(result, index) in resultData" :key="index">
    <div>
    <h3> {{result.name}}</h3>
    <input type="checkbox" id="result.name"  v-bind:value="result" v-model="itenirary">
    </div> 
    <hr id="line">
</div>
<button type="button" @click="addItenirary">Create Itenirary</button>
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
            checked: false
        }
    },

    methods: {
        addItenirary() {
            this.$emit('populateItenirary', this.itenirary );
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
#result {
    color: white;
    text-align: center;
}

</style>