<template>
<div id="result">
    <ul>
        <li v-for="(result, index) in resultData" :key="index">{{result.name}} {{result.streetAddress}}, {{result.city}} {{result.zipCode}}</li>
    </ul>
</div>
</template>

<script>
export default {
    name: 'ResultList',

    props: {
        resultData: Array
    }
}
</script>

<style>
#result {
    color: white;
}
</style>