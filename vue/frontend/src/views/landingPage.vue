<template>
<div class="page">
    <Navbar/>
    <div class="landingImg">
        <landingImage/>
    </div>
    <!-- <div class="slides">
        <landingPhotoSlideshow/> 
    </div> -->
    <div class="landing-details">
        <landingPageDetails/>
    </div>
</div>
</template>

<script>
import landingImage from "./landingImage"
import Navbar from "./Navbar"
// import landingPhotoSlideshow from "./landingPhotoSlideshow"
import landingPageDetails from "./landingPageDetails"
export default {
    components: {
        landingImage,
        Navbar,
        // landingPhotoSlideshow,
        landingPageDetails
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
.slides{
    grid-area: slides;
    position: relative;
}
.landing-details{
    grid-area: landing-details;
    display:flex;
    position:fixed;
}
</style>