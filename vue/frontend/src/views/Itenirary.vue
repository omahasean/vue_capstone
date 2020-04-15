<template>
<div class="itenirary-container">
    <h1>Your Itinerary</h1>
    <ul class="itinerary-display">

        <li class="itinerary" v-for="(result, index) in iteniraryData" :key="index">
            <h4>{{result.name}}</h4>
            <p>{{result.streetAddress}}, {{result.city}} {{result.zipCode}}</p>
        </li> 

    </ul>
</div>
    
</template>

<script>
export default {
    name: 'Itenirary',

    props: {
        iteniraryData: Array
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
</style>