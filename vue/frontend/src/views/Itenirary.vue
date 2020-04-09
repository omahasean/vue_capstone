<template>
<div class="itenirary-container">
    <h1>Your Itenirary</h1>
    <ul>
        <li v-for="(result, index) in iteniraryData" :key="index">{{result.name}} {{result.streetAddress}}, {{result.city}} {{result.zipCode}}</li> 
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

</style>