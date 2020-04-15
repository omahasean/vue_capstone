<template>
<div class="page">
    <Navbar/>
    <div class="landingContent">
        <landingContent/>
    </div>
</div>
</template>

<script>
import landingContent from "./landingContent"
import Navbar from "./Navbar"
export default {
    components: {
        landingContent,
        Navbar,

    }

}
</script>

<style>
.page{
    grid-template-areas: 
    "landingImg"
    "Slides"
    "landing-details";
    display:grid;
}
.landingImg{
    grid-area: landingImg;
    display: flex;
    position: fixed;
}

</style>