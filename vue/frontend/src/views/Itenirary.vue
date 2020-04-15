<template>
<div class="itenirary-container">
    <h1>Your Itinerary</h1>
    <ul>

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
    display: grid;
    text-decoration: none;
    color: #99ff94 ;
    text-align: center;
    padding-right: 50px;
    border-bottom: solid;
}
</style>